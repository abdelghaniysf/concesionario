package com.concesionario.service.impl;



import com.concesionario.entity.enums.RoleEnum;
import com.concesionario.entity.user.RoleEntity;
import com.concesionario.entity.user.UserEntity;
import com.concesionario.repository.IRoleEntityRepository;
import com.concesionario.repository.IUserEntityRepository;
import com.concesionario.service.IUserEntityService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserEntityEntityServiceImpl implements IUserEntityService {

    private final IUserEntityRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final IRoleEntityRepository roleRepository;


    public UserEntityEntityServiceImpl(PasswordEncoder passwordEncoder, IUserEntityRepository userRepository, IRoleEntityRepository roleRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional
    public UserEntity createUser(UserEntity user) {
        RoleEntity roleAdmin = roleRepository.findByRole(RoleEnum.ADMIN)
                .orElseThrow(() -> new RuntimeException("Role not found"));
        RoleEntity roleUser = roleRepository.findByRole(RoleEnum.USER)
                .orElseThrow(() -> new RuntimeException("Role not found"));
        user.setRoleEntities(List.of(roleAdmin, roleUser));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }


    @Override
    public Optional<UserEntity> getUserByUsername(String name) {
        return userRepository.findByUsername(name);
    }

    @Override
    public UserEntity updateUser(UserEntity user) {
        Optional<UserEntity> userOptional = userRepository.findById(user.getNationalId());
        if(userOptional.isPresent()){
            UserEntity userUpdated = userOptional.get();
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
