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
    @MethodSource("circleArguments")
    void shouldReturnAreaOfCircle(double expected, double r) {
        assertEquals(expected, new Circle(r).calculateArea());
    }

    private static Stream<Arguments> circleArguments() {
        return Stream.of(
                Arguments.of(3.141592653589793d, 1.0d),
                Arguments.of(1963.4954084936207d, 25.0d),
                Arguments.of(564.1043768785833d, 13.4d),
                Arguments.of(3135312.609875267d, 999d)
        );
    }

    @ParameterizedTest
    @DisplayName("Parameterized test for negative circle radius")
    @ValueSource(doubles = {-1.33d, 0d, -1230d})
    void shouldThrowIllegalArgumentException(double r) {
        assertThrows(IllegalArgumentException.class, () -> {
            new Circle(r);
        });
    }
}
