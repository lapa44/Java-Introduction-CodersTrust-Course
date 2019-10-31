package pl.coderstrust.numbers;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

 class FileProcessor {
    public List<String> readLinesFromFile(String filePath) {
        if (filePath == null) {
            throw new NullPointerException();
        }
        try {
            return Files.readAllLines(Paths.get(filePath));
        } catch (Exception e) {
            System.out.println("Error in reading lines from file: " + e.getMessage());
            return null;
        }
    }

    public void writeLinesToFile(List<String> lines, String filePath) {
        if (lines == null || filePath == null) {
            throw new NullPointerException("resultLines and File name cannot be null.");
        }
        try {
            Files.write(Paths.get(filePath), lines);
        } catch (Exception e) {
            System.out.println("Error in writing lines to file: " + e.getMessage());
        }
    }
}
