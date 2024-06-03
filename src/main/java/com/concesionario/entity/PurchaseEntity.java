package com.concesionario.entity;

import com.concesionario.entity.user.UserEntity;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "purchase")
public class PurchaseEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = -3977446857948765974L;

    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name = "invoice_number")
    private Integer invoiceNumber;

    @Column(name = "user_dni")
    private String customerDni;

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    private Double total;

    @Column(name = "payment_method")
    private String paymentMethod;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @OneToMany(mappedBy = "purchaseEntity", cascade = CascadeType.ALL)
    private List<CarPurchaseEntity> carPurchaseEntityList;
}
