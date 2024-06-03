package com.concesionario.validation.anotation;

import com.concesionario.validation.validator.ExistUsernameValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ExistUsernameValidation.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistUsername {
    String message() default "There is already a user with this username";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
