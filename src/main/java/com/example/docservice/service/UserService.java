package com.example.docservice.service;

import com.example.docservice.entity.User;
import com.example.docservice.exception.UserIncorrectDataEntryException;
import com.example.docservice.exception.UserNotFaundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import reactor.core.publisher.Mono;

import java.util.List;

public interface UserService {

    //Post UserRegistration
    void registrationUser(User userName) throws UserIncorrectDataEntryException;

    //Get UserByID
    User getUserById(Long UserId) throws UserNotFaundException;

    //Get UserALL
    Page<User> getUserAll(Pageable pageable);

    Page<User> findAllUsersSortedByFirstName(@SortDefault(sort = "firstName",
            direction = Sort.Direction.ASC) Pageable pageable);

    //Put User
    List<User> getUserByLastName(String LastName);

    void deleteUser(Long userId) throws UserNotFaundException;

    //WebClient
    Mono<User> getUserByIdAsync(final String id);

    User getUserByIdSync(final String id);

    User getUserWithRetry(final String id);

    User getUserWithFallback(final String id);

    User getUserWithErrorHandling(final String id);

}

