package com.concesionario.entity;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_number")
    private Integer invoiceNumber;
    @Column(name = "customer_dni")
    private String customerDni;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    private Double total;
    @Column(name = "payment_method")
    private String paymentMethod;

    @ManyToOne
    @JoinColumn(name ="customer_id",insertable = false,updatable = false)
    private CustomerEntity customerEntity;

    @OneToMany(mappedBy = "purchaseEntity",cascade = CascadeType.ALL)
    private List<CarPurchaseEntity> carPurchaseEntityList;
}
