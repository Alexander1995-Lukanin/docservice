package com.example.docservice.entity;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class UserDocumentsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userDocId;
    private String passport;
    private String pensionCertificate;
    private String  medicalPolicy;

    public UserDocumentsEntity() {
    }
}
