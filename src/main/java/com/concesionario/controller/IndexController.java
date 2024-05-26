package com.concesionario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping({"index","/"})
    public String getIndex(){
        return "index";
    }

    @GetMapping("about")
    public String getAbout(){
        return "about";
    }

    @GetMapping("service")
    public String getService(){
        return "service";
    }

    @GetMapping("contact")
    public String getContact(){
        return "contact";
    }

    @GetMapping("car-buy")
    public String getCarBuy(){
        return "carBuy";
    }

    @GetMapping("car-rent")
    public String getCarRent(){
        return "carRent";
    }

    @GetMapping("detail")
    public String getDetail(){
        return "detail";
    }

    @GetMapping("booking")
    public String getBooking(){
        return "booking";
    }

    @GetMapping("team")
    public String getTeam(){
        return "team";
    }

    @GetMapping("testimonial")
    public String getTestimonial(){
        return "testimonial";
    }

    @GetMapping("privacy")
    public String getPrivacy(){
        return "privacy";
    }

    @GetMapping("terms")
    public String getTerms(){
        return "terms&conditions";
    }

    @GetMapping("register")
    public String getRegistration(){
        return "register";
    }
}
