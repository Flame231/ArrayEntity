package org.example.arrayentity.parser.impl;

import org.example.arrayentity.exception.InvalidStringException;
import org.example.arrayentity.parser.ArrayParser;
import org.example.arrayentity.validator.ArrayValidator;
import org.example.arrayentity.validator.impl.ArrayValidatorImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArrayParserImpl implements ArrayParser {
    private static final String DASH_SEQUENCE_PATTERN = "[\u2013\u2014]+";
    private static final String NUMBER_PATTERN = "-?\\d+";

    @Override
    public int[] parse(String data) {
        ArrayValidator validator = new ArrayValidatorImpl();
        if (!validator.validate(data)) {
            throw new InvalidStringException("Data string is invalid!");
        }
        data = data.replaceAll(DASH_SEQUENCE_PATTERN, "-").trim();
        Pattern pattern = Pattern.compile(NUMBER_PATTERN);
        Matcher matcher = pattern.matcher(data);
        List<String> numbersList = new ArrayList<>();
        while (matcher.find()) {
            numbersList.add(matcher.group());
        }
        int[] result = new int[numbersList.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.parseInt(numbersList.get(i));
        }
        return result;
    }
}
