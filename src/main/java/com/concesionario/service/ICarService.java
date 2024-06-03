package com.concesionario.service;

import com.concesionario.entity.CarEntity;

import java.util.List;

public interface ICarService {
    CarEntity save(CarEntity car);
    List<CarEntity> findCarsForSale();
    List<CarEntity> findCarsForRent();
}
