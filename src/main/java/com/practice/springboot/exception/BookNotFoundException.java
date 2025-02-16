package com.practice.springboot.exception;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException() {
    }

    public BookNotFoundException(String message) {
        super(message);
    }
}
