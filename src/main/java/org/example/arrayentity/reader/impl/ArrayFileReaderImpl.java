package org.example.arrayentity.reader.impl;


import org.example.arrayentity.exception.InvalidPathException;
import org.example.arrayentity.reader.ArrayFileReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ArrayFileReaderImpl implements ArrayFileReader {
    private static final Logger logger = LoggerFactory.getLogger(ArrayFileReaderImpl.class);

    @Override
    public List<String> read(String path) throws IOException {
        if (path == null || path.isBlank()) {
            throw new InvalidPathException(String.format("filepath '%s' is incorrect!", path));
        }
        return Files.readAllLines(Path.of(path),  StandardCharsets.UTF_8);
    }
}
