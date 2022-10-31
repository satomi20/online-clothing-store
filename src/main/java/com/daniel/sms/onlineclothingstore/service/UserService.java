package com.daniel.sms.onlineclothingstore.service;

import com.daniel.sms.onlineclothingstore.entity.User;
import com.daniel.sms.onlineclothingstore.entity.UserAddress;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserService {

    User findById(Long id);

   /* void save(User user);*/
    List<User> findAll();

    void saveUserById(String firstname, String lastname, String phoneNumber, String email, String password, Long id);

   //* User findByEmail(String email);*//*

    /*boolean signUp(User user);*/

    void delete(Long id);

    void updateProfile(User user, String firstName, String lastName, String phoneNumber);

    /*User deleteUser(User user);
*/














}
