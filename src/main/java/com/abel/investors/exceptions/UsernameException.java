package com.abel.investors.exceptions;

public class UsernameException extends RuntimeException {
    public UsernameException(String message) {
        super(message);
    }

    public UsernameException() {
        super("This username is not valid");
    }
}
