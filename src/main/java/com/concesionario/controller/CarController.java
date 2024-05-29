package com.concesionario.controller;

import com.concesionario.entity.CarEntity;
import com.concesionario.entity.MotorEntity;
import com.concesionario.entity.enums.*;
import com.concesionario.repository.CarRepository;
import com.concesionario.repository.MotorRepository;
import com.concesionario.service.CarService;
import com.concesionario.service.MotorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


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
    public String getCarBuy(){
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
    @PostMapping("/carRegister")
    public String registerCar(@ModelAttribute("car") CarEntity car, @ModelAttribute("motor") MotorEntity motor, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "registerCar";
        }

        // Save motor first
        MotorEntity savedMotor = motorService.save(motor);

        // Set motor to car
        car.setMotor(savedMotor);

        // Save car
        carService.save(car);

        return "redirect:/carRegister?success";
    }
}
