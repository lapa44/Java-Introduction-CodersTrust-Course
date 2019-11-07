package pl.coderstrust.numbers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

 class FileProcessor {
    public List<String> readLinesFromFile(String filePath) throws IOException {
        if (filePath == null) {
            throw new IllegalArgumentException("File path cannot be null");
        }
        return Files.readAllLines(Paths.get(filePath));
    }

    public void writeLinesToFile(List<String> lines, String filePath) throws IOException {
        if (lines == null) {
            throw new IllegalArgumentException("Result lines cannot be null.");
        }
        if (filePath == null) {
            throw new IllegalArgumentException("File path cannot be null");
        }
        Files.write(Paths.get(filePath), lines);
    }
}
