package com.example.docservice.service;

import com.example.docservice.entity.User;
import com.example.docservice.exception.UserIncorrectDataEntryException;
import com.example.docservice.exception.UserNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.MethodArgumentNotValidException;
import reactor.core.publisher.Mono;

import java.util.List;

public interface UserService {

    //Post UserRegistration
    void registrationUser(User userName) throws UserIncorrectDataEntryException, MethodArgumentNotValidException;

    //Get UserByID
    User getUserById(Long UserId) throws UserNotFoundException;

    //Get UserALL
    Page<User> getUserAll(Pageable pageable);

    Page<User> findAllUsersSortedByFirstName(@SortDefault(sort = "firstName",
            direction = Sort.Direction.ASC) Pageable pageable);

    //Put User
    List<User> getUserByLastName(String LastName);

    void deleteUser(Long userId) throws UserNotFoundException;

    //WebClient
    Mono<User> getUserByIdAsync(final String id);

    User getUserByIdSync(final String id);

    User getUserWithRetry(final String id);

    User getUserWithFallback(final String id);

    User getUserWithErrorHandling(final String id);

}

