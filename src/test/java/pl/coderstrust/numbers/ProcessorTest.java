package pl.coderstrust.numbers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import java.io.IOException;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ProcessorTest {

    @Mock
    private NumbersProcessor numbersProcessor;
    @Mock
    private FileProcessor fileProcessor;

    @InjectMocks
    private Processor processor;

    @Test
    void shouldProcessProvidedInputFileAndSaveResultToProvidedOutputFile() throws IOException {
        when(fileProcessor.readLinesFromFile("numbersInput.txt")).thenReturn(Arrays.asList("1 2 3", "4 5 6", "-1 -2 -3"));
        when(numbersProcessor.processLine("1 2 3")).thenReturn("1+2+3=6");
        when(numbersProcessor.processLine("4 5 6")).thenReturn("4+5+6=15");
        when(numbersProcessor.processLine("-1 -2 -3")).thenReturn("-1+-2+-3=-6");

        processor.process("numbersInput.txt", "numbersOutput.txt");

        verify(fileProcessor).readLinesFromFile("numbersInput.txt");
        verify(numbersProcessor).processLine("1 2 3");
        verify(numbersProcessor).processLine("4 5 6");
        verify(numbersProcessor).processLine("-1 -2 -3");
        verify(fileProcessor).writeLinesToFile(Arrays.asList("1+2+3=6", "4+5+6=15", "-1+-2+-3=-6"), "numbersOutput.txt");
    }

    @Test
    @DisplayName("Unit test for Processor constructor - should throw exception for null as NumbersProcessor")
    void constructorShouldThrowExceptionForNullAsNumbersProcessor() {
        assertThrows(IllegalArgumentException.class, () -> new Processor(null, new FileProcessor()));
    }

    @Test
    @DisplayName("Unit test for Processor constructor - should throw exception for null as FileProcessor")
    void constructorShouldThrowExceptionForNullAsFileProcessor() {
        assertThrows(IllegalArgumentException.class, () -> new Processor(new NumbersProcessor(), null));
    }

    @Test
    @DisplayName("Unit test for process method - should throw exception for null as Input File")
    void processMethodShouldThrowExceptionForNullAsInputFile() {
        assertThrows(IllegalArgumentException.class, () -> processor.process(null, "file.txt"));
    }

    @Test
    @DisplayName("Unit test for process method - should throw exception for null as Output File")
    void processMethodShouldThrowExceptionForNullAsOutputFile() {
        assertThrows(IllegalArgumentException.class, () -> processor.process("file.txt", null));
    }
}
