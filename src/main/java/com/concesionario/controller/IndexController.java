package com.concesionario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("index")
    public String getIndex(){
        return "index";
    }

    @GetMapping("about")
    public String getAbout(){
        return "about";
    }
}
