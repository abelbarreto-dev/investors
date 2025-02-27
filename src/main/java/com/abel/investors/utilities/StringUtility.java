package com.abel.investors.utilities;

import com.abel.investors.exceptions.StringException;

public class StringUtility {
    public static void checkNullOrEmpty(String paramName, String value) {
        if (paramName == null || paramName.isEmpty()) {
            throw new StringException("Parameter name cannot be null or empty");
        }

        if (value == null || value.isEmpty()) {
            throw new StringException("Value '" + paramName + "' cannot be null or empty");
        }
    }

    public static void checkValueLength(String paramName, String value, int maxLength) {
        if (paramName == null || paramName.isEmpty()) {
            throw new StringException("Parameter name cannot be null or empty");
        }

        if (value == null || value.length() >= maxLength) {
            throw new StringException("Value '" + paramName + "' cannot be greater than " + maxLength);
        }
    }
}
