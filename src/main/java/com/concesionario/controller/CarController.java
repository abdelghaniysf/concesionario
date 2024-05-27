package com.concesionario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
    public String getCarRegister(){
        return "carRegister";
    }
}
