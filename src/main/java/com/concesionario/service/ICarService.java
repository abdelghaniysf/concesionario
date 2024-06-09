package com.concesionario.service;

import com.concesionario.entity.CarEntity;

import java.util.Optional;

public interface ICarService {
    CarEntity save(CarEntity car);

    Optional<CarEntity> getCarByChassisSerialNumber(String chassisSerialNumber);
}
