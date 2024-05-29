package com.concesionario.repository;

import com.concesionario.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

// CarRepository.java
public interface CarRepository extends JpaRepository<CarEntity, Long> {
}