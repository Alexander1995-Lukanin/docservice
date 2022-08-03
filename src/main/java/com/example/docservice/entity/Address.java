package com.example.docservice.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
    @NotEmpty(message = "Country should not be empty")
    @Size(min = 2, max = 20, message = "Country should  be between 2 and 20 chara1cters")
    private String country;
    @NotEmpty(message = "Region should not be empty")
    @Size(min = 2, max = 20, message = "Region should  be between 2 and 20 chara1cters")
    private String region;
    @NotEmpty(message = "City should not be empty")
    @Size(min = 2, max = 20, message = "City should  be between 2 and 20 chara1cters")
    private String city;
    @NotEmpty(message = "Street should not be empty")
    @Size(min = 2, max = 20, message = "Street should  be between 2 and 20 chara1cters")
    private String street;
    @NotEmpty(message = "House should not be empty")
    @Size(min = 2, max = 20, message = "House should  be between 2 and 20 chara1cters")
    private String house;
    @NotNull(message = "Flat should not be empty")
    @Size(min = 2, max = 20, message = "Flat should  be between 2 and 20 chara1cters")
    private String flat;
    @ManyToOne
    private User userAdd;


}
