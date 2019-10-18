package pl.coderstrust.multiplication;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MultiplicationTableTest {

    @ParameterizedTest
    @DisplayName("Parameterized test for multiplication table")
    @MethodSource("multiplicationTableArguments")
    public void shouldReturnCorrectMultiplicationTable(int[][] expected, int size) {
        assertArrayEquals(expected, MultiplicationTable.makeArray(size));
    }

    private static Stream<Arguments> multiplicationTableArguments() {
        return Stream.of(
                Arguments.of(new int[][]{ {1} }, 1),
                Arguments.of(new int[][]{ {1, 2, 3}, {2, 4, 6}, {3, 6, 9}}, 3),
                Arguments.of(new int[][]{ {1, 2, 3, 4, 5}, {2, 4, 6, 8, 10}, {3, 6, 9, 12, 15}, {4, 8, 12, 16, 20}, {5, 10, 15, 20, 25} }, 5),
                Arguments.of(new int[][]{{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, {2, 4, 6, 8, 10, 12, 14, 16, 18, 20}, {3, 6, 9, 12, 15, 18, 21, 24, 27, 30}, {4, 8, 12, 16, 20, 24, 28, 32, 36, 40}, {5, 10, 15, 20, 25, 30, 35, 40, 45, 50}, {6, 12, 18, 24, 30, 36, 42, 48, 54, 60}, {7, 14, 21, 28, 35, 42, 49, 56, 63, 70}, {8, 16, 24, 32, 40, 48, 56, 64, 72, 80}, {9, 18, 27, 36, 45, 54, 63, 72, 81, 90}, {10, 20, 30, 40, 50, 60, 70, 80, 90, 100}}, 10),
                Arguments.of(new int[][]{{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13}, {2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26}, {3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36, 39}, {4, 8, 12, 16, 20, 24, 28, 32, 36, 40, 44, 48, 52}, {5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65}, {6, 12, 18, 24, 30, 36, 42, 48, 54, 60, 66, 72, 78}, {7, 14, 21, 28, 35, 42, 49, 56, 63, 70, 77, 84, 91}, {8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96, 104}, {9, 18, 27, 36, 45, 54, 63, 72, 81, 90, 99, 108, 117}, {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130}, {11, 22, 33, 44, 55, 66, 77, 88, 99, 110, 121, 132, 143}, {12, 24, 36, 48, 60, 72, 84, 96, 108, 120, 132, 144, 156}, {13, 26, 39, 52, 65, 78, 91, 104, 117, 130, 143, 156, 169}}, 13));
}

    @ParameterizedTest
    @DisplayName("Parameterized test for negative size of multiplication table")
    @ValueSource(ints = {-1, -5, -10, -20, -100})
    public void shouldThrowExceptionForInvalidNumber(int size) {
        assertThrows(IllegalArgumentException.class, () -> {
            MultiplicationTable.makeArray(size);
        });
    }
}
