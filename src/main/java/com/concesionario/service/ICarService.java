package com.concesionario.service;

import com.concesionario.entity.CarEntity;
import com.concesionario.entity.enums.CarFor;

import java.util.List;
import java.util.Optional;

public interface ICarService {
    CarEntity save(CarEntity car);
    Optional<CarEntity> getCarByChassisSerialNumber(String chassisSerialNumber);
}
