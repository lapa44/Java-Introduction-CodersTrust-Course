package pl.coderstrust.fibonacci;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciCheckerTest {

    @ParameterizedTest
    @DisplayName("Parameterized test for non fibonacci numbers")
    @ValueSource(longs = {4, 10, 15, 20, 100, 100})
    void shouldReturnFalseForNonFibonacciNumber(long number) {
        assertFalse(FibonacciChecker.isFibonacciNumber(number));
    }

    @ParameterizedTest
    @DisplayName("Parameterized test for fibonacci numbers")
    @ValueSource(longs = {0, 1, 2, 5, 13})
    void shouldReturnTrueForFibonacciNumber(long number) {
        assertTrue(FibonacciChecker.isFibonacciNumber(number));
    }

    @ParameterizedTest
    @DisplayName("Parameterized test for negative numbers")
    @ValueSource(longs = {-1, -4, -5, -13, -15})
    void shouldThrowExceptionForInvalidNumber(long number) {
        assertThrows(IllegalArgumentException.class, () -> {
            FibonacciChecker.isFibonacciNumber(number);
        });
    }
}
