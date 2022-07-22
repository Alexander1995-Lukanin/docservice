package com.example.docservice.model;

import com.example.docservice.entity.UserAddressEntity;
import com.example.docservice.entity.UserDocumentsEntity;
import com.example.docservice.entity.UserEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserNameModel {
    private Long id;
    private String firstName;
    private String patronymic;
    private String lastName;
    private UserDocumentsEntity userDocs;
    private List<UserAddressEntity> userAddList;

    public static UserNameModel toModel(UserEntity entity) {
        UserNameModel model = new UserNameModel();
        model.setId(entity.getUserId());
        model.setFirstName(entity.getFirstName());
        model.setPatronymic(entity.getPatronymic());
        model.setLastName(entity.getLastName());
        model.setUserDocs(entity.getUserDocuments());
        model.setUserAddList(entity.getUserAddress());
        return model;
    }



}
