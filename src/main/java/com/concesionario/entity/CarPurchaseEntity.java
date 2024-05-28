package com.concesionario.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@Entity
@Table(name = "car_purchase")
public class CarPurchaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -6315257342621332561L;

    @Id
    private CarPurchasePK id;
    @Column(name = "quantity")
    private Integer quantity;
    private Double total;
    @ManyToOne
    @MapsId(value = "purchaseInvoiceNumber")
    @JoinColumn(name = "purchase_invoice_number",insertable = false, updatable = false)
    private PurchaseEntity purchaseEntity;
    @ManyToOne
    @JoinColumn(name = "car_code",insertable = false, updatable = false)
    private CarEntity carEntity;
}
