package pl.coderstrust.numbers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ProcessorIT {

    @Test
    @DisplayName("Integration test for numbers task")
    void shouldReadProvidedInputFileAndSaveResultToProvidedOutputFile() throws IOException {
        String inputFilePath = "src/test/resources/numbersInput.txt";
        String outputFilePath = "src/test/resources/numbersOutput.txt";
        String expectedFilePath = "src/test/resources/numbersExpected.txt";
        NumbersProcessor numbersProcessor = new NumbersProcessor();
        FileProcessor fileProcessor = new FileProcessor();
        Processor processor = new Processor(numbersProcessor, fileProcessor);
        processor.process(inputFilePath, outputFilePath);
        assertEquals(Files.readAllLines(Paths.get(expectedFilePath)), Files.readAllLines(Paths.get(outputFilePath)));
    }
}
