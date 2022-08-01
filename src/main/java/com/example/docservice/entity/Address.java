package com.example.docservice.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "UsersAddress")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"userAddressId"})
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userAddressId;

    private String country;
    private String region;
    private String city;
    private String street;
    private String house;
    private String flat;
    @ManyToOne
    private User userAdd;


}
