package com.example.docservice.webClient.service;

import com.example.docservice.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

import java.time.Duration;

@RequiredArgsConstructor
//@AllArgsConstructor
@Service
public class UserServiceIntegrationImpl implements UserServiceIntegration {
    private final WebClient webClient;

    //Вынести в отдельный класс разделить на интрефейс. В пекейдж отдельный. Логика в юзер сервисе. Вызывается.
    @Override
    public Mono<User> getUserByIdAsync(String id) {
        return webClient
                .get()
                .uri(String.join("", "/user/", id))
                .retrieve()
                .bodyToMono(User.class);
    }

    @Override
    public User getUserByIdSync(final String id) {
        return webClient
                .get()
                .uri(String.join("", "/user/", id))
                .retrieve()
                .bodyToMono(User.class)
                .block();
    }
    //Отдельно получает юзера, отдельно сохранение.

    @Override
    public User getUserWithRetry(String id) {
        return webClient
                .get()
                .uri(String.join("", "/user/", id))
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
