package com.example.docservice.entity;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "UsersDocuments")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"passport"})
public class Documents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userDocId;
    private String passport;
    private String pensionCertificate;
    private String medicalPolicy;
    @OneToOne
    private User userDoc;

}
