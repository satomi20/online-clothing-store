package com.daniel.sms.onlineclothingstore.service;

import com.daniel.sms.onlineclothingstore.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();

    User findByEmail(String email);

    boolean addUser(User user);

    void updatePassword(User user, String password, String newPassword);

    void updateEmail(User user, String email, String newEmail);

    void updateProfile(User user, String firstName, String lastName, String phoneNumber);

    User deleteUser(User user);















}
