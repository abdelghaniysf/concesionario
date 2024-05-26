package com.concesionario.entity;

import com.concesionario.entity.enums.Role;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "clientes")
public class CustomerEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = -6196622178756080206L;

    @Id
    private String dni;
    @Column(name = "nombre")
    private String firstname;
    @Column(name = "apellido")
    private String lastname;
    private String email;
    @Column(name = "numero_telefono")
    private String phoneNumber;
    @Column(name = "contrasenia")
    private String password;
    @Column(name = "activo")
    private Integer active;
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToMany(mappedBy = "customerEntity",cascade = CascadeType.ALL)
    private List<PurchaseEntity> purchaseEntityList;

}
