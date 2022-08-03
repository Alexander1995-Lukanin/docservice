package com.example.docservice.entity;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table(name = "UsersDocuments")
@NoArgsConstructor
@EqualsAndHashCode(of = {"passport"})
@ToString
public class Documents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userDocId;
    @NotEmpty(message = "Passport should not be empty")
    @Size(min = 2, max = 20, message = "Passport should  be between 2 and 20 characters")
    private String passport;
    @NotEmpty(message = "PensionCertificate should not be empty")
    @Size(min = 2, max = 20, message = "PensionCertificate  be between 2 and 20 characters")
    private String pensionCertificate;
    @NotEmpty(message = "MedicalPolicy should not be empty")
    @Size(min = 2, max = 20, message = "MedicalPolicy should  be between 2 and 20 characters")
    private String medicalPolicy;
    @OneToOne
    private User userDoc;

}
