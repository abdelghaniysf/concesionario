package com.concesionario.service;





import com.concesionario.entity.user.UserEntity;

import java.util.Optional;

public interface IUserEntityService {
    UserEntity createUser(UserEntity user);
    Optional<UserEntity> getUserByUsername(String name);
    UserEntity updateUser(UserEntity user);
    void deleteUser(UserEntity usuario);
    Optional<UserEntity> getUserById(String id);
}
