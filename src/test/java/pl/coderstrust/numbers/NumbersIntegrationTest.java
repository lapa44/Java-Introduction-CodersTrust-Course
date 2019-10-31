package pl.coderstrust.numbers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class NumbersIntegrationTest {

    @Test
    @DisplayName("Integration test for numbers task")
    void shouldReadProvidedInputFileAndSaveResultToProvidedOutputFile() throws IOException {
        NumbersProcessor numbersProcessor = new NumbersProcessor();
        FileProcessor fileProcessor = new FileProcessor();
        Processor processor = new Processor(numbersProcessor, fileProcessor);
        processor.process("src/test/resources/numbersInput.txt", "src/test/resources/numbersOutput.txt");
        assertEquals(Files.readAllLines(Paths.get("src/test/resources/numbersExpected.txt")), Files.readAllLines(Paths.get("src/test/resources/numbersOutput.txt")));
    }
}
