package org.example.arrayentity.reader;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.util.List;

public interface FileReader {
    List<String> read(String path, Charset charsets) throws IOException;
}
