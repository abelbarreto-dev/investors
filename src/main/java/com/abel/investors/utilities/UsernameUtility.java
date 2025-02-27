package com.abel.investors.utilities;

import com.abel.investors.exceptions.UsernameException;

public class UsernameUtility {
    public static void checkUsername(String username) {
        if (username == null || username.isEmpty()) {
            throw new UsernameException("Username cannot be empty or null");
        }

        String regex = "^[a-zA-Z0-9._-]{3,16}$";

        if (!username.matches(regex)) {
            throw new UsernameException("Username contains invalid characters");
        }
    }
}
