package com.concesionario.controller;

import com.concesionario.entity.CarEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @GetMapping("register")
    public String getRegistration(){
        return "register";
    }

    @GetMapping("login")
    public String getLogin(){
        return "login";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute CarEntity car, Model model) {
        return "redirect:/";
    }
}
