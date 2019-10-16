package pl.coderstrust.foobar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class FooBarTest {

    @ParameterizedTest
    @DisplayName("Parameterized Tests of FooBar")
    @MethodSource("createParameters")
    public void parameterizedFooBarTests(List<String> ls, int number) {
        assertEquals(ls, FooBar.createFooBarList(number));
    }

    private static Stream<Arguments> createParameters() {
        return Stream.of(
                Arguments.of(Arrays.asList("0 FooBar"), 0),
                Arguments.of(Arrays.asList("0 FooBar", "1 ", "2 ", "3 Foo", "4 ", "5 Bar"), 5),
                Arguments.of(Arrays.asList("0 FooBar", "1 ", "2 ", "3 Foo", "4 ", "5 Bar", "6 Foo", "7 ", "8 ", "9 Foo", "10 Bar"), 10),
                Arguments.of(Arrays.asList("0 FooBar", "1 ", "2 ", "3 Foo", "4 ", "5 Bar", "6 Foo", "7 ", "8 ", "9 Foo", "10 Bar", "11 ", "12 Foo", "13 ", "14 ", "15 FooBar"),15),
                Arguments.of(Arrays.asList("0 FooBar", "1 ", "2 ", "3 Foo", "4 ", "5 Bar", "6 Foo", "7 ", "8 ", "9 Foo", "10 Bar", "11 ", "12 Foo", "13 ", "14 ", "15 FooBar", "16 ", "17 ", "18 Foo", "19 ", "20 Bar"),20));
    }
}