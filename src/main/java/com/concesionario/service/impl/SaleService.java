package com.concesionario.service.impl;

import com.concesionario.entity.BookingEntity;
import com.concesionario.entity.SaleEntity;
import com.concesionario.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    public void saveSale(SaleEntity sale) {
        saleRepository.save(sale);
    }
}
