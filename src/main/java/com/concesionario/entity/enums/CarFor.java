package com.concesionario.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CarFor {
    RENTING("Renting"),BUYING("Buying");
    private final String carFor;
}
