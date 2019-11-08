package pl.coderstrust.figures;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
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
    @DisplayName("Parameterized test for negative trapezoid side a")
    @MethodSource("trapezoidNegativeArgumentsAsSideA")
    void shouldThrowIllegalArgumentExceptionForInvalidSideA(double a, double b, double h) {
        assertThrows(IllegalArgumentException.class, () -> {
            new Trapezoid(a, b, h);
        });
    }

    private static Stream<Arguments> trapezoidNegativeArgumentsAsSideA() {
        return Stream.of(
                Arguments.of(-1.0d, 44.0d, 183.34d),
                Arguments.of(-10d, 34.231d, 18.88d),
                Arguments.of(-13.2d, 24.5d, 34.4d),
                Arguments.of(0d, 18.3d, 131.4d)
        );
    }

    @ParameterizedTest
    @DisplayName("Parameterized test for negative trapezoid side b")
    @MethodSource("trapezoidNegativeArgumentsAsSideB")
    void shouldThrowIllegalArgumentExceptionForInvalidSideB(double a, double b, double h) {
        assertThrows(IllegalArgumentException.class, () -> {
            new Trapezoid(a, b, h);
        });
    }

    private static Stream<Arguments> trapezoidNegativeArgumentsAsSideB() {
        return Stream.of(
                Arguments.of(1.0d, -44.0d, 183.34d),
                Arguments.of(10d, -34.231d, 18.88d),
                Arguments.of(13.2d, -24.5d, 34.4d),
                Arguments.of(18.3d, 0d, 131.4d)
        );
    }

    @ParameterizedTest
    @DisplayName("Parameterized test for negative trapezoid height")
    @MethodSource("trapezoidNegativeArgumentsAsHeight")
    void shouldThrowIllegalArgumentExceptionForInvalidHeight(double a, double b, double h) {
        assertThrows(IllegalArgumentException.class, () -> {
            new Trapezoid(a, b, h);
        });
    }

    private static Stream<Arguments> trapezoidNegativeArgumentsAsHeight() {
        return Stream.of(
                Arguments.of(1.0d, 44.0d, -183.34d),
                Arguments.of(10d, 34.231d, -18.88d),
                Arguments.of(13.2d, 24.5d, -34.4d),
                Arguments.of(18.3d, 131.4d, 0d)
        );
    }
}
