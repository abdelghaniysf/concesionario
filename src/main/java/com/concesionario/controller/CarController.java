package com.concesionario.controller;

import com.concesionario.entity.CarEntity;
import com.concesionario.entity.MotorEntity;
import com.concesionario.entity.enums.*;
import com.concesionario.service.impl.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("car-rent")
    public String getCarRent( @RequestParam(name = "category", required = false) String category,
                              @RequestParam(name = "brand", required = false) String brand,
                              Model model) {
        model.addAttribute("brands", CarBrand.values());
        model.addAttribute("categories", Category.values());
        List<CarEntity> carsForRent =  carService.findCarsForRent(category, brand);
        model.addAttribute("cars", carsForRent);
        model.addAttribute("locations", Location.values());
        return "car-rent";
    }

    @GetMapping("car-sale")
    public String getCarBuyPage(@RequestParam(name = "category", required = false) String category,
                                @RequestParam(name = "brand", required = false) String brand,
                                Model model) {
        model.addAttribute("brands", CarBrand.values());
        model.addAttribute("categories", Category.values());
        List<CarEntity> carsForSale = carService.findCarsForSale(category, brand);
        model.addAttribute("cars", carsForSale);
        model.addAttribute("locations", Location.values());
        return "car-sale";
    }

    @GetMapping("car-register")
    public String getCarRegister(Model model) {
        model.addAttribute("carBrands", CarBrand.values());
        model.addAttribute("fuelTypes", FuelType.values());
        model.addAttribute("transmissionTypes", TransmissionType.values());
        model.addAttribute("tractionTypes", TractionType.values());
        model.addAttribute("steeringTypes", SteeringType.values());
        model.addAttribute("categories", Category.values());
        model.addAttribute("carFors", CarFor.values());
        model.addAttribute("motor", new MotorEntity());
        model.addAttribute("car", new CarEntity());
        return "car-register";
    }

    @PostMapping("/car-register")
    public String registerCar(@ModelAttribute CarEntity car, Model model) {
        carService.save(car);
        return "redirect:/";
    }
}
