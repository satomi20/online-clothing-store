package com.daniel.sms.onlineclothingstore.validation;


import com.daniel.sms.onlineclothingstore.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
@Component
@RequiredArgsConstructor
public class UniqueEmailValidator /*implements ConstraintValidator<UniqueEmail, String>*/ {

    private final UserServiceImpl userService;

    /*public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        return email != null && !userService.isEmailInUse(email);
    }
*/
}
