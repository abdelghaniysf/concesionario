package com.concesionario.entity;

import com.concesionario.entity.enums.Role;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tanger_user")
public class UserEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = -6196622178756080206L;

    @Id
    private String id;

    @Column(name = "username")
    private String username;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "email")
    private String email;

    @Column(name="address")
    private String address;

    @Column(name="date_of_birth")
    private String dateOfBirth;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "userEntity",cascade = CascadeType.ALL)
    private List<PurchaseEntity> purchaseEntityList;

}
