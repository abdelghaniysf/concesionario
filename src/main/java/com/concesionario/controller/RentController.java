package com.concesionario.controller;

import com.concesionario.entity.CarEntity;
import com.concesionario.entity.enums.Location;
import com.concesionario.service.impl.CarService;
import com.concesionario.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/booking")
public class RentController {

    @Autowired
    private UserDetailsServiceImpl userService;

    @Autowired
    private CarService carService;

    @GetMapping("/{chassisSerialNumber}")
    public String booking(@PathVariable String chassisSerialNumber, Model model) {
        model.addAttribute("locations", Location.values());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated() && !authentication.getPrincipal().equals("anonymousUser")) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String username = userDetails.getUsername();
            model.addAttribute("user", userService.getUserByUsername(username).orElseThrow());
        }
        Optional<CarEntity> carOptional = carService.getCarByChassisSerialNumber(chassisSerialNumber);
        if (carOptional.isPresent()) {
            model.addAttribute("car", carOptional.get());
            return "booking";
        } else {
            return "car-not-found";
        }
    }
}
