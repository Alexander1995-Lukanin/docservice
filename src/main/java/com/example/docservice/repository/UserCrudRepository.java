package com.example.docservice.repository;

import com.example.docservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserCrudRepository extends JpaRepository<User, Long> {
    List<User> findAllByLastName(String lastName);


}

