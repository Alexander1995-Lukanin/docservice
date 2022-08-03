package com.example.docservice.webClient.service;

import com.example.docservice.entity.User;
import reactor.core.publisher.Mono;

public interface UserServiceIntegration {


    //WebClient
    Mono<User> getUserByIdAsync(final String id);

    User getUserByIdSync(final String id);

    User getUserWithRetry(final String id);

    User getUserWithFallback(final String id);

    User getUserWithErrorHandling(final String id);

}

