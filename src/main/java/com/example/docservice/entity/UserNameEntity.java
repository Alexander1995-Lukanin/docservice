package com.example.docservice.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
public class UserNameEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
private Long userId;
private String firstname;
private String patronymic;
private String lastname;

    public UserNameEntity() {
    }

}
