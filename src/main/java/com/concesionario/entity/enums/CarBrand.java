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
    BUGATTI_SPORT("Bugatti Sport", Category.SPORT),
    CHEVROLET_SPORT("Chevrolet Sport", Category.SPORT),
    DODGE("Dodge", Category.SPORT),
    FERRARI_SPORT("Ferrari Sport", Category.SPORT),
    FORD_SPORT("Ford Sport", Category.SPORT),
    HONDA("Honda", Category.SPORT),
    JAGUAR("Jaguar", Category.SPORT),
    LAMBORGHINI_SPORT("Lamborghini Sport", Category.SPORT),
    LOTUS("Lotus", Category.SPORT),
    MASERATI("Maserati", Category.SPORT),
    MCLAREN_SPORT("Mclaren Sport", Category.SPORT),
    MERCEDES("Mercedes", Category.SPORT),
    NISSAN("Nissan", Category.SPORT),
    PAGANI_SPORT("Pagani Sport", Category.SPORT),
    PORSCHE_SPORT("Porsche Sport", Category.SPORT),
    SUBARU("Subaru", Category.SPORT),
    TOYOTA("Toyota", Category.SPORT),

    // Luxury
    BENTLEY("Bentley", Category.LUXURY),
    CADILLAC_LUXURY("Cadillac Luxury", Category.LUXURY),
    LEXUS("Lexus", Category.LUXURY),
    LINCOLN_LUXURY("Lincoln Luxury", Category.LUXURY),
    ROLLS_ROYCE("Rolls Royce", Category.LUXURY),

    // Supercar
    BUGATTI_SUPERCAR("Bugatti Supercar", Category.SUPERCAR),
    FERRARI_SUPERCAR("Ferrari Supercar", Category.SUPERCAR),
    LAMBORGHINI_SUPERCAR("Lamborghini Supercar", Category.SUPERCAR),
    MCLAREN_SUPERCAR("Mclaren Supercar", Category.SUPERCAR),
    PAGANI_SUPERCAR("Pagani Supercar", Category.SUPERCAR),

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
    LINCOLN_LIMOUSINE("Lincoln Limousine", Category.LIMOUSINE),
    CADILLAC_LIMOUSINE("Cadillac Limousine", Category.LIMOUSINE),

    // Custom Car
    SHELBY("Shelby", Category.CUSTOM_CAR),

    // Collectors Car
    FERRARI_COLLECTORS("Ferrari Collectors", Category.COLLECTORS_CAR),
    PORSCHE_COLLECTORS("Porsche Collectors", Category.COLLECTORS_CAR),

    // Luxury Armored
    INKAS("Inkas", Category.LUXURY_ARMORED);

    private final String name;
    private final Category category;
}
