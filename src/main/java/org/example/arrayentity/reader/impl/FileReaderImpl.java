package org.example.arrayentity.reader.impl;

import org.example.arrayentity.exception.PathException;
import org.example.arrayentity.reader.FileReader;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> read(String path, Charset charsets) throws IOException {
        if (path == null || path.isBlank()) {
            throw new PathException("filepath is incorrect!");
        }
        return Files.readAllLines(Path.of(path), charsets);
    }
}
