package com.concesionario.controller;

import com.concesionario.entity.CarEntity;
import com.concesionario.service.impl.CarService;
import org.springframework.beans.factory.annotation.Autowired;
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
    private CarService carService;

    @GetMapping("/{chassisSerialNumber}")
    public String booking(@PathVariable String chassisSerialNumber, Model model) {
        Optional<CarEntity> carOptional = carService.getCarByChassisSerialNumber(chassisSerialNumber);
        if (carOptional.isPresent()) {
            model.addAttribute("car", carOptional.get());
            return "booking";
        } else {
            return "car-not-found";
        }
    }
}
