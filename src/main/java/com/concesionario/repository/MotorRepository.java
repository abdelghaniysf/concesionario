package com.concesionario.repository;

import com.concesionario.entity.MotorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotorRepository extends JpaRepository<MotorEntity, Long> {
}
