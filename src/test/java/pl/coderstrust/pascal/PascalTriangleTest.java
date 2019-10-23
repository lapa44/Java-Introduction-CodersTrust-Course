package pl.coderstrust.pascal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PascalTriangleTest {

    @ParameterizedTest
    @DisplayName("Parameterized test for negative height of Pascal Triangle")
    @ValueSource(ints = {-1, -5, -10, -25, -100})
    public void shouldThrowExceptionForInvalidHeight(int height) {
        assertThrows(IllegalArgumentException.class, () -> {
            PascalTriangle.getPascalTriangle(height);
        });
    }

    @ParameterizedTest
    @DisplayName("Parameterized test for Pascal Triangle")
    @MethodSource("pascalTriangleArguments")
    public void shouldReturnCorrectPascalTriangle(int height, List<String> expected) {
        assertEquals(expected, PascalTriangle.getPascalTriangle(height));
    }

    private static Stream<Arguments> pascalTriangleArguments() {
        return Stream.of(
                Arguments.of(1, Arrays.asList("           1")),
                Arguments.of(3, Arrays.asList(
                        "                 1",
                        "              1     1",
                        "           1     2     1")),
                Arguments.of(5, Arrays.asList(
                        "                       1",
                        "                    1     1",
                        "                 1     2     1",
                        "              1     3     3     1",
                        "           1     4     6     4     1")),
                Arguments.of(10, Arrays.asList(
                        "                                      1",
                        "                                   1     1",
                        "                                1     2     1",
                        "                             1     3     3     1",
                        "                          1     4     6     4     1",
                        "                       1     5    10    10     5     1",
                        "                    1     6    15    20    15     6     1",
                        "                 1     7    21    35    35    21     7     1",
                        "              1     8    28    56    70    56    28     8     1",
                        "           1     9    36    84   126   126    84    36     9     1"))
        );
    }
}
