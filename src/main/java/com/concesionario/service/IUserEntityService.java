package com.concesionario.service;





import com.concesionario.entity.dto.UserDTO;
import com.concesionario.entity.user.UserEntity;

import java.util.Optional;

public interface IUserEntityService {
    UserEntity createUser(UserDTO user);
    Optional<UserEntity> getUserByUsername(String name);
    UserEntity updateUser(UserDTO user);
    void deleteUser(UserEntity usuario);
    Optional<UserEntity> getUserById(String id);
}
