package com.concesionario.service.impl;


import com.concesionario.entity.dto.UserDTO;
import com.concesionario.entity.enums.RoleEnum;
import com.concesionario.entity.user.RoleEntity;
import com.concesionario.entity.user.UserEntity;
import com.concesionario.repository.IRoleEntityRepository;
import com.concesionario.repository.IUserEntityRepository;
import com.concesionario.service.IUserEntityService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserEntityServiceImpl implements IUserEntityService {

    private final IUserEntityRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final IRoleEntityRepository roleRepository;


    public UserEntityServiceImpl(PasswordEncoder passwordEncoder, IUserEntityRepository userRepository, IRoleEntityRepository roleRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional
    public UserEntity createUser(UserDTO user) {
        // Obtener el rol de usuario
        RoleEntity roleUser = roleRepository.findByRole(RoleEnum.USER)
                .orElseThrow(() -> new RuntimeException("Role USER not found"));

        // Inicializar la lista de roles con el rol de usuario
        List<RoleEntity> roles = new ArrayList<>();
        roles.add(roleUser);

        // Verificar si el correo electrónico contiene '@admin.'
        if (user.getEmail().contains("@admin.")) {
            // Obtener el rol de administrador
            RoleEntity roleAdmin = roleRepository.findByRole(RoleEnum.ADMIN)
                    .orElseThrow(() -> new RuntimeException("Role ADMIN not found"));
            // Añadir el rol de administrador a la lista de roles
            roles.add(roleAdmin);
        }

        // Asignar los roles al usuario
        user.setRoleEntities(roles);
        // Encriptar la contraseña del usuario
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Crear la entidad de usuario
        UserEntity userEntity = UserEntity.builder()
                .username(user.getUsername())
                .nationalId(user.getNationalId())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .address(user.getAddress())
                .dateOfBirth(user.getDateOfBirth())
                .phoneNumber(user.getPhoneNumber())
                .password(user.getPassword())
                .roleEntities(user.getRoleEntities())
                .build();

        // Guardar la entidad de usuario en el repositorio
        return userRepository.save(userEntity);
    }



    @Override
    public Optional<UserEntity> getUserByUsername(String name) {
        return userRepository.findByUsername(name);
    }

    @Override
    public UserEntity updateUser(UserEntity user) {
        Optional<UserEntity> userOptional = userRepository.findById(user.getNationalId());
        if (userOptional.isPresent()) {
            UserEntity userUpdated = userOptional.get();
            userUpdated.setFirstname(user.getFirstname());
            userUpdated.setLastname(user.getLastname());
            userUpdated.setEmail(user.getEmail());
            userUpdated.setAddress(user.getAddress());
            userUpdated.setDateOfBirth(user.getDateOfBirth());
            userUpdated.setPhoneNumber(user.getPhoneNumber());
            userUpdated.setRoleEntities(user.getRoleEntities());
            return userRepository.save(userUpdated);
        }
        return null;
    }

    @Override
    public void deleteUser(UserEntity user) {
        userRepository.delete(user);
    }

    @Override
    public Optional<UserEntity> getUserById(String id) {
        return userRepository.findById(id);
    }

}
