package com.daniel.sms.onlineclothingstore.configuration;

import lombok.NoArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;


public class AuthenticationHandler implements AuthenticationSuccessHandler {

    SimpleUrlAuthenticationSuccessHandler userSuccessHandler = new SimpleUrlAuthenticationSuccessHandler("/user/profile");
    SimpleUrlAuthenticationSuccessHandler adminSuccessHandler = new SimpleUrlAuthenticationSuccessHandler("/admin/profile");

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for (GrantedAuthority authority : authorities) {
            if (authority.getAuthority().equals("ROLE_ADMIN")) {
                adminSuccessHandler.onAuthenticationSuccess(request, response, authentication);
                return;
            }
        }
        this.userSuccessHandler.onAuthenticationSuccess(request, response, authentication);

    }
}
