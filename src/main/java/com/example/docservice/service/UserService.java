package com.example.docservice.service;

import com.example.docservice.entity.UserNameEntity;
import com.example.docservice.exception.UserAlreadyExistException;
import com.example.docservice.repository.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserCrudRepository userRepo;

    public UserNameEntity registration (UserNameEntity user) throws UserAlreadyExistException {
        if(userRepo.findByUserFirstName(user.getFirstname())  !=null){
            throw  new UserAlreadyExistException("Пользователь уже существует");
        }
        return userRepo.save(user);
    }
}
