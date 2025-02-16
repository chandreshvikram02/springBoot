package com.practice.springboot.exception;

public class IdNotFoundException extends RuntimeException {
    public IdNotFoundException(String message) {
        super(message);
    }

    public IdNotFoundException() {
    }
}
