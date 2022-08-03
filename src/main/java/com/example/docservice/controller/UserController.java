package com.example.docservice.controller;


import com.example.docservice.entity.User;
import com.example.docservice.exception.UserIncorrectDataEntryException;
import com.example.docservice.service.UserServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserServiceImpl userService;


    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    /*Регистрация пользователя в базу данных*/
    @PostMapping("/users")
    public ResponseEntity<?> registrationUser(@RequestBody @Valid User user)  {
        userService.registrationUser(user);
        return ResponseEntity.ok("Пользователь успешно зарегистрировася");
    }

    // Получение пользователя по ID
    @GetMapping("/users/{userId}")
    public User getUsers(@PathVariable Long userId) {
            return userService.getUserById(userId);
    }

    // Получение всех пользователей
    @GetMapping("/users")
    public Page<User> getUsers(@PageableDefault(value = 2, page = 0, size = 10) Pageable pageable) {
        return userService.getUserAll(pageable);
    }

    //Spring exception handler посмотреть
    // Удаление пользователя по ID
    @DeleteMapping(("/users/{userId}"))
    public ResponseEntity<?> DeleteUsers(@PathVariable Long userId) {
            userService.deleteUser(userId);
        return ResponseEntity.ok("Пользователь успешно зарегистрировася");
    }

    //Получение пользователя по фамилии
    @GetMapping("/users/lastName/{lastName}")
    public List<User> getUsernameLastName(@PathVariable String lastName)  {
        List<User> users = userService.getUserByLastName(lastName);
        return users;
    }
//Сортировки по имени
    @GetMapping("/sorted")
    public Page<User> findAllUsersSortedByName(@Valid @SortDefault(sort = "firstName",
            direction = Sort.Direction.ASC) @PageableDefault(value = 2, page = 0, size = 10) Pageable pageable) throws UserIncorrectDataEntryException {
        return userService.findAllUsersSortedByFirstName(pageable);
    }


}
