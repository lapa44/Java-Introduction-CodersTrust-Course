package pl.coderstrust.numbers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;
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

    @ParameterizedTest
    @DisplayName("Parameterized test for Processor constructor - should throw exception for null as NumbersProcessor")
    @MethodSource("processorNullNumbersProcessorArguments")
    void constructorShouldThrowExceptionForNullAsNumbersProcessor(NumbersProcessor numbersProcessor, FileProcessor fileProcessor) {
        assertThrows(IllegalArgumentException.class, () -> {
            new Processor(numbersProcessor, fileProcessor);
        });
    }

    private static Stream<Arguments> processorNullNumbersProcessorArguments() {
        return Stream.of(
                Arguments.of(null, null),
                Arguments.of(null, new FileProcessor())
        );
    }

    @ParameterizedTest
    @DisplayName("Parameterized test for Processor constructor - should throw exception for null as FileProcessor")
    @MethodSource("processorNullFileProcessorArguments")
    void constructorShouldThrowExceptionForNullAsFileProcessor(NumbersProcessor numbersProcessor, FileProcessor fileProcessor) {
        assertThrows(IllegalArgumentException.class, () -> {
            new Processor(numbersProcessor, fileProcessor);
        });
    }

    private static Stream<Arguments> processorNullFileProcessorArguments() {
        return Stream.of(
                Arguments.of(new NumbersProcessor(), null),
                Arguments.of(null, null)
        );
    }

    @ParameterizedTest
    @DisplayName("Parameterized test for process method - should throw exception for null as Input File")
    @MethodSource("processNullInputFileArguments")
    void processMethodShouldThrowExceptionForNullAsInputFile(String inputFilePath, String outputFilePath) {
        assertThrows(IllegalArgumentException.class, () -> {
            processor.process(inputFilePath, outputFilePath);
        });
    }

    private static Stream<Arguments> processNullInputFileArguments() {
        return Stream.of(
                Arguments.of(null, null),
                Arguments.of(null, "fakeFile.txt")
        );
    }

    @ParameterizedTest
    @DisplayName("Parameterized test for process method - should throw exception for null as Output File")
    @MethodSource("processNullOutputFileArguments")
    void processMethodShouldThrowExceptionForNullAsOutputFile(String inputFilePath, String outputFilePath) {
        assertThrows(IllegalArgumentException.class, () -> {
            processor.process(inputFilePath, outputFilePath);
        });
    }

    private static Stream<Arguments> processNullOutputFileArguments() {
        return Stream.of(
                Arguments.of(null, null),
                Arguments.of("fakeFile.txt", null)
        );
    }
}
