package com.concesionario.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SteeringType {
    HYDRAULIC("Hydraulic"),
    ELECTROHYDRAULIC("Electrohydraulic"),
    ELECTRIC("Electric");

    private final String displayName;
}
