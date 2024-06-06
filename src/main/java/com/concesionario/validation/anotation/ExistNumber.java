package com.concesionario.validation.anotation;

import com.concesionario.validation.validator.ExistEmailValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ExistEmailValidation.class )
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface ExistNumber {
    String message() default "There is already a user with this number";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
