package com.example.docservice.service;

import com.example.docservice.entity.User;
import com.example.docservice.exception.UserIncorrectDataEntryException;
import com.example.docservice.exception.UserNotFaundException;
import com.example.docservice.repository.UserCrudRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserCrudRepository userRepo;
    private final WebClient webClient;

    @Override
    public void registrationUser(User user) throws UserIncorrectDataEntryException {
        if (user == null) {
            throw new UserIncorrectDataEntryException("Введенны некоректные данные");
        }
        userRepo.save(user);
    }

    @Override
    public User getUserById(Long userId) throws UserNotFaundException {
        User user;
        Optional<User> optional = userRepo.findById(userId);
        if (optional.isPresent()) {
            user = optional.get();
        } else throw new UserNotFaundException("Такого пользователя не существет");
        return user;
    }

    @Override
    public Page<User> getUserAll(Pageable pageable) {
        return userRepo.findAll(pageable);
    }

    @Override
    public Page<User> findAllUsersSortedByFirstName(@SortDefault(sort = "firstName",direction = Sort.Direction.ASC)
                                                    @PageableDefault(value = 2, page = 0, size = 10) Pageable pageable)
    {
        return userRepo.findAll(pageable);
    }

    @Override
    public List<User> getUserByLastName(String lastName) {
        List<User> users = userRepo.findAllByLastName(lastName);
        return users;
    }

    @Override
    public void deleteUser(Long userId) throws UserNotFaundException {
        if (userRepo.findById(userId).isPresent()) {
            userRepo.deleteById(userId);
        } else throw new UserNotFaundException("Такого пользователя не существет");
    }

    @Override
    public Mono<User> getUserByIdAsync(String id) {
        return webClient
                .get()
                .uri(String.join("", "/users/", id))
                .retrieve()
                .bodyToMono(User.class);
    }

    @Override
    public User getUserByIdSync(final String id) {
        return webClient
                .get()
                .uri(String.join("", "/users/", id))
                .retrieve()
                .bodyToMono(User.class)
                .block();
    }

    @Override
    public User getUserWithRetry(String id) {
        return webClient
                .get()
                .uri(String.join("", "/users/", id))
                .retrieve()
                .bodyToMono(User.class)
                .retryWhen(Retry.fixedDelay(3, Duration.ofMillis(100)))
                .block();
    }

    @Override
    public User getUserWithFallback(String id) {
        ////        return webClient
////                .get()
////                .uri(String.join("", "/broken-url/", id))
////                .retrieve()
////                .bodyToMono(User.class)
////                .doOnError(error -> log.error("An error has occurred {}", error.getMessage()))
////                .onErrorResume(error -> Mono.just(new User()))
////                .block();
        return null;
    }

    @Override
    public User getUserWithErrorHandling(String id) {
        return webClient
                .get()
                .uri(String.join("", "/broken-url/", id))
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError,
                        error -> Mono.error(new RuntimeException("API not found")))
                .onStatus(HttpStatus::is5xxServerError,
                        error -> Mono.error(new RuntimeException("Server is not responding")))
                .bodyToMono(User.class)
                .block();
    }

}
