package com.concesionario.service.impl;

import com.concesionario.entity.BookingEntity;
import com.concesionario.entity.CarEntity;
import com.concesionario.entity.SaleEntity;
import com.concesionario.entity.user.UserEntity;
import com.concesionario.repository.CarRepository;
import com.concesionario.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private SaleRepository saleRepository;

    public void saveSale(SaleEntity sale) {
        saleRepository.save(sale);
    }

    public List<SaleEntity> getSalesByUser(UserEntity user) {
        return saleRepository.findAllByUser(user);
    }

    public void cancelSale(Long saleId) {
        SaleEntity sale = saleRepository.findById(saleId).orElseThrow(() -> new RuntimeException("Booking not found"));
        CarEntity car = carRepository.findByChassisSerialNumber(sale.getChassisSerialNumber()).orElseThrow(() -> new RuntimeException("Car not found"));
        car.setAvailable(true);
        carRepository.save(car);
        saleRepository.deleteById(saleId);
    }
}
