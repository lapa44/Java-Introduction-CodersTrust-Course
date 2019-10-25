package pl.coderstrust.sort;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

public abstract class SortingTestBase {
    public abstract SortingMethod getSortingMethod();

    @ParameterizedTest
    @DisplayName("Parameterized tests for sorting")
    @MethodSource("sortingArguments")
    public void shouldSortArray(int[] expected, int[] given) {
        long startTime = System.currentTimeMillis();
        int[] result = getSortingMethod().sort(given);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
        assertArrayEquals(expected, result);
    }

    private static Stream<Arguments> sortingArguments() {
        return Stream.of(
                Arguments.of(new int[] {1, 2, 3, 4, 5, 6} , new int[] {6, 5, 4, 3, 2, 1}),
                Arguments.of(new int[] {130, 199, 200, 423}, new int[] {130, 200, 423, 199}),
                Arguments.of(new int[] {-420, -210, 0, 234, 400}, new int[] {400, 0, -420, 234, -210})
        );
    }
}
