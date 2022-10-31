package com.daniel.sms.onlineclothingstore.controller;

import com.daniel.sms.onlineclothingstore.entity.User;
import com.daniel.sms.onlineclothingstore.entity.UserAddress;
import com.daniel.sms.onlineclothingstore.repository.UserAddressRepository;
import com.daniel.sms.onlineclothingstore.service.impl.UserAddressServiceImpl;
import com.daniel.sms.onlineclothingstore.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.Set;

//TODO: - добавить обратную связь в личном кабинете и на основной страничке
//      - добавить обновление адреса

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserServiceImpl userService;
    private final UserAddressServiceImpl userAddressService;

    @Autowired
    public UserController(UserServiceImpl userService, UserAddressServiceImpl userAddressService) {
        this.userService = userService;
        this.userAddressService = userAddressService;
    }

    //TODO: - выводить в профиле количество заказов, товаров в них, цену и общую стоимость
    @GetMapping("/profile")
    public String getProfile(@AuthenticationPrincipal User sessionUser, Model model) {
        User user = userService.findById(sessionUser.getId());
        Set<UserAddress> userAddresses =userAddressService.findUserAddressByUser(user);
        model.addAttribute("user", user);
        model.addAttribute("address", userAddresses);
        return "user/profile";
    }

    @GetMapping("editUser")
    public String editUser(Model model, @AuthenticationPrincipal User user) {
       /* model.addAttribute("email", user.getEmail());
        model.addAttribute("password", user.getPassword());*/
        model.addAttribute("firstName", user.getFirstName());
        model.addAttribute("lastName", user.getLastName());
        model.addAttribute("phoneNumber", user.getPhoneNumber());
        return "/user/editProfile";
    }

    @PostMapping("editUser")
    public String updateUser(@AuthenticationPrincipal User user, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String phoneNumber) {
        userService.updateProfile(user, firstName, lastName, phoneNumber);
        return "redirect:/user/profile";
    }

    @GetMapping("/updateInfo")
    public String updateInfo(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("email", user.getEmail());
        model.addAttribute("password", user.getPassword());
        return "user/profile";
    }

    @PostMapping("/updateInfo")
    public String updateInfo(@AuthenticationPrincipal User user, @RequestParam String email, @RequestParam String password) {
        userService.updateEmailAndPassword(user, email, password);
        return "redirect:/user/profile";
    }


    @GetMapping("/updateAddress")
    public String addAddress(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("address", new UserAddress());
        return "user/editAddress";
    }

    @PostMapping("/updateAddress")
    public String addAddress(@AuthenticationPrincipal User user, @Valid @ModelAttribute("address") UserAddress address) {
        userAddressService.saveByUser(user, address);
        return "redirect:/user/profile";
    }

  /* @GetMapping("/updateAddress")
    public String getAllAddressesByUserId(@AuthenticationPrincipal User sessionUser, Model model) {
        User user = userService.findById(sessionUser.getId());
        Set<UserAddress> userAddresses =userAddressService.findUserAddressByUser(user);
        model.addAttribute("address", userAddresses);
        return "user/editAddress";
    }

    @PostMapping("/updateAddress")
    public String updateUserAddress(@AuthenticationPrincipal User user, @RequestParam String address, @RequestParam String city, @RequestParam String country) {
        Set<UserAddress> userAddresses =userAddressService.findUserAddressByUser(user);
        user.setUserAddresses(userAddresses);
        for (UserAddress userAddress : userAddresses) {
            userAddressService.saveAddress(userAddress, address, city, country);
        }
        return "redirect:/user/profile";
    }*/

}
