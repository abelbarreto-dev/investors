package com.abel.investors.utilities;

import com.abel.investors.exceptions.EmailException;

public class EmailUtility {
    public static void validateEmail(String email) {
        if (email == null || email.isEmpty()) {
            throw new EmailException("email field can't be empty");
        }

        if (!isEmailValid(email)) {
            throw new EmailException("Email contains invalid characters");
        }
    }

    public static boolean isEmailValid(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        return email.matches(regex);
    }
}
