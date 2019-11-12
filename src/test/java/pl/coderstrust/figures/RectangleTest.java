package pl.coderstrust.figures;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RectangleTest {

    @ParameterizedTest
    @DisplayName("Parameterized test for rectangle area")
    @MethodSource("rectangleAreaArguments")
    void shouldReturnAreaOfRectangle(double expected, double a, double b) {
        assertEquals(expected, new Rectangle(a, b).calculateArea(), 0.01);
    }

    private static Stream<Arguments> rectangleAreaArguments() {
        return Stream.of(
                Arguments.of(1.0, 1.0d, 1.0d),
                Arguments.of(1000.0, 25.0d, 40.0d),
                Arguments.of(321.25, 13.33d, 24.10d),
                Arguments.of(13408.32, 999.13d, 13.42d),
                Arguments.of(4442.47, 141.3d, 31.44d)
        );
    }

    @ParameterizedTest
    @DisplayName("Parameterized test for invalid rectangle side A")
    @ValueSource(doubles = {-1.0, -10, 0, -100, 0})
    void shouldThrowIllegalArgumentExceptionForInvalidSideA(double a) {
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(a, 2.0d));
    }

    @ParameterizedTest
    @DisplayName("Parameterized test for invalid rectangle side B")
    @ValueSource(doubles = {-44.0, -34.231, -18.3, -341.2, 0})
    void shouldThrowIllegalArgumentExceptionForInvalidSideB(double b) {
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(2.0d, b));
    }
}
