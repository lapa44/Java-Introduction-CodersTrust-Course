package pl.coderstrust.numbers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import java.util.Arrays;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

class ProcessorTest {

    @Mock
    NumbersProcessor numbersProcessor;
    @Mock
    FileProcessor fileProcessor;

    @InjectMocks
    Processor processor;

    @Test
    void shouldProcessProvidedInputFileAndSaveResultToProvidedOutputFile() {
        initMocks(this);
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
    @DisplayName("Parameterized test for Processor constructor - should throw exception")
    @MethodSource("processorArguments")
    void shouldThrowNullPointerExceptionConstructor(NumbersProcessor numbersProcessor, FileProcessor fileProcessor) {
        assertThrows(NullPointerException.class, () -> {
            new Processor(numbersProcessor, fileProcessor);
        });
    }

    private static Stream<Arguments> processorArguments() {
        return Stream.of(
                Arguments.of(null, null),
                Arguments.of(new NumbersProcessor(), null),
                Arguments.of(null, new FileProcessor())
        );
    }

    @ParameterizedTest
    @DisplayName("Parameterized test for process method - should throw exception")
    @MethodSource("processArguments")
    void shouldThrowNullPointerExceptionProcessMethod(String inputFilePath, String outputFilePath) {
        assertThrows(NullPointerException.class, () -> {
            processor.process(inputFilePath, outputFilePath);
        });
    }

    private static Stream<Arguments> processArguments() {
        return Stream.of(
                Arguments.of(null, null),
                Arguments.of("fakeFile.txt", null),
                Arguments.of(null, "fakeFile.txt")
        );
    }
}
