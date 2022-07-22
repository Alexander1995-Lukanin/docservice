package com.example.docservice.service;

import com.example.docservice.entity.UserAddressEntity;
import com.example.docservice.entity.UserDocumentsEntity;
import com.example.docservice.entity.UserEntity;
import com.example.docservice.exception.UserIncorrectDataEntryException;
import com.example.docservice.exception.UserNotFaundException;
import com.example.docservice.model.UserAddModel;
import com.example.docservice.model.UserDocModel;
import com.example.docservice.model.UserNameModel;

import java.util.List;

public interface UserInterfaceService {
    //Post UserRegistration
    public UserEntity registrationUser(UserEntity userName) throws UserIncorrectDataEntryException;


    //Get UserName
    public UserEntity getUsernameById (Long UserId) throws UserNotFaundException;
    public List<UserEntity> getUsernameByLastName (String lastName)  throws UserNotFaundException;
    //Get UserAddress
    public UserAddModel  getUserAddress (UserEntity userName) throws UserIncorrectDataEntryException;
    public UserAddModel  getUserAddress (UserDocumentsEntity userDoc) throws UserIncorrectDataEntryException;
    //Get UserAddress
    public UserDocModel  getUserDoc (UserEntity userName) throws UserIncorrectDataEntryException;


    //Put UserName
    public UserNameModel changeUserName (UserEntity userName,Long userId) throws UserIncorrectDataEntryException;
    public void deleteUser (Long userId) throws UserIncorrectDataEntryException;
    //Put UserAddress
    public UserAddModel changeUserAddress (UserAddressEntity userAddress,Long userId) throws UserIncorrectDataEntryException;
    //Put UserAddress
    public UserDocModel  changeUserDocuments (UserDocumentsEntity userDoc,Long userId) throws UserIncorrectDataEntryException;





}
