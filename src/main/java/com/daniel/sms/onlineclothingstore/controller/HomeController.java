package com.daniel.sms.onlineclothingstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {


    @GetMapping("/home")
    public String getHomePage(){
        return "index";
    }

    //controller for the login page
    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }

    //controller for the register page
    @GetMapping("/register")
    public String getRegisterPage(){
        return "register";
    }

    //controller for the cart page
    @GetMapping("/cart")
    public String getCartPage(){
        return "cart";
    }






}
