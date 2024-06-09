package com.concesionario.controller;


import com.concesionario.entity.dto.UserDTO;
import com.concesionario.entity.user.UserEntity;
import com.concesionario.service.IUserEntityService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
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
        model.addAttribute("user",new UserDTO());
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
    public String registerUser(@Valid @ModelAttribute("user") UserDTO user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            System.out.println(result.getAllErrors());
            return "register";
        }
        userService.createUser(user);
        return "redirect:/login";
    }

    @GetMapping("/my-account")
    public String profile(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated() && !authentication.getPrincipal().equals("anonymousUser")) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String username = userDetails.getUsername();
            model.addAttribute("user", userService.getUserByUsername(username).orElseThrow());
        }
        return "my-account";
    }

    @PostMapping("/profile")
    public String profileUpdate(@ModelAttribute("user") UserDTO user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "my-account";
        }
        System.out.println(user);
        userService.updateUser(user);
        return "redirect:/";
    }
}
