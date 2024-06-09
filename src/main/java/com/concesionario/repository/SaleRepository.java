package com.concesionario.repository;

import com.concesionario.entity.SaleEntity;
import com.concesionario.entity.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SaleRepository extends JpaRepository<SaleEntity, Long> {
    List<SaleEntity> findAllByUser(UserEntity user);
}
