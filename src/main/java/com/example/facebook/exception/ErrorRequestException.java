package com.example.facebook.exception;

public class ErrorRequestException extends RuntimeException {
    public ErrorRequestException(String msg) {
        super(msg);
    }
}
