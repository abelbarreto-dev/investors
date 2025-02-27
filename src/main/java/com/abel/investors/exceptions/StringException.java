package com.abel.investors.exceptions;

public class StringException extends RuntimeException {
    public StringException() {
        super("The string provided is invalid");
    }

    public StringException(String message) {
        super(message);
    }
}
