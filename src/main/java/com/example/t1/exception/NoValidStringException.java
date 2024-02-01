package com.example.t1.exception;

public class NoValidStringException extends RuntimeException {
    public NoValidStringException() {
    }

    public NoValidStringException(String message) {
        super(message);
    }
}
