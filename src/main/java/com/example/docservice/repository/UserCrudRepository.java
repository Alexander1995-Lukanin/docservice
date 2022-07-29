package com.example.docservice.repository;

import com.example.docservice.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserCrudRepository extends CrudRepository<UserEntity,Long> {
    UserEntity findByUserId (Long userID);
    UserEntity findByFirstName (String username);
    UserEntity findByPatronymic (String username);
    UserEntity findByLastName (String username);
    List<UserEntity> findAllByLastName(String str);
//    List<UserAddressEntity> findByUserAddress (UserAddressEntity userAdd);
//    UserEntity findByUserDocuments (UserDocumentsEntity userDocuments);
 ;
}

