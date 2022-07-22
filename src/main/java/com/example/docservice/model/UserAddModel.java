package com.example.docservice.model;

import com.example.docservice.entity.UserAddressEntity;
import com.example.docservice.entity.UserDocumentsEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserAddModel {
    private String country;
    private String region;
    private String city;
    private String street;
    private String house;
    private String flat;
//DTO
    public static UserAddModel toModel(UserAddressEntity entity) {
        UserAddModel model = new UserAddModel();
        model.setCountry(entity.getCountry());
        model.setRegion(entity.getRegion());
        model.setCity(entity.getCity());
        model.setStreet(entity.getStreet());
        model.setHouse(entity.getHouse());
        model.setFlat(entity.getFlat());
        return model;
    }

}
