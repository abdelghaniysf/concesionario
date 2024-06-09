package com.concesionario.entity;

import com.concesionario.entity.enums.*;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@ToString
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "car")
public class CarEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1671320768031045626L;

    @Id
    @Column(name = "chassis_serial_number")
    private String chassisSerialNumber;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "motor_id")
    private MotorEntity motor;

    @Column(name = "car_brand", nullable = false)
    @Enumerated(EnumType.STRING)
    private CarBrand carBrand;

    @Column(name = "price")
    private Double price;

    @Column(name = "km")
    private Long km;

    @Column(name = "description")
    private String description;

    @Column(name = "model")
    private String model;

    @Column(name = "model_year")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate modelYear;

    @Column(name = "color")
    private String color;

    @Column(name = "number_doors")
    private Integer numberDoors;

    @Column(name = "transmission")
    @Enumerated(EnumType.STRING)
    private TransmissionType transmission;

    @Column(name = "weight")
    private Long weight;

    @Column(name = "number_seats")
    private Integer numberSeats;

    @Column(name = "traction")
    @Enumerated(EnumType.STRING)
    private TractionType traction;

    @Column(name = "steering")
    @Enumerated(EnumType.STRING)
    private SteeringType steering;

    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(name = "car_for")
    @Enumerated(EnumType.STRING)
    private CarFor carFor;

    @Column(name = "image_path")
    private String imagePath;

    @Column(name = "available")
    private boolean available;

    @PrePersist
    public void available() {
        this.available = true;
    }
}
