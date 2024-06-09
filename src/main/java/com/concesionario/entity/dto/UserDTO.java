package com.concesionario.entity.dto;

import com.concesionario.entity.user.RoleEntity;
import com.concesionario.validation.anotation.ExistEmail;
import com.concesionario.validation.anotation.ExistNationalId;
import com.concesionario.validation.anotation.ExistNumber;
import com.concesionario.validation.anotation.ExistUsername;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.List;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    @NotEmpty
    @ExistNationalId
    private String nationalId;
    @NotEmpty
    @ExistUsername
    private String username;
    @NotEmpty
    private String firstname;
    @NotEmpty
    private String lastname;
    @Email
    @ExistEmail
    private String email;
    @NotEmpty
    private String address;
    @NotEmpty
    private String dateOfBirth;
    @NotEmpty
    @ExistNumber
    private String phoneNumber;
    private String password;
    private List<RoleEntity> roleEntities;
}
