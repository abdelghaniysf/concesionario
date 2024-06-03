package com.concesionario.validation.validator;



import com.concesionario.repository.IUserEntityRepository;
import com.concesionario.validation.anotation.ExistEmail;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

@Component
public class ExistEmailValidation implements ConstraintValidator<ExistEmail,String> {

    private  final IUserEntityRepository userRepository;

    public ExistEmailValidation(IUserEntityRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        if(email == null){
            return false;
        }
        // Verificar si el email ya existe en el repositorio
        return !userRepository.findByEmail(email).isPresent();
    }
}
