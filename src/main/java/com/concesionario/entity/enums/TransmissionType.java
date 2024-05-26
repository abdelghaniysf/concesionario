package com.concesionario.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TransmissionType {
    MANUAL("Manual Transmission"),
    AUTOMATIC("Automatic Transmission"),
    CVT("Continuously Variable Transmission (CVT)"),
    SEMI_AUTOMATIC("Semi-Automatic Transmission");

    private final String description;
}
