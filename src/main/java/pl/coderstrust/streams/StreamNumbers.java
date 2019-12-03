package pl.coderstrust.streams;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.stream.Stream;

public class StreamNumbers {

    private static final String INPUT_PATH = "src/main/resources/numbersInput.txt";
    private static final String OUTPUT_PATH = "src/main/resources/numbersOutput.txt";
    private static final String NUMBERS_PATTERN = "^[-?\\d\\s]+$";

    public static void main(String[] args) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(OUTPUT_PATH));
             Stream<String> lines = new BufferedReader(new FileReader(INPUT_PATH)).lines()) {
                    lines.filter(StreamNumbers::isLineValid)
                    .map(line -> line.trim().split("\\s+"))
                    .map(arrayOfNumbers -> {
                        int sum = Arrays.stream(arrayOfNumbers).mapToInt(Integer::parseInt).sum();
                        String numbers = Arrays.stream(arrayOfNumbers).reduce((s1, s2) -> String.format("%s+%s", s1, s2)).get();
                        return String.format("%s=%d", numbers, sum);
                    })
                    .forEach(writer::println);
        }
    }

    private static boolean isLineValid(String line) {
        return line.matches(NUMBERS_PATTERN);
    }
}
