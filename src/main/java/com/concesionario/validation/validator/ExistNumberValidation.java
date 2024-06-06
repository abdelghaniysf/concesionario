package com.concesionario.validation.validator;

import com.concesionario.repository.IUserEntityRepository;
import com.concesionario.validation.anotation.ExistNumber;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class ExistNumberValidation implements ConstraintValidator<ExistNumber,String> {

    private  final IUserEntityRepository userRepository;

    public ExistNumberValidation(IUserEntityRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isValid(String phone_number, ConstraintValidatorContext context) {
        if(phone_number == null){
            return false;
        }
        // Verificar si el email ya existe en el repositorio
        return !userRepository.findByPhoneNumber(phone_number).isPresent();
    }
}
