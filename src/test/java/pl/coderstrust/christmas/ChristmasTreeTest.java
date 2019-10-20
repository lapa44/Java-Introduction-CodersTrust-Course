package pl.coderstrust.christmas;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ChristmasTreeTest {

    @ParameterizedTest
    @DisplayName("Parameterized tests for negative height of Christmas Tree")
    @ValueSource(ints = {-1, -10, -15, -20, -100})
    public void shouldThrowExceptionForInvalidHeight(int height) {
        assertThrows(IllegalArgumentException.class, () -> {
            ChristmasTree.getChristmasTree(height);
        });
    }

    @ParameterizedTest
    @DisplayName("Parameterized tests for Christmas Tree")
    @MethodSource("christmasTreeArguments")
    public void shouldReturnCorrectChristmasTree(List<String> expected, int height) {
        assertEquals(expected, ChristmasTree.getChristmasTree(height));
    }

    private static Stream<Arguments> christmasTreeArguments() {
        return Stream.of(
                Arguments.of(Arrays.asList("**"), 0),
                Arguments.of(Arrays.asList(" *", "**"), 1),
                Arguments.of(Arrays.asList("   *", "  ***", " *****", "  **"), 3),
                Arguments.of(Arrays.asList("     *", "    ***", "   *****", "  *******", " *********", "    **"), 5),
                Arguments.of(Arrays.asList("          *", "         ***", "        *****", "       *******", "      *********", "     ***********", "    *************", "   ***************", "  *****************", " *******************", "         **"), 10)
        );
    }
}