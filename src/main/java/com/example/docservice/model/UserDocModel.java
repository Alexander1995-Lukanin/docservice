package com.example.docservice.model;

import com.example.docservice.entity.UserDocumentsEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDocModel {
    private String passport;
    private String pensionCertificate;
    private String  medicalPolicy;

    public static UserDocModel toModel(UserDocumentsEntity entity) {
        UserDocModel model = new UserDocModel();
        model.setPassport(entity.getPassport());
        model.setPensionCertificate(entity.getPensionCertificate());
        model.setMedicalPolicy(entity.getMedicalPolicy());
        return model;
    }
}
