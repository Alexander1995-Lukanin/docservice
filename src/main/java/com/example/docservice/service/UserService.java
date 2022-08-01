package com.example.docservice.service;

import com.example.docservice.entity.User;
import com.example.docservice.exception.UserIncorrectDataEntryException;
import com.example.docservice.exception.UserNotFaundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface UserService {

    //Post UserRegistration
    public void registrationUser(User userName) throws UserIncorrectDataEntryException;

    //Get UserByID
    public User getUserById(Long UserId) throws UserNotFaundException;

    //Get UserALL
    public Page<User> getUserAll(Pageable pageable) throws UserIncorrectDataEntryException;

    public Page<User> findAllUsersSortedByName(@SortDefault(sort = "name",
            direction = Sort.Direction.ASC) Pageable pageable) throws UserIncorrectDataEntryException;

    //Put User
    public List<User> getUserByLastName(String LastName) throws UserIncorrectDataEntryException;

    public void deleteUser(Long userId) throws UserIncorrectDataEntryException;

}
