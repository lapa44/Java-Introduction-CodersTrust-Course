package pl.coderstrust.numbers;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import java.util.Arrays;

import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

class ProcessorTest {

    @Mock
    NumbersProcessor numbersProcessor;
    @Mock
    FileProcessor fileProcessor;

    @InjectMocks
    Processor processor;

    @Test
    public void shouldProcessProvidedInputFileAndSaveResultToProvidedOutputFile() {
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

    @Test
    public void shouldThrowExceptionForNoFile() {
        initMocks(this);
        when(fileProcessor.readLinesFromFile("fakeFile.txt")).thenReturn(null);
        doThrow(NullPointerException.class).when(fileProcessor).readLinesFromFile("fakeFile.txt");
    }

}