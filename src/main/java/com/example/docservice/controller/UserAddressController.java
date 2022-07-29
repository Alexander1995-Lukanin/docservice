package com.example.docservice.controller;

import com.example.docservice.entity.UserAddressEntity;
import com.example.docservice.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users/address")
public class UserAddressController {
    private final UserService userService;


    public UserAddressController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping("/change/{id}")
    public ResponseEntity <?> changeUserAddress (@RequestBody UserAddressEntity changeUserAddress, @PathVariable Long userId) {
        try {
            userService.changeUserAddress(changeUserAddress, userId);
            return ResponseEntity.ok("Данные о адрессе пользователя успешно изменены");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
