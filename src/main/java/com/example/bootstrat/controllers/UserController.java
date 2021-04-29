package com.example.bootstrat.controllers;


import com.example.bootstrat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.security.Principal;

@Controller
@RequestMapping()
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public String showUserData(Principal principal, Model model) {
        model.addAttribute("user",

                userService.findByEmail(principal.getName()));
        return "showUser";
    }


    @GetMapping(value = "/login")
    public String getLoginPage(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "login";
    }


}
