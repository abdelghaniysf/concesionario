package com.concesionario.repository;

import com.concesionario.entity.enums.RoleEnum;
import com.concesionario.entity.user.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IRoleEntityRepository extends JpaRepository<RoleEntity, Long> {
    Optional<RoleEntity> findByRole(RoleEnum role);
}
