package pl.coderstrust.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamNumbers {

    private static final Path INPUT_PATH = Paths.get("src/main/resources/numbersInput.txt");
    private static final Path OUTPUT_PATH = Paths.get("src/main/resources/numbersOutput.txt");
    private static final String NUMBERS_PATTERN = "^[-?\\d\\s]+$";

    public static void main(String[] args) throws IOException {
        Stream<String> inputFromFile = Files.lines(INPUT_PATH)
                .filter(s -> s.matches(NUMBERS_PATTERN))
                .map(s -> {
                    s = deleteWhitespacesToFirstDigit(s);
                    int e = Arrays.stream(s.split("\\s+")).mapToInt(Integer::valueOf).sum();
                    s = Arrays.stream(s.split("\\s+")).reduce("", (s1, s2) -> s1 + s2 + "+");
                    return s.substring(0, s.length() - 1)
                            + "=" + e;
                    });
        Files.write(OUTPUT_PATH, inputFromFile.collect(Collectors.toList()));
    }

    private static String deleteWhitespacesToFirstDigit(String s) {
        int index = 0;
        while (s.charAt(index) == ' ') {
            index++;
        }
        return s.substring(index);
    }
}
