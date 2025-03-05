package com.abel.investors.exceptions;

import lombok.Getter;

@Getter
public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException(String message) {
        super(message);
    }

    public AccountNotFoundException() {
        super("Account Not Found");
    }
}
