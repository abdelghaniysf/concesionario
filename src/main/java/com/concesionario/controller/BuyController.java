package com.concesionario.controller;

import com.concesionario.entity.CarEntity;
import com.concesionario.entity.SaleEntity;
import com.concesionario.entity.enums.Location;
import com.concesionario.service.impl.CarService;
import com.concesionario.service.impl.SaleService;
import com.concesionario.service.impl.UserEntityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Controller
public class BuyController {

    @Autowired
    private CarService carService;

    @Autowired
    private UserEntityServiceImpl userService;

    @Autowired
    private SaleService saleService;

    @GetMapping("/detail/{chassisSerialNumber}")
    public String getDetail(@PathVariable String chassisSerialNumber, Model model) {
        List<CarEntity> carsForSale = carService.findCarsForSale();
        model.addAttribute("locations", Location.values());
        model.addAttribute("cars", carsForSale.stream().filter(car -> !Objects.equals(car.getChassisSerialNumber(), chassisSerialNumber)).toList());
        model.addAttribute("sale", new SaleEntity());

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated() && !authentication.getPrincipal().equals("anonymousUser")) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String username = userDetails.getUsername();
            model.addAttribute("user", userService.getUserByUsername(username).orElseThrow());
        }

        Optional<CarEntity> carOptional = carService.getCarByChassisSerialNumber(chassisSerialNumber);
        if (carOptional.isPresent()) {
            model.addAttribute("car", carOptional.get());
            return "detail";
        } else {
            return "car-not-found";
        }
    }

    @PostMapping("/detail/{chassisSerialNumber}")
    public String buyCar(@PathVariable String chassisSerialNumber, SaleEntity sale) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Optional<CarEntity> carOptional = carService.getCarByChassisSerialNumber(chassisSerialNumber);
        if (carOptional.isPresent()) {
            CarEntity car = carOptional.get();
            if (authentication != null && authentication.isAuthenticated() && !authentication.getPrincipal().equals("anonymousUser")) {
                UserDetails userDetails = (UserDetails) authentication.getPrincipal();
                String username = userDetails.getUsername();
                sale.setUser(userService.getUserByUsername(username).orElseThrow());
            }
            car.setAvailable(false);
            sale.setModel(car.getModel());
            sale.setPrice(car.getPrice());
            saleService.saveSale(sale);
            return "redirect:/car-sale";
        } else {
            return "car-not-found";
        }
    }

    @GetMapping("/cancel-sale/{saleId}")
    public String cancelSale(@PathVariable Long saleId) {
        saleService.cancelSale(saleId);
        return "redirect:/my-operations";
    }
}
