package com.concesionario.entity;

import com.concesionario.entity.enums.FuelType;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "motor")
public class MotorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "horsepower")
    private Long horsepower;

    @Column(name = "torque")
    private Long torque;

    @Column(name = "engine_cc")
    private Long engineCc;

    @Column(name = "description")
    private String description;

    @Column(name = "engine_volume")
    private Double engineVolume;

    @Column(name = "fuel_type")
    @Enumerated(EnumType.STRING)
    private FuelType fuelType;

    @OneToMany(mappedBy = "motor", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<CarEntity> carEntities;
}
