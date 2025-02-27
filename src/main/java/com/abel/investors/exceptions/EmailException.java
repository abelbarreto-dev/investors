package com.abel.investors.exceptions;

public class EmailException extends RuntimeException {
    public EmailException(String message) {
        super(message);
    }

    public EmailException() {
        super("This email address is not valid");
    }
}
