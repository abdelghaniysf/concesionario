package com.concesionario.repository;

import com.concesionario.entity.CarEntity;
import com.concesionario.entity.enums.CarFor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Long> {
    List<CarEntity> findByCarFor(CarFor carFor);
}