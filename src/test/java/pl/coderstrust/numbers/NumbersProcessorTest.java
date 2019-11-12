package pl.coderstrust.numbers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

class NumbersProcessorTest {

    @ParameterizedTest
    @DisplayName("Parameterized test for processLine - should return correct line")
    @MethodSource("correctLinesArguments")
    void shouldReturnCorrectResultForValidLine(String expected, String line) {
        assertEquals(expected, new NumbersProcessor().processLine(line));
    }

    private static Stream<Arguments> correctLinesArguments() {
        return Stream.of(
          Arguments.of("-1+-3+9=5", "-1     -3        9"),
          Arguments.of("1+100+34000=34101", "1 100 34000"),
          Arguments.of("1+-2+3+-4=-2", "1 -2 3 -4")
        );
    }

    @ParameterizedTest
    @DisplayName("Parameterized test for processLine - should return empty string")
    @MethodSource("invalidLinesArguments")
    void shouldReturnEmptyStringForInvalidLine(String line) {
        assertEquals("", new NumbersProcessor().processLine(line));
    }

    private static Stream<Arguments> invalidLinesArguments() {
        return Stream.of(
                Arguments.of("1 1** 34000"),
                Arguments.of("Some text 333"),
                Arguments.of((Object) null)
        );
    }
}
