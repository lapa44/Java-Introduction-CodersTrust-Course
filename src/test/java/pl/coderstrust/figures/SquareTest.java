package pl.coderstrust.figures;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SquareTest {

    @ParameterizedTest
    @DisplayName("Parameterized test for square area")
    @MethodSource("squareArguments")
    void shouldReturnAreaOfSquare(double expected, double a) {
        assertEquals(expected, new Square(a).calculateArea());
    }

    private static Stream<Arguments> squareArguments() {
        return Stream.of(
                Arguments.of(1.0d, 1.0d),
                Arguments.of(625.0d, 25.0d),
                Arguments.of(179.56d, 13.4d),
                Arguments.of(998001d, 999d)
        );
    }

    @ParameterizedTest
    @DisplayName("Parameterized test for negative rectangle sides")
    @ValueSource(doubles = {-1.33d, 0d, -1230d})
    void shouldThrowIllegalArgumentException(double a) {
        assertThrows(IllegalArgumentException.class, () -> {
            new Square(a);
        });
    }
}
