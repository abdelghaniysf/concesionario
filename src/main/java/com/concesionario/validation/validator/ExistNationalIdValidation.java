package com.concesionario.validation.validator;

import com.concesionario.repository.IUserEntityRepository;
import com.concesionario.validation.anotation.ExistNationalId;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ExistNationalIdValidation implements ConstraintValidator<ExistNationalId, String> {

    private  final IUserEntityRepository userRepository;

    public ExistNationalIdValidation(IUserEntityRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public boolean isValid(String nationalId, ConstraintValidatorContext context) {

        if(nationalId == null){
            return false;
        }
        // Verificar si el email ya existe en el repositorio
        return !userRepository.findByNationalId(nationalId).isPresent();
    }
}
