package com.example.docservice.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "UsersName")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"userId"})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String firstName;
    private String patronymic;
    private String lastName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userAdd",orphanRemoval = true)
    private List<Address> userAddress;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "userDoc",orphanRemoval = true)
    private Documents userDocuments;

}
