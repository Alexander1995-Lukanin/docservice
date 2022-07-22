package com.example.docservice.service;

import com.example.docservice.entity.UserAddressEntity;
import com.example.docservice.entity.UserDocumentsEntity;
import com.example.docservice.entity.UserEntity;
import com.example.docservice.exception.UserIncorrectDataEntryException;
import com.example.docservice.exception.UserNotFaundException;
import com.example.docservice.model.UserAddModel;
import com.example.docservice.model.UserDocModel;
import com.example.docservice.model.UserNameModel;
import com.example.docservice.repository.UserCrudAddressRepository;
import com.example.docservice.repository.UserCrudDocumentsRepository;
import com.example.docservice.repository.UserCrudRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserService implements UserInterfaceService {
    private final UserCrudRepository userRepo;
    private  final UserCrudAddressRepository userAddRepo;
    private  final UserCrudDocumentsRepository userDocRepo;

    //Регистрация имени пользователя
    @Override
    public UserEntity registrationUser(UserEntity userName) throws UserIncorrectDataEntryException {
        if (userName == null) {
            throw new UserIncorrectDataEntryException("Введены некоректные данные");
        }
        return userRepo.save(userName);
    }

//Изменение ФИО
    @Override
    public UserNameModel changeUserName(UserEntity userNameChange,Long userId)/*todo*/ throws UserIncorrectDataEntryException {
        UserEntity newUserName = userRepo.findById(userId).get();
        //Если не нашли, такой пользователь не найден. Маперы.
        newUserName.setFirstName(userNameChange.getFirstName());
        //со всеми полями.
        newUserName.setLastName(userNameChange.getLastName());
        newUserName.setPatronymic(userNameChange.getPatronymic());
        if (userNameChange == null){
            throw new UserIncorrectDataEntryException("Введены некоректные данные");
        }
        return UserNameModel.toModel(userRepo.save(newUserName));
    }
    //Изменение адресса
    @Override
    public UserAddModel changeUserAddress (UserAddressEntity userAddChange, Long userId)/*todo*/ throws UserIncorrectDataEntryException {
        if ( userAddChange == null) {
            throw new UserIncorrectDataEntryException("Введены некоректные данные");
        }
        UserEntity newUserAddress = userRepo.findById(userId).get();
        userAddChange.setUserName(newUserAddress);
        return UserAddModel.toModel(userAddRepo.save(userAddChange)) ;
    }
    //Изменение данных документов
    @Override
    public UserDocModel changeUserDocuments(UserDocumentsEntity userDocChange, Long userId) /*todo*/ throws UserIncorrectDataEntryException {
        if (userDocChange == null) {
            throw new UserIncorrectDataEntryException("Введены некоректные данные");
        }
        UserEntity UserAddress = userRepo.findById(userId).get();
        userDocChange.setUserName(UserAddress);
        return UserDocModel.toModel(userDocRepo.save(userDocChange)) ;
    }


    //Получение ФИО по ID
    @Override
    public UserEntity getUsernameById (Long userId) throws UserNotFaundException {
        UserEntity userName =userRepo.findById(userId).get();
        if( userName==null)
            throw new UserNotFaundException("Пользователь не был найден");
        return userName;
    }

    //Получение данных по фамилии
    @Override
    public List<UserEntity> getUsernameByLastName(String lastName) throws UserNotFaundException {
        List<UserEntity> allByLastName = userRepo.findAllByLastName(lastName);
        return allByLastName ;
       
    }


    //Удаление пользователя
    @Override
    public void deleteUser(Long userId) throws UserIncorrectDataEntryException {
        userRepo.deleteById(userId);
    }


    @Override
    public UserAddModel getUserAddress(UserEntity userName) throws UserIncorrectDataEntryException {

        return null;
    }

    @Override
    public UserAddModel getUserAddress(UserDocumentsEntity userDoc) throws UserIncorrectDataEntryException {
        return null;
    }

    @Override
    public UserDocModel getUserDoc(UserEntity userName) throws UserIncorrectDataEntryException {
        return null;
    }


}
