package com.concesionario.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CarBrand {
    // Sport
    ALFA_ROMEO("Alfa Romeo", Category.SPORT),
    ARIEL("Ariel", Category.SPORT),
    ASTON_MARTIN("Aston Martin", Category.SPORT),
    AUDI("Audi", Category.SPORT),
    BMW("BMW", Category.SPORT),
    BUGATTI("Bugatti", Category.SPORT),
    CHEVROLET("Chevrolet", Category.SPORT),
    DODGE("Dodge", Category.SPORT),
    FERRARI("Ferrari", Category.SPORT),
    FORD("Ford", Category.SPORT),
    HONDA("Honda", Category.SPORT),
    JAGUAR("Jaguar", Category.SPORT),
    LAMBORGHINI("Lamborghini", Category.SPORT),
    LOTUS("Lotus", Category.SPORT),
    MASERATI("Maserati", Category.SPORT),
    MCLAREN("Mclaren", Category.SPORT),
    MERCEDES("Mercedes", Category.SPORT),
    NISSAN("Nissan", Category.SPORT),
    PAGANI("Pagani", Category.SPORT),
    PORSCHE("Porsche", Category.SPORT),
    SUBARU("Subaru", Category.SPORT),
    TOYOTA("Toyota", Category.SPORT),

    // Luxury
    BENTLEY("Bentley", Category.LUXURY),
    CADILLAC("Cadillac", Category.LUXURY),
    LEXUS("Lexus", Category.LUXURY),
    LINCOLN("Lincoln", Category.LUXURY),
    ROLLS_ROYCE("Rolls Royce", Category.LUXURY),

    // Supercar
    BUGATTI_SUPERCAR("Bugatti", Category.SUPERCAR),
    FERRARI_SUPERCAR("Ferrari", Category.SUPERCAR),
    LAMBORGHINI_SUPERCAR("Lamborghini", Category.SUPERCAR),
    MCLAREN_SUPERCAR("Mclaren", Category.SUPERCAR),
    PAGANI_SUPERCAR("Pagani", Category.SUPERCAR),

    // Hypercar
    KOENIGSEGG("Koenigsegg", Category.HYPERCAR),
    RIMAC("Rimac", Category.HYPERCAR),

    // Luxury SUV
    LAND_ROVER("Land Rover", Category.LUXURY_SUV),
    RANGE_ROVER("Range Rover", Category.LUXURY_SUV),

    // Classic Car
    FORD_MUSTANG("Ford Mustang", Category.CLASSIC_CAR),
    CHEVROLET_CORVETTE("Chevrolet Corvette", Category.CLASSIC_CAR),

    // Limousine
    LINCOLN_LIMOUSINE("Lincoln", Category.LIMOUSINE),
    CADILLAC_LIMOUSINE("Cadillac", Category.LIMOUSINE),

    // Custom Car
    SHELBY("Shelby", Category.CUSTOM_CAR),

    // Collectors Car
    FERRARI_COLLECTORS("Ferrari", Category.COLLECTORS_CAR),
    PORSCHE_COLLECTORS("Porsche", Category.COLLECTORS_CAR),

    // Luxury Armored
    INKAS("Inkas", Category.LUXURY_ARMORED);

    private final String name;
    private final Category category;
}
