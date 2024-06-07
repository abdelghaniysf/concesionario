package com.concesionario.entity.enums;

public enum Location {
    CONCESIONARIO_1("123 Boulevard Principal, Tanger"),
    CONCESIONARIO_2("456 Avenue Deuxieme, Tanger"),
    CONCESIONARIO_3("789 Boulevard Troiseme, Tanger");

    private final String address;

    Location(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}
