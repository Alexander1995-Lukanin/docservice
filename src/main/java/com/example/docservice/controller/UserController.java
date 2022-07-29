package com.example.docservice.controller;


import com.example.docservice.entity.UserEntity;
import com.example.docservice.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    /*Регистрация пользователя в базу данных*/
    @PostMapping("/registration")
    public ResponseEntity <?> registrationUser(@RequestBody UserEntity user) {
        try {
            userService.registrationUser(user);
            return ResponseEntity.ok("Пользователь успешно добавлен");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
    /*Изменение пользователя в базе данных*/
    @PutMapping("/change/{id}")
    public ResponseEntity <?> changeUserName(@RequestBody UserEntity user, @PathVariable Long id) {
        try {
            userService.changeUserName(user,id);
            return ResponseEntity.ok("Данные пользователя успешно изменены");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping("/name/{id}")
    public ResponseEntity <?> getUsers(@PathVariable Long id) {
        try {
            userService.getUsernameById(id);
            return ResponseEntity.ok("Все ок");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @DeleteMapping(("/delete/{id}"))
    public ResponseEntity <?> DeleteUsers(@PathVariable Long id) {

        try {
            userService.deleteUser(id);
            return ResponseEntity.ok("Данные пользователя успешно удалены");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping("/lastName/{lastName}")
    public ResponseEntity <?> getUsernameLastName(@PathVariable String lastName) {
        try {
            userService.getUsernameByLastName(lastName);
            return ResponseEntity.ok("Данные пользователя успешно переданы");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

}
