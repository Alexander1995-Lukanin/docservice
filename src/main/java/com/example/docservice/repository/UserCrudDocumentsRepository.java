package com.example.docservice.repository;

import com.example.docservice.entity.UserDocumentsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCrudDocumentsRepository extends CrudRepository <UserDocumentsEntity,Long> {
    UserDocumentsEntity findByPassport (String Passport);
    UserDocumentsEntity   findByPensionCertificate (String PensionCertificate);
    UserDocumentsEntity findByMedicalPolicy (String medicalPolicy);
}
