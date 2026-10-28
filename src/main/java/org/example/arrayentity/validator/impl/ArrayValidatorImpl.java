package org.example.arrayentity.validator.impl;

import org.example.arrayentity.validator.ArrayValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArrayValidatorImpl implements ArrayValidator {

    private static final String DELIMITED_NUMBERS_PATTERN = "^([;,\\s-]?\\d+[;,\\s-]?)+$";
    private static final String DASH_SEQUENCE_PATTERN = "[\u2013\u2014]+";
    private static final Pattern pattern = Pattern.compile(DELIMITED_NUMBERS_PATTERN);

    @Override
    public boolean validate(String data) {
        if (data == null || data.isBlank()) {
            return false;
        }
        data = data.replaceAll(DASH_SEQUENCE_PATTERN, "-");
        Matcher matcher = pattern.matcher(data);
        if (!matcher.matches()) {
            return false;
        }
        return true;
    }
}
