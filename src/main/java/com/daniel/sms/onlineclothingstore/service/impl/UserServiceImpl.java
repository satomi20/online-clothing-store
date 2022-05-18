package com.daniel.sms.onlineclothingstore.service.impl;

import com.daniel.sms.onlineclothingstore.configuration.SecurityConfig;
import com.daniel.sms.onlineclothingstore.entity.User;
import com.daniel.sms.onlineclothingstore.entity.UserAddress;
import com.daniel.sms.onlineclothingstore.enums.Role;
import com.daniel.sms.onlineclothingstore.repository.UserRepository;
import com.daniel.sms.onlineclothingstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final com.daniel.sms.onlineclothingstore.configuration.SecurityConfig securityConfig;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, SecurityConfig securityConfig) {
        this.userRepository = userRepository;
        this.securityConfig = securityConfig;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        final User user = userRepository.findByEmail(email);
        if(user == null) {
            throw new UsernameNotFoundException("Пользователь не найден");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), Collections.singletonList(user.getUserRole()));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }


    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public boolean addUser(User user) {
        User databaseUser = userRepository.findByEmail(user.getEmail());
        if (databaseUser != null) {
            return false;
        }
        user.setUserRole(com.daniel.sms.onlineclothingstore.enums.Role.ROLE_USER);
        user.setEmail(user.getEmail());
        user.setPassword(securityConfig.getPasswordEncoder().encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }

    @Override
    public void updatePassword(User user, String password, String newPassword) {
        if (securityConfig.getPasswordEncoder().matches(password, user.getPassword())) {
            user.setPassword(securityConfig.getPasswordEncoder().encode(newPassword));
            userRepository.save(user);
        }
    }

    @Override
    public void updateEmail(User user, String email, String newEmail) {
        if (user.getEmail().equals(email)) {
            user.setEmail(newEmail);
            userRepository.save(user);
        }
    }

    @Override
    public void updateProfile(User user, String firstName, String lastName, String phoneNumber) {
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPhoneNumber(phoneNumber);
        userRepository.save(user);
    }

    @Override
    public User deleteUser(User user) {
        if (user.getUserRole().equals(Role.ROLE_ADMIN)){
            userRepository.delete(user);
        }
        return user;
    }
}
