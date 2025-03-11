package com.abel.investors.exceptions;

public class AccountStockException extends RuntimeException {
    public AccountStockException() {
        super("Account Stock Error");
    }

    public AccountStockException(String message) {
        super(message);
    }
}
