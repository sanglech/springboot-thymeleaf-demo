package com.christian.springbootthymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @GetMapping("/")
    public String showHomePage(){
        return"home";
    }

    @GetMapping("/showLoginPage")
    public String showLoginForm(){
        return"starter/login-form";
    }

    @GetMapping("/showSignUpPage")
    public String showSignUpPage(){
        return"starter/signup-form";
    }


}
