package com.concesionario.controller;


import com.concesionario.entity.user.UserEntity;
import com.concesionario.service.IUserEntityService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
public class UserController {

    private final IUserEntityService userService;

    public UserController(IUserEntityService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String getRegistration(Model model, RedirectAttributes flash){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated() && !authentication.getPrincipal().equals("anonymousUser")) {
            flash.addFlashAttribute("errorMessage","El usuario ya ha iniciado sesion");
            return "redirect:/";
        }
        model.addAttribute("user",new UserEntity());
        return "register";
    }

    @GetMapping("/login")
    public String getLogin(@RequestParam(value = "error", required = false) String error,
                           @RequestParam(value = "logout", required = false) String logout,
                           Model model, Principal principal, RedirectAttributes flash){

        if(principal!=null){
            flash.addFlashAttribute("info","You are already logged in");
            return "redirect:/";
        }
        if(error != null){
            model.addAttribute("error","Invalid username or password.");
        }
        if(logout!=null){
            model.addAttribute("success","Session closed");
        }
        return "login";
    }

    @PostMapping("/register")
    public String registerUser(UserEntity user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "user/register";
        }
        userService.createUser(user);
        return "redirect:/login";
    }
}
