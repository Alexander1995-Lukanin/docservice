package com.example.docservice.service;

import com.example.docservice.entity.UserAddressEntity;
import com.example.docservice.entity.UserDocumentsEntity;
import com.example.docservice.entity.UserNameEntity;
import com.example.docservice.exception.UserIncorrectDataEntryException;
import com.example.docservice.repository.UserCrudAddressRepository;
import com.example.docservice.repository.UserCrudDocumentsRepository;
import com.example.docservice.repository.UserCrudRepository;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    private final UserCrudRepository userRepo;
    private  final UserCrudAddressRepository userAddRepo;
    private  final UserCrudDocumentsRepository userDocRepo;

    public UserService(UserCrudRepository userRepo, UserCrudAddressRepository userAddRepo, UserCrudDocumentsRepository userDocRepo) {
        this.userRepo = userRepo;
        this.userAddRepo = userAddRepo;
        this.userDocRepo = userDocRepo;
    }


    public UserNameEntity registrationUserName (UserNameEntity userName) throws UserIncorrectDataEntryException {
        if (userName == null) {
            throw new UserIncorrectDataEntryException("Введены некоректные данные");
        }
        return userRepo.save(userName);
    }

    public UserAddressEntity registrationUserAddress (UserAddressEntity userAddress) throws UserIncorrectDataEntryException {
        if (userAddress == null) {
            throw new UserIncorrectDataEntryException("Введены некоректные данные");
        }
        return userAddRepo.save(userAddress);
    }

    public UserDocumentsEntity registrationUserDocuments (UserDocumentsEntity userDoc) throws UserIncorrectDataEntryException {
        if (userDoc == null){
         throw new UserIncorrectDataEntryException("Введены некоректные данные");
        }
        return userDocRepo.save(userDoc);
    }
}
