package org.example.arrayentity.reader;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

public interface ArrayFileReader {
    List<String> read(String path) throws IOException;
}
