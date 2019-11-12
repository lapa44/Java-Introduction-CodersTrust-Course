package pl.coderstrust.figures;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.stream.Stream;

class TrapezoidTest {
    @ParameterizedTest
    @DisplayName("Parameterized test for trapezoid area")
    @MethodSource("trapezoidAreaArguments")
    void shouldReturnAreaOfTrapezoid(double expected, double a, double b, double h) {
        assertEquals(expected, new Trapezoid(a, b, h).calculateArea(), 0.01);
    }

    private static Stream<Arguments> trapezoidAreaArguments() {
        return Stream.of(
                Arguments.of(1.0, 1.0d, 1.0d, 1.0d),
                Arguments.of(700, 10.0d, 25.0d, 40.0d),
                Arguments.of(4031.72, 321.253d, 13.33d, 24.10d),
                Arguments.of(6828.02, 18.46d, 999.13d, 13.42d),
                Arguments.of(2888.86, 42.47d, 141.3d, 31.44d)
        );
    }

    @ParameterizedTest
    @DisplayName("Parameterized test for invalid trapezoid side A")
    @ValueSource(doubles = {-1, -10, -13.2, 0})
    void shouldThrowIllegalArgumentExceptionForInvalidSideA(double a) {
        assertThrows(IllegalArgumentException.class, () -> new Trapezoid(a, 2.0d, 2.0d));
    }

    @ParameterizedTest
    @DisplayName("Parameterized test for invalid trapezoid side B")
    @ValueSource(doubles = {-44, -34.231, -24.5, 0})
    void shouldThrowIllegalArgumentExceptionForInvalidSideB(double b) {
        assertThrows(IllegalArgumentException.class, () -> new Trapezoid(2.0d, b, 2.0d));
    }

    @ParameterizedTest
    @DisplayName("Parameterized test for invalid trapezoid height")
    @ValueSource(doubles = {-183.34, -18.88, -34.4, 0})
    void shouldThrowIllegalArgumentExceptionForInvalidHeight(double h) {
        assertThrows(IllegalArgumentException.class, () -> new Trapezoid(2.0d, 2.0d, h));
    }
}
