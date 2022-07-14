package com.example.docservice.controller;

import com.example.docservice.entity.UserAddressEntity;
import com.example.docservice.entity.UserDocumentsEntity;
import com.example.docservice.entity.UserNameEntity;
import com.example.docservice.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/")
public class UserController {

private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping ("/users/registration/name")
    public ResponseEntity registrationUserName (@RequestBody UserNameEntity user) {
        try {
            userService.registrationUserName(user);
            return ResponseEntity.ok("ФИО пользователя успешно добавлены");
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
    @PostMapping ("/users/registration/address")
    public ResponseEntity registrationUserAddress (@RequestBody UserAddressEntity userAddress) {
        try {
            userService.registrationUserAddress(userAddress);
            return ResponseEntity.ok("Адресс пользователя успешно добавлены");
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PostMapping ("/users/registration/documents")
    public ResponseEntity registrationUserDocuments (@RequestBody UserDocumentsEntity userDocuments) {
        try {
            userService.registrationUserDocuments(userDocuments);
            return ResponseEntity.ok("Адресс пользователя успешно добавлены");
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping ("/users")
    public ResponseEntity getUsers (){
        try {
        return ResponseEntity.ok("Сервер работает");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
