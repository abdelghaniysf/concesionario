package com.concesionario.service;

import com.concesionario.entity.MotorEntity;
import com.concesionario.repository.MotorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// MotorService.java
@Service
public class MotorService {
    @Autowired
    private MotorRepository motorRepository;

    public MotorEntity save(MotorEntity motor) {
        return motorRepository.save(motor);
    }
}