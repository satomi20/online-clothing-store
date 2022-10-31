package com.daniel.sms.onlineclothingstore.configuration;

import com.daniel.sms.onlineclothingstore.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
@ComponentScan
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserServiceImpl userService;

    private final PasswordConfig passwordConfig;


    @Autowired
    public WebSecurityConfig(UserServiceImpl userService, PasswordConfig passwordConfig) {
        this.userService = userService;
        this.passwordConfig = passwordConfig;

    }



    @Bean("authenticationManager")
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordConfig.getPasswordEncoder());
    }

    /*@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService)
                .passwordEncoder(passwordConfig.getPasswordEncoder());
    }*/


   @Override
    public void configure(WebSecurity web) throws Exception{
        web.ignoring().antMatchers("/webjars/**", "/js/**","/error/**", "/templates/**"
                , "/css/**","/fonts/**","/libs/**","/img/**","/product_img/**","/h2-console/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                /*.antMatchers("/", "/login", "/logout").permitAll()*/
                .antMatchers("/user/**").access("hasRole('ROLE_USER')").antMatchers("/admin/**").denyAll()
                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                .and()
                .formLogin()
                .loginPage("/login")
                .successHandler(myAuthenticationSuccessHandler())
                /*.defaultSuccessUrl("/user/profile ")*/
                .failureUrl("/login?error=true")
                .permitAll()
                /*.usernameParameter("email")//
                .passwordParameter("password")*/
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/login").permitAll();

        http.csrf().disable();
        http.headers().frameOptions().disable();
    }

    @Bean
    public AuthenticationSuccessHandler myAuthenticationSuccessHandler(){
        return new AuthenticationHandler();
    }
}
