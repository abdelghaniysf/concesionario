package com.concesionario.controller;

import com.concesionario.entity.enums.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CarController {

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
        return "carRegister";
    }
}
