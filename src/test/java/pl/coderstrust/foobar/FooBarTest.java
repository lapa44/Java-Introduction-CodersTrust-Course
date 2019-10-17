package pl.coderstrust.foobar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class FooBarTest {

    @Test
    @DisplayName("Unit test for negative value")
    public void shouldNotAcceptNegativeNumber() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> FooBar.getFooBar(-1));
        assertEquals("FooBar numbers can't be negative.", exception.getMessage());
    }

    @ParameterizedTest
    @DisplayName("Parameterized Tests of FooBar")
    @MethodSource("fooBarArguments")
    public void shouldReturnCorrectFooBar(List<String> expected, int number) {
        assertEquals(expected, FooBar.getFooBar(number));
    }

    private static Stream<Arguments> fooBarArguments() {
        return Stream.of(
                Arguments.of(Arrays.asList("0 FooBar"), 0),
                Arguments.of(Arrays.asList("0 FooBar", "1 ", "2 ", "3 Foo", "4 ", "5 Bar"), 5),
                Arguments.of(Arrays.asList("0 FooBar", "1 ", "2 ", "3 Foo", "4 ", "5 Bar", "6 Foo", "7 ", "8 ", "9 Foo", "10 Bar"), 10),
                Arguments.of(Arrays.asList("0 FooBar", "1 ", "2 ", "3 Foo", "4 ", "5 Bar", "6 Foo", "7 ", "8 ", "9 Foo", "10 Bar", "11 ", "12 Foo", "13 ", "14 ", "15 FooBar"),15),
                Arguments.of(Arrays.asList("0 FooBar", "1 ", "2 ", "3 Foo", "4 ", "5 Bar", "6 Foo", "7 ", "8 ", "9 Foo", "10 Bar", "11 ", "12 Foo", "13 ", "14 ", "15 FooBar", "16 ", "17 ", "18 Foo", "19 ", "20 Bar"),20));
    }
}
