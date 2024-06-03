package com.concesionario.validation.anotation;

import com.concesionario.validation.validator.ExistEmailValidation;
import com.concesionario.validation.validator.ExistNationalIdValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ExistNationalIdValidation.class )
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface ExistNationalId {

    String message() default "There is already a user with this national id";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
