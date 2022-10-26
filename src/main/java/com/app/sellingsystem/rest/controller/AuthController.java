package com.app.sellingsystem.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {


    @GetMapping("/login")
    public String showLogin(){
        return "auth/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("email") String username, @ModelAttribute("password") String password){
        System.out.println(username);
        return "rewrw login";
    }

    @GetMapping("/register")
    public String register(){
        return "auth/register";
    }
}
