package pl.coderstrust.numbers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

class NumbersProcessorTest {

    @ParameterizedTest
    @DisplayName("Parameterized test for processLine")
    @MethodSource("processLineArguments")
    void shouldValidateLine(String expected, String line) {
        NumbersProcessor numbersProcessor = new NumbersProcessor();
        assertEquals(expected, numbersProcessor.processLine(line));
    }

    private static Stream<Arguments> processLineArguments() {
        return Stream.of(
          Arguments.of("-1+-3+9=5", "-1     -3        9"),
          Arguments.of("1+100+34000=34101", "1 100 34000"),
          Arguments.of("", "Some text 333"),
          Arguments.of("", null)
        );
    }
}
