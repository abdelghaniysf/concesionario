package com.concesionario.service.impl;

import com.concesionario.entity.CarEntity;
import com.concesionario.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public CarEntity save(CarEntity car) {
        return carRepository.save(car);
    }

    public List<CarEntity> findAll() {
        return carRepository.findAll();
    }
}


