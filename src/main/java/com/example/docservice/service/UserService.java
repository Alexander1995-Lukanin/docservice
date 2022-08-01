package com.example.docservice.service;

import com.example.docservice.entity.User;
import com.example.docservice.exception.UserIncorrectDataEntryException;
import com.example.docservice.exception.UserNotFaundException;

import java.util.List;

public interface UserService {

    //Post UserRegistration
    public void registrationUser(User userName) throws UserIncorrectDataEntryException;
    //Get UserByID
    public User getUserById(Long UserId) throws UserNotFaundException;
    //Get UserALL
    public List <User> getUserAll () throws UserIncorrectDataEntryException;
    //Put User
    public List <User> getUserByLastName (String LastName) throws UserIncorrectDataEntryException;

    public void deleteUser (Long userId) throws UserIncorrectDataEntryException;


}
