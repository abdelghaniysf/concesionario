package com.concesionario.repository;

import com.concesionario.entity.CarEntity;
import com.concesionario.entity.enums.CarFor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Long> {
    Optional<CarEntity> findByChassisSerialNumber(String chassisSerialNumber);
    List<CarEntity> findByCarForAndAvailable(CarFor carFor, boolean available);
}