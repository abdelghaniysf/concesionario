package com.concesionario.validation.validator;



import com.concesionario.repository.IUserEntityRepository;
import com.concesionario.validation.anotation.ExistUsername;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

@Component
public class ExistUsernameValidation implements ConstraintValidator<ExistUsername, String> {

    private  final IUserEntityRepository userRepository;

    public ExistUsernameValidation(IUserEntityRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        if(username == null){
            return false;
        }
        // Verificar si el username ya existe en el repositorio
        return !userRepository.findByUsername(username).isPresent();
    }
}
