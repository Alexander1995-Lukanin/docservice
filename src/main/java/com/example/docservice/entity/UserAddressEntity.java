package com.example.docservice.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "userAddress")
public class UserAddressEntity {
    @Id
    @GeneratedValue()
    private Long userAddressId;
    private String country;
    private String region;
    private String city;
    private String street;
    private String house;
    private String flat;
}
