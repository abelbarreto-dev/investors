package com.abel.investors.utilities;

import com.abel.investors.exceptions.EmailException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailUtility {
    public static void validateEmail(String email) {
        if (email.isEmpty()) {
            throw new EmailException("email field can't be empty");
        }

        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(email);

        if (!matcher.matches()) {
            throw new EmailException();
        }
    }
}
