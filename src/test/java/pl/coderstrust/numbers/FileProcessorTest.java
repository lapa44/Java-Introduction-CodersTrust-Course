package pl.coderstrust.numbers;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FileProcessorTest {

    @Test
    @DisplayName("Unit test for readLinesFromLines Method - null argument")
    void shouldThrowNullPointerExceptionInReadLinesFromFile() {
        FileProcessor fileProcessor = new FileProcessor();
        assertThrows(NullPointerException.class, () -> {
            fileProcessor.readLinesFromFile(null);
        });
    }

    @Test
    @DisplayName("Unite test for readLinesFromFile method")
    void shouldReadLinesFromFile() {
        FileProcessor fileProcessor = new FileProcessor();
        List<String> expected = Arrays.asList("1 2 3",
                                              "4 5 6",
                                              " -1 -2                    -3",
                                              "-8 8 -4 4 4 4");
        assertEquals(expected, fileProcessor.readLinesFromFile("numbersInput.txt"));
    }

    @ParameterizedTest
    @DisplayName("Parameterized test for writeLinesToFile method - should throw exception")
    @MethodSource("writeLinesToFileNullArguments")
    void shouldThrowNullPointerExceptionInWriteLinesToFile(List<String> lines, String filePath) {
        FileProcessor fileProcessor = new FileProcessor();
        assertThrows(NullPointerException.class, () -> {
            fileProcessor.writeLinesToFile(lines, filePath);
        });
    }

    private static Stream<Arguments> writeLinesToFileNullArguments() {
        return Stream.of(
                Arguments.of(new ArrayList<String>(), null),
                Arguments.of(null, ""),
                Arguments.of(null, null)
        );
    }
}
