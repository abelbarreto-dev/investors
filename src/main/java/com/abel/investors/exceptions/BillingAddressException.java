package com.abel.investors.exceptions;

public class BillingAddressException extends RuntimeException {
    public BillingAddressException(String message) {
        super(message);
    }

    public BillingAddressException() {
        super("Billing Address Not Found");
    }
}
