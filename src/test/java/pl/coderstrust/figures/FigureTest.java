package pl.coderstrust.figures;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class FigureTest {

    @ParameterizedTest
    @DisplayName("Parameterized test for Figure interface")
    @MethodSource("figureArguments")
    void shouldCreateFigureChildrenObjects(Figure figure) {
        assertNotNull(figure);
    }

    private static Stream<Arguments> figureArguments() {
        return Stream.of(
                Arguments.of(new Rectangle(1d, 1d)),
                Arguments.of(new Square(1d)),
                Arguments.of(new Circle(1d)),
                Arguments.of(new Triangle(1d, 1d)),
                Arguments.of(new Trapezoid(1d, 1d, 1d))
        );
    }
}
