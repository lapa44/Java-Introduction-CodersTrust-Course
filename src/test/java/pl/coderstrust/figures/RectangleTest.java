package pl.coderstrust.figures;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RectangleTest {

    @ParameterizedTest
    @DisplayName("Parameterized test for rectangle area")
    @MethodSource("rectangleArguments")
    void shouldReturnAreaOfRectangle(double expected, double a, double b) {
        assertEquals(expected, new Rectangle(a, b).calculateArea());
    }

    private static Stream<Arguments> rectangleArguments() {
        return Stream.of(
                Arguments.of(1.0d, 1.0d, 1.0d),
                Arguments.of(1000.0d, 25.0d, 40.0d),
                Arguments.of(321.25300000000004d, 13.33d, 24.10d),
                Arguments.of(13408.3246d, 999.13d, 13.42d),
                Arguments.of(4442.472000000001d, 141.3d, 31.44d)
        );
    }

    @ParameterizedTest
    @DisplayName("Parameterized test for negative rectangle sides")
    @MethodSource("rectangleNegativeArguments")
    void shouldThrowIllegalArgumentException(double a, double b) {
        assertThrows(IllegalArgumentException.class, () -> {
            new Rectangle(a, b);
        });
    }

    private static Stream<Arguments> rectangleNegativeArguments() {
        return Stream.of(
                Arguments.of(-1.0d, 44.0d),
                Arguments.of(10d, -34.231d),
                Arguments.of(0d, 18.3d),
                Arguments.of(-100d, -341.2d),
                Arguments.of(0d, 0d)
        );
    }

    @ParameterizedTest
    @DisplayName("Parameterized test for Rectangle children objects")
    @MethodSource("rectangleObjects")
    void shouldCreateRectangleChildrenObjects(double expected, Rectangle rectangle) {
        assertEquals(expected, rectangle.calculateArea());
    }

    private static Stream<Arguments> rectangleObjects() {
        return Stream.of(
                Arguments.of(1d, new Rectangle(1d, 1d)),
                Arguments.of(1d, new Square(1d))
        );
    }
}
