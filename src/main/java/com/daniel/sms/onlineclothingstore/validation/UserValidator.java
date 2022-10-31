package com.daniel.sms.onlineclothingstore.validation;

import com.daniel.sms.onlineclothingstore.entity.User;
import com.daniel.sms.onlineclothingstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/*@Component*/
public class UserValidator/* implements Validator */{

    /*private UserService userService;

    @Autowired
    public UserValidator(UserService userService) {
        this.userService = userService;
    }

    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");
        if (user.getEmail().length()< 5 || user.getEmail().length() > 32) {
            errors.rejectValue("email", "Size.userForm.email");
        }
        if (userService.findByEmail(user.getEmail()) != null){
            errors.rejectValue("email", "Duplicate.userForm.email");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Not empty");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }

        *//*if (!user.getPasswordConfirm().equals(user.getPassword())){
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }*//*

    }*/

}
