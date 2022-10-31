package com.daniel.sms.onlineclothingstore.service.impl;

import com.daniel.sms.onlineclothingstore.configuration.PasswordConfig;

import com.daniel.sms.onlineclothingstore.entity.Role;
import com.daniel.sms.onlineclothingstore.entity.User;
import com.daniel.sms.onlineclothingstore.entity.UserAddress;
import com.daniel.sms.onlineclothingstore.repository.RoleRepository;
import com.daniel.sms.onlineclothingstore.repository.UserRepository;
import com.daniel.sms.onlineclothingstore.service.UserService;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.MessageFormat;
import java.util.*;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordConfig passwordConfig;
    private final RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordConfig passwordConfig, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordConfig = passwordConfig;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    /*  public User findAddressById(Long id) {
        return userRepository.findAddressById(id).orElse(null);
    }*/

    @Transactional
    public boolean save(User user) {
        User userFromDb = userRepository.findByEmail(user.getEmail());

        if (userFromDb != null) {
            return new UsernameNotFoundException("User already exists").equals(userFromDb);
        }
        user.setPassword(passwordConfig.getPasswordEncoder().encode(user.getPassword()));
        user.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
        userRepository.save(user);
        return true;
    }

    @Override
    public void updateProfile(User user, String firstName, String lastName, String phoneNumber) {
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPhoneNumber(phoneNumber);
        userRepository.save(user);
    }

    @Transactional
    public void updateEmailAndPassword(User user, String newEmail, String newPassword) {
            user.setEmail(newEmail);
            user.setPassword(passwordConfig.getPasswordEncoder().encode(newPassword));
            userRepository.save(user);
    }

    @Transactional
    public void updateUserAddress(User user, UserAddress address) {
        user.setUserAddresses(new HashSet<>(Collections.singleton(address)));
        userRepository.save(user);
    }

    @Override
    public void saveUserById(String firstname, String lastname, String email, String password, String phoneNumber, Long id) {
        userRepository.saveUserById(firstname, lastname, phoneNumber, email, password, id);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    /*@Override
    public User deleteUser(User user) {
        if (user.getRoles().equals("ROLE_ADMIN")) {
            userRepository.delete(user);
        }
        return user;
    }*/
}
