package com.example.docservice.entity;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "users")
public class UserNameEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
private Long userId;
private String firstname;
private String patronymic;
private String lastname;

}
