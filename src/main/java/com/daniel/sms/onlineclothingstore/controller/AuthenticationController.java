package com.daniel.sms.onlineclothingstore.controller;


import com.daniel.sms.onlineclothingstore.entity.User;
import com.daniel.sms.onlineclothingstore.entity.UserAddress;
import com.daniel.sms.onlineclothingstore.service.SecurityService;
import com.daniel.sms.onlineclothingstore.service.UserService;
import com.daniel.sms.onlineclothingstore.service.impl.UserServiceImpl;
import com.daniel.sms.onlineclothingstore.validation.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@Controller
@RequiredArgsConstructor
public class AuthenticationController {

    private UserServiceImpl userService;

    @Autowired
    public AuthenticationController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("user", new User());

        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        userService.save(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/logout")
    public String logoutPage() {
        return "redirect:/";
    }









    /*private final UserServiceImpl userService;

    @Autowired
    public AuthenticationController(UserServiceImpl userService) {
        this.userService = userService;
    }


    @GetMapping("/registration")
    public String registerPage(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping ("/registration")
    public String registerUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        userService.signUp(user);
        return "login";
    }

    @GetMapping("/login")
    public String loginPage(){
            return "login";
    }

    @GetMapping("/logout")
    public String logoutPage() throws Exception {
              return "redirect:/";
    }*/

}
