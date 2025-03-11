package com.abel.investors.exceptions;

import lombok.Getter;

@Getter
public class AccountStockException extends RuntimeException {
    private int status = 400;

    public AccountStockException(int status) {
        super("Account Stock Error");

        this.status = status;
    }

    public AccountStockException(String message, int status) {
        super(message);
        this.status = status;
    }
}
