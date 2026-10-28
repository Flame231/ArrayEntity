package org.example.arrayentity.parser.impl;

import org.example.arrayentity.parser.Parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserImpl implements Parser {
    @Override
    public int[] parse(String data) {
        Pattern pattern = Pattern.compile("\\d+");
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
