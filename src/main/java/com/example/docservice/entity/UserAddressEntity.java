package com.example.docservice.entity;




import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
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

    public UserAddressEntity() {
    }


}
