package com.example.docservice.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "userDocuments")
public class UserDocumentsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "user_doc_id")
    private Long userDocId;
    private String passport;
    private String pensionCertificate;
    private String  medicalPolicy;
}
