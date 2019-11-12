package pl.coderstrust.figures;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.stream.Stream;

class CircleTest {

    @ParameterizedTest
    @DisplayName("Parameterized test for circle area")
    @MethodSource("circleAreaArguments")
    void shouldReturnAreaOfCircle(double expected, double r) {
        assertEquals(expected, new Circle(r).calculateArea(), 0.01);
    }

    private static Stream<Arguments> circleAreaArguments() {
        return Stream.of(
                Arguments.of(3.14, 1.0d),
                Arguments.of(1963.49, 25.0d),
                Arguments.of(564.1, 13.4d),
                Arguments.of(3135312.6, 999d)
        );
    }

    @ParameterizedTest
    @DisplayName("Parameterized test for invalid circle radius")
    @ValueSource(doubles = {-1.33d, 0d, -1230d})
    void shouldThrowIllegalArgumentExceptionForInvalidRadius(double radius) {
        assertThrows(IllegalArgumentException.class, () -> new Circle(radius));
    }
}
