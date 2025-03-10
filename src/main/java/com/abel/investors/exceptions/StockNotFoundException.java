package com.abel.investors.exceptions;

public class StockNotFoundException extends RuntimeException {
    public StockNotFoundException(String message) {
        super(message);
    }

    public StockNotFoundException() {
        super("Stock Not Found");
    }
}
