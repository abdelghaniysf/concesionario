package com.concesionario.controller;

import com.concesionario.entity.CarEntity;
import com.concesionario.entity.MotorEntity;
import com.concesionario.entity.enums.*;
import com.concesionario.service.impl.CarService;
import com.concesionario.service.impl.MotorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class CarController {

    @Autowired
    private CarService carService;

    @Autowired
    private MotorService motorService;

    @GetMapping("car-rent")
    public String getCarRent(){
        return "carRent";
    }

    @GetMapping("booking")
    public String getBooking(){
        return "booking";
    }

    @GetMapping("car-buy")
    public String getCarBuy(Model model){
        List<CarEntity> cars = carService.findAll();
        model.addAttribute("cars", cars);
        return "carBuy";
    }

    @GetMapping("detail")
    public String getDetail(){
        return "detail";
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
        return "carRegister";
    }
    @PostMapping("/car-register")
    public String registerCar( @ModelAttribute CarEntity car, Model model) {
        carService.save(car);
        return "redirect:/";
    }
}
