package com.concesionario.service.impl;

import com.concesionario.entity.CarEntity;
import com.concesionario.entity.enums.CarFor;
import com.concesionario.repository.CarRepository;
import com.concesionario.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService implements ICarService {
    @Autowired
    private CarRepository carRepository;

    public CarEntity save(CarEntity car) {
        return carRepository.save(car);
    }


    public List<CarEntity> findAvailableCarsForSale() {
        return carRepository.findByCarForAndAvailable(CarFor.SALE,true);
    }

    public List<CarEntity> findAvailableCarsForRent(boolean available) {
        return carRepository.findByCarForAndAvailable(CarFor.RENT, available);
    }

    @Override
    public Optional<CarEntity> getCarByChassisSerialNumber(String chassisSerialNumber) {
        return carRepository.findByChassisSerialNumber(chassisSerialNumber);
    }
}


