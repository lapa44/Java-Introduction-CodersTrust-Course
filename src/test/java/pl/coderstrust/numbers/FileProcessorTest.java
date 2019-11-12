package pl.coderstrust.numbers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FileProcessorTest {

    @Test
    @DisplayName("Unit test for readLinesFromLines Method - null argument")
    void readLinesFromFileMethodShouldThrowExceptionForNullFilePath() {
        assertThrows(IllegalArgumentException.class, () -> new FileProcessor().readLinesFromFile(null));
    }

    @Test
    @DisplayName("Unit test for writeLinesToFile method - should throw exception for null lines")
    void writeLinesToFileMethodShouldThrowExceptionForNullAsLines() {
        assertThrows(IllegalArgumentException.class, () -> new FileProcessor().writeLinesToFile(null, "file.txt"));
    }

    @Test
    @DisplayName("Unit test for writeLinesToFile method - should throw exception for null file path")
    void writeLinesToFileMethodShouldThrowExceptionForNullAsFilePath() {
        assertThrows(IllegalArgumentException.class, () -> new FileProcessor().writeLinesToFile(new ArrayList<>(), null));
    }
}
