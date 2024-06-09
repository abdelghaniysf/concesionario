package com.concesionario.repository;

import com.concesionario.entity.BookingEntity;
import com.concesionario.entity.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<BookingEntity, Long> {
    List<BookingEntity> findAllByUser(UserEntity user);
}
