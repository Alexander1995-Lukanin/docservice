package com.example.docservice.controller;

import com.example.docservice.entity.UserNameEntity;
import com.example.docservice.exception.UserAlreadyExistException;
import com.example.docservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/users")
public class UserController {

    @Autowired
private UserService userService;

    @PostMapping
    public ResponseEntity registration (@RequestBody UserNameEntity user) {
        try {
            userService.registration(user);
            return ResponseEntity.ok("Пользователь успешно добавлен");
        }
        catch (UserAlreadyExistException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping ("/")
    public ResponseEntity getUsers (){
        try {
        return ResponseEntity.ok("Сервер работает");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
