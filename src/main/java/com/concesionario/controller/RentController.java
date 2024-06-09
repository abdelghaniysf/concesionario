package com.concesionario.controller;

import com.concesionario.entity.BookingEntity;
import com.concesionario.entity.CarEntity;
import com.concesionario.entity.enums.Location;
import com.concesionario.entity.user.UserEntity;
import com.concesionario.service.impl.BookingService;
import com.concesionario.service.impl.CarService;
import com.concesionario.service.impl.UserDetailsServiceImpl;
import com.concesionario.service.impl.UserEntityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/booking")
public class RentController {

    @Autowired
    private UserEntityServiceImpl userService;

    @Autowired
    private CarService carService;

    @Autowired
    private BookingService bookingService;

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
            model.addAttribute("booking", new BookingEntity());
            return "booking";
        } else {
            return "car-not-found";
        }
    }

    @PostMapping("/{chassisSerialNumber}")
    public String bookCar(@PathVariable String chassisSerialNumber, @ModelAttribute("booking") BookingEntity booking) {
        Optional<CarEntity> carOptional = carService.getCarByChassisSerialNumber(chassisSerialNumber);
        if (carOptional.isPresent()) {
            CarEntity car = carOptional.get();
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication != null && authentication.isAuthenticated() && !authentication.getPrincipal().equals("anonymousUser")) {
                UserDetails userDetails = (UserDetails) authentication.getPrincipal();
                String username = userDetails.getUsername();
                UserEntity user = userService.getUserByUsername(username).orElseThrow();

                booking.setCar(car);
                booking.setUser(user);

                // Guardar la reserva
                bookingService.saveBooking(booking);

                // Actualizar el estado del coche a no disponible
                car.setAvailable(false);
                carService.save(car);

                return "redirect:/car-rent";
            } else {
                return "redirect:/login";
            }
        } else {
            return "car-not-found";
        }
    }

}
