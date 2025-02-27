package com.abel.investors.exceptions;

public class PasswordException extends RuntimeException {
    public PasswordException() {
        super("This password is not valid");
    }

    public PasswordException(String message) {
        super(message);
    }
}
