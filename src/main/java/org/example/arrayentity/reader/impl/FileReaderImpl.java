package org.example.arrayentity.reader.impl;


import org.example.arrayentity.exception.InvalidPathException;
import org.example.arrayentity.reader.FileReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderImpl implements FileReader {
    private static final Logger logger = LoggerFactory.getLogger(FileReaderImpl.class);

    @Override
    public List<String> read(String path, Charset charsets) throws IOException {
        if (path == null || path.isBlank()) {
            throw new InvalidPathException("filepath is incorrect!");
        }
        return Files.readAllLines(Path.of(path), charsets);
    }
}
