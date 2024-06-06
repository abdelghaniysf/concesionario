package com.concesionario.service;

import com.concesionario.entity.CarEntity;

import java.util.List;
import java.util.Optional;

public interface ICarService {
    CarEntity save(CarEntity car);
    List<CarEntity> findCarsForSale();
    List<CarEntity> findCarsForRent();
    Optional<CarEntity> getCarByChassisSerialNumber(String chassisSerialNumber);
}
