package com.example.docservice.entity;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table (name = "UsersDocuments")
public class UserDocumentsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userDocId;
    private String passport;
    private String pensionCertificate;
    private String  medicalPolicy;
    @OneToOne
    @JoinColumn (name = "userId")
    private UserEntity userName;

    public UserDocumentsEntity() {
    }
}
