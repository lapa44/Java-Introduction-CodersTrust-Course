package pl.coderstrust.figures;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FigureTest {

    @ParameterizedTest
    @DisplayName("Parameterized test for Figure interface")
    @MethodSource("figureArguments")
    void shouldCreateFigureChildrenObjects(double expected, Figure figure) {
        assertEquals(expected, figure.calculateArea());
    }

    private static Stream<Arguments> figureArguments() {
        return Stream.of(
                Arguments.of(1d, new Rectangle(1d, 1d)),
                Arguments.of(1d, new Square(1d)),
                Arguments.of(3.141592653589793d, new Circle(1d)),
                Arguments.of(0.5d, new Triangle(1d, 1d)),
                Arguments.of(1d, new Trapezoid(1d, 1d, 1d))
        );
    }
}
