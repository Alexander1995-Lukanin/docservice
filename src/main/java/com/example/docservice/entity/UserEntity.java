package com.example.docservice.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "UsersName")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String firstName;
    private String patronymic;
    private String lastName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userName")
    private List<UserAddressEntity> userAddress;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "userName")
    private UserDocumentsEntity userDocuments;

    public UserEntity() {
    }

}
