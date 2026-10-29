package org.example.arrayentity.validator.impl;

import org.example.arrayentity.validator.ArrayValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArrayValidatorImpl implements ArrayValidator {

    private static final String DELIMITED_NUMBERS_PATTERN = "^-?\\d{1,9}([;,\\s-]+-?\\d{1,9})*$";
    private static final String DASH_SEQUENCE_PATTERN = "[\u2013\u2014]+";
    private static final Pattern pattern = Pattern.compile(DELIMITED_NUMBERS_PATTERN);

    @Override
    public boolean validate(String data) {
        if (data == null || data.isBlank()) {
            return false;
        }
        data = data.replaceAll(DASH_SEQUENCE_PATTERN, "-").trim();
        Matcher matcher = pattern.matcher(data);
        return matcher.matches();
    }
}
