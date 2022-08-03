package com.example.docservice.exception;

public class UserIncorrectDataEntryException extends RuntimeException {
    public UserIncorrectDataEntryException(String message) {
        super(message);
    }
}
