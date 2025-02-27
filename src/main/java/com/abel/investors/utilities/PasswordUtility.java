package com.abel.investors.utilities;

import com.abel.investors.exceptions.PasswordException;

public class PasswordUtility {
    public static void checkPassword(String password, int length) {
        if (password == null || password.isEmpty()) {
            throw new PasswordException("Password cannot be null or empty");
        }

        if (password.contains(" ")) {
            throw new PasswordException("Password cannot contains spaces");
        }

        if (password.length() < length) {
            throw new PasswordException("Password must be at least " + length);
        }
    }
}
