package com.example.docservice.repository;

import com.example.docservice.entity.UserNameEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface UserCrudRepository extends CrudRepository<UserNameEntity,Long> {
    UserNameEntity findByUserFirstName (String username);
    UserNameEntity findByUserPatronymic (String username);
    UserNameEntity findByUserLastName (String username);

}
