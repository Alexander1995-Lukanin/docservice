package com.example.docservice.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.List;


@Entity
@Table(name = "UsersName")
@NoArgsConstructor
@EqualsAndHashCode(of = {"userId"})
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @NotEmpty(message = "First name should not be empty")
    @Size(min = 2, max = 20, message = "First name should  be between 2 and 20 characters")
    private String firstName;
    @NotEmpty(message = "Patronymic should not be empty")
    @Size(min = 2, max = 20, message = "Patronymic name should  be between 2 and 20 characters")
    private String patronymic;
    @NotEmpty(message = "LastName should not be empty")
    @Size(min = 2, max = 20, message = "Patronymic name should  be between 2 and 20 characters")
    private String lastName;
    //Ленивая загрузка и транзакцииcascade =
//    @NotNull
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userAdd", orphanRemoval = true)
//    @Valid
    private List<Address> userAddress;
//    @NotNull
//    @Valid
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "userDoc", orphanRemoval = true)
    private Documents userDocuments;
    //Веб клиент
}
