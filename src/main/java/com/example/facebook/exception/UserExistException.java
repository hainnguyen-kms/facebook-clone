package com.example.facebook.exception;

import org.springframework.security.core.AuthenticationException;

public class UserExistException extends AuthenticationException {
    public UserExistException(String msg) {
        super(msg);
    }
}
