package pl.coderstrust.numbers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FileProcessorTest {

    @Test
    @DisplayName("Unit test for readLinesFromLines Method - null argument")
    void readLinesFromFileMethodShouldThrowExceptionForNullFilePath() {
        assertThrows(IllegalArgumentException.class, () -> {
            new FileProcessor().readLinesFromFile(null);
        });
    }

    @ParameterizedTest
    @DisplayName("Parameterized test for writeLinesToFile method - should throw exception for null lines")
    @MethodSource("writeLinesToFileNullLines")
    void writeLinesToFileMethodShouldThrowExceptionForNullAsLines(List<String> lines, String filePath) {
        assertThrows(IllegalArgumentException.class, () -> {
            new FileProcessor().writeLinesToFile(lines, filePath);
        });
    }

    private static Stream<Arguments> writeLinesToFileNullLines() {
        return Stream.of(
                Arguments.of(null, "fakeFile.txt"),
                Arguments.of(null, ""),
                Arguments.of(null, null)
        );
    }

    @ParameterizedTest
    @DisplayName("Parameterized test for writeLinesToFile method - should throw exception for null file path")
    @MethodSource("writeLinesToFileNullFilePath")
    void writeLinesToFileMethodShouldThrowExceptionForNullAsFilePath(List<String> lines, String filePath) {
        assertThrows(IllegalArgumentException.class, () -> {
            new FileProcessor().writeLinesToFile(lines, filePath);
        });
    }

    private static Stream<Arguments> writeLinesToFileNullFilePath() {
        return Stream.of(
                Arguments.of(new ArrayList<String>(), null),
                Arguments.of(Arrays.asList("1+2+3=6", "3+4+5=12"), null),
                Arguments.of(Arrays.asList("-1+-2+-3=-6", "-4+-5+-6=-15"), null)
        );
    }
}
