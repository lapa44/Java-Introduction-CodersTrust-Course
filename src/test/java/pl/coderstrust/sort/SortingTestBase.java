package pl.coderstrust.sort;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import java.util.stream.Stream;

abstract class SortingTestBase {
    abstract SortingMethod getSortingMethod();

    @ParameterizedTest
    @DisplayName("Parameterized tests for sorting")
    @MethodSource("sortingArguments")
    void shouldSortArray(int[] input, int[] expected) {
        long startTime = System.currentTimeMillis();
        int[] result = getSortingMethod().sort(input);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
        assertArrayEquals(expected, result);
    }

    private static Stream<Arguments> sortingArguments() {
        return Stream.of(
                Arguments.of(new int[] {}, new int[] {}),
                Arguments.of(new int[] {1}, new int[] {1}),
                Arguments.of(new int[] {1, 1}, new int[] {1, 1}),
                Arguments.of(new int[] {1, 2, 3, 4, 5} , new int[] {1, 2, 3, 4, 5}),
                Arguments.of(new int[] {6, 5, 4, 3, 2, 1} , new int[] {1, 2, 3, 4, 5, 6}),
                Arguments.of(new int[] {130, 200, 423, 199}, new int[] {130, 199, 200, 423}),
                Arguments.of(new int[] {400, 0, -420, 234, -210}, new int[] {-420, -210, 0, 234, 400})
        );
    }
}
