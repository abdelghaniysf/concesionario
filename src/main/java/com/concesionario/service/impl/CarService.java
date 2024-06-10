package com.concesionario.service.impl;

import com.concesionario.entity.CarEntity;
import com.concesionario.entity.enums.CarFor;
import com.concesionario.repository.CarRepository;
import com.concesionario.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarService implements ICarService {
    @Autowired
    private CarRepository carRepository;

    public CarEntity save(CarEntity car) {

        return carRepository.save(car);
    }


    public List<CarEntity> findCarsForSale(String category, String brand) {
        List<CarEntity> cars = carRepository.findByCarFor(CarFor.SALE);
        cars = filterCarEntities(category, brand, cars);
        return cars;
    }



    public List<CarEntity> findCarsForRent(String category, String brand) {
        List<CarEntity> cars = carRepository.findByCarFor(CarFor.RENT);
        cars = filterCarEntities(category, brand, cars);
        return cars;
    }

    private  List<CarEntity> filterCarEntities(String category, String brand, List<CarEntity> cars) {
        if (category != null && !category.isEmpty()) {
            cars = cars.stream()
                    .filter(car -> car.getCategory().name().equalsIgnoreCase(category))
                    .collect(Collectors.toList());
        }

        if (brand != null && !brand.isEmpty()) {
            cars = cars.stream()
                    .filter(car -> car.getCarBrand().name().equalsIgnoreCase(brand))
                    .collect(Collectors.toList());
        }
        return cars;
    }

    @Override
    public Optional<CarEntity> getCarByChassisSerialNumber(String chassisSerialNumber) {
        return carRepository.findByChassisSerialNumber(chassisSerialNumber);
    }
}


