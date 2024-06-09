package com.concesionario.entity;

import com.concesionario.entity.enums.Location;
import com.concesionario.entity.user.UserEntity;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "sale")
public class SaleEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = -987654321987654321L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "chassis_serial_number", nullable = false)
    private String chassisSerialNumber;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "sale_date_time", nullable = false)
    private LocalDateTime saleDateTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "pickup_location", nullable = false)
    private Location pickupLocation;

    @Column(name = "pickup_date_time", nullable = false)
    private LocalDateTime pickupDateTime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "national_id")
    private UserEntity user;

    @Column(name = "special_request")
    private String specialRequest;

    @Column(name = "payment_method")
    private String paymentMethod;
}
