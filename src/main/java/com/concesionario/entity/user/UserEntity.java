package com.concesionario.entity.user;

import com.concesionario.entity.PurchaseEntity;
import com.concesionario.validation.anotation.ExistEmail;
import com.concesionario.validation.anotation.ExistNationalId;
import com.concesionario.validation.anotation.ExistUsername;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
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
@Table(name = "user_db")
public class UserEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = -6196622178756080206L;

    @Id
    @NotEmpty
    @Column(name = "national_id",unique = true)
    @ExistNationalId
    private String nationalId;

    @Column(name = "username",unique = true)
    @NotEmpty
    @ExistUsername
    private String username;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "email")
    @Email
    @ExistEmail
    private String email;

    @Column(name="address")
    private String address;

    @Column(name="date_of_birth")
    private String dateOfBirth;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles",joinColumns = @JoinColumn(name = "user_id" ),
            inverseJoinColumns = @JoinColumn(name = "role_id")
            ,uniqueConstraints = { @UniqueConstraint(columnNames = {"user_id","role_id"})})
    private List<RoleEntity> roleEntities;

    @OneToMany(mappedBy = "userEntity",cascade = CascadeType.ALL)
    private List<PurchaseEntity> purchaseEntityList;

}
