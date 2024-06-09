package com.concesionario.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@Embeddable
public class CarPurchasePK implements Serializable {
    @Serial
    private static final long serialVersionUID = -6096095155740053978L;

    @Column(name = "purchase_invoice_number")
    private Integer purchaseInvoiceNumber;
    @Column(name = "chassis_serial_number")
    private String carCode;
}
