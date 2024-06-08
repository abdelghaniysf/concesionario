package com.concesionario.entity;

import com.concesionario.entity.enums.Location;
import com.concesionario.entity.user.UserEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "booking")
public class BookingEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = -1234567890123456789L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "car_id", referencedColumnName = "chassis_serial_number")
    private CarEntity car;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "national_id")
    private UserEntity user;

    @Enumerated(EnumType.STRING)
    @Column(name = "pickup_location", nullable = false)
    private Location pickupLocation;

    @Enumerated(EnumType.STRING)
    @Column(name = "drop_location", nullable = false)
    private Location dropLocation;

    @Column(name = "pickup_date", nullable = false)
    private String pickupDate;

    @Column(name = "pickup_time", nullable = false)
    private String pickupTime;

    @Column(name = "special_request")
    private String specialRequest;

    @Column
    private String paymentMethod;
}
