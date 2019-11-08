package pl.coderstrust.figures;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.stream.Stream;

class TriangleTest {

    @ParameterizedTest
    @DisplayName("Parameterized test for triangle area")
    @MethodSource("triangleAreaArguments")
    void shouldReturnAreaOfRectangle(double expected, double a, double h) {
        assertEquals(expected, new Triangle(a, h).calculateArea(), 0.01);
    }

    private static Stream<Arguments> triangleAreaArguments() {
        return Stream.of(
                Arguments.of(0.5, 1.0d, 1.0d),
                Arguments.of(500.0, 25.0d, 40.0d),
                Arguments.of(160.62, 13.33d, 24.10d),
                Arguments.of(6704.16, 999.13d, 13.42d),
                Arguments.of(2221.23, 141.3d, 31.44d)
        );
    }

    @ParameterizedTest
    @DisplayName("Parameterized test for negative triangle side")
    @MethodSource("triangleNegativeSideArgument")
    void shouldThrowIllegalArgumentExceptionForInvalidSide(double a, double h) {
        assertThrows(IllegalArgumentException.class, () -> {
            new Triangle(a, h);
        });
    }

    private static Stream<Arguments> triangleNegativeSideArgument() {
        return Stream.of(
                Arguments.of(-1.0d, 44.0d),
                Arguments.of(-10d, 34.231d),
                Arguments.of(0d, 18.3d),
                Arguments.of(-100d, 341.2d),
                Arguments.of(0d, 0d)
        );
    }

    @ParameterizedTest
    @DisplayName("Parameterized test for negative triangle height")
    @MethodSource("triangleNegativeHeightArgument")
    void shouldThrowIllegalArgumentExceptionForInvalidHeight(double a, double h) {
        assertThrows(IllegalArgumentException.class, () -> {
            new Triangle(a, h);
        });
    }

    private static Stream<Arguments> triangleNegativeHeightArgument() {
        return Stream.of(
                Arguments.of(1.0d, -44.0d),
                Arguments.of(10d, -34.231d),
                Arguments.of(30d, -18.3d),
                Arguments.of(100d, -341.2d),
                Arguments.of(0d, 0d)
        );
    }
}
