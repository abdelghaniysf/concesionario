package com.concesionario.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum FuelType {
    GASOLINE("Gasoline"),DIESEL("Diesel");
    private final String fuelTypeEnum;
}
