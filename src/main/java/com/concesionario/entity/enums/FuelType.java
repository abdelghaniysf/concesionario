package com.concesionario.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum FuelType {
    PETROL("Petrol"),
    DIESEL("Diesel"),
    HYBRID("Hybrid");

    private final String fuelTypeEnum;
}