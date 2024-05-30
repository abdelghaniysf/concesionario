package com.concesionario.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CarFor {
    RENT("Rent"),SALE("Sale");
    private final String carFor;
}
