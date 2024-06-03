package com.concesionario.service.impl;

import com.concesionario.entity.CarEntity;
import com.concesionario.entity.enums.CarFor;
import com.concesionario.repository.CarRepository;
import com.concesionario.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService implements ICarService {
    @Autowired
    private CarRepository carRepository;

    public CarEntity save(CarEntity car) {
        return carRepository.save(car);
    }

    public List<CarEntity> findCarsForSale() {
        return carRepository.findByCarFor(CarFor.SALE);
    }

    public List<CarEntity> findCarsForRent() {
        return carRepository.findByCarFor(CarFor.RENT);
    }
}


