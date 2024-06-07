package com.concesionario.controller;

import com.concesionario.entity.CarEntity;
import com.concesionario.entity.enums.Location;
import com.concesionario.service.impl.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BuyController {

    @Autowired
    private CarService carService;

    @GetMapping("detail")
    public String getDetail(Model model){
        List<CarEntity> carsForSale = carService.findCarsForSale();
        model.addAttribute("cars", carsForSale);
        model.addAttribute("locations", Location.values());
        return "detail";
    }
}
