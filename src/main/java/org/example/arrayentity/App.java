package org.example.arrayentity;

import org.example.arrayentity.factory.ArrayFactory;
import org.example.arrayentity.factory.IntArrayFactory;

import org.example.arrayentity.parser.Parser;
import org.example.arrayentity.parser.impl.ParserImpl;
import org.example.arrayentity.reader.FileReader;
import org.example.arrayentity.reader.impl.FileReaderImpl;
import org.example.arrayentity.validator.ArrayValidator;
import org.example.arrayentity.validator.impl.ArrayValidatorImpl;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws IOException {
        ArrayFactory arrayFactory = new IntArrayFactory();
        FileReader fileReader = new FileReaderImpl();
        List<String> data = fileReader.read("data/data.txt", StandardCharsets.UTF_8);
        ArrayValidator arrayValidator = new ArrayValidatorImpl();
        Parser parser = new ParserImpl();
        if (arrayValidator.validate(data.get(2))) {
            arrayFactory.initializeArray(parser.parse(data.get(2)));
        }

    }
}
