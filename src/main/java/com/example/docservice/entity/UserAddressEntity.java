package com.example.docservice.entity;




import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table (name = "UsersAddress")
public class UserAddressEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long userAddressId;
    private String country;
    private String region;
    private String city;
    private String street;
    private String house;
    private String flat;
    @ManyToOne
    @JoinColumn (name = "userId")
    private UserEntity userName;

    public UserAddressEntity() {
    }


}
