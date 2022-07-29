package com.example.docservice.controller;

import com.example.docservice.entity.UserDocumentsEntity;
import com.example.docservice.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users/documents")
public class UserDocumentController {
    private final UserService userService;


    public UserDocumentController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping("/change/{id}")
    public ResponseEntity <?> changeUserDocuments(@RequestBody UserDocumentsEntity userDocuments, @PathVariable Long userId) {
        try {
            userService.changeUserDocuments(userDocuments, userId);
            return ResponseEntity.ok("Данные документов успешно изменены");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
