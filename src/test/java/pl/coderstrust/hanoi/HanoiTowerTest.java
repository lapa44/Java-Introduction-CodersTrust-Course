package pl.coderstrust.hanoi;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HanoiTowerTest {

    @ParameterizedTest
    @DisplayName("Solving hanoi towers")
    @MethodSource("hanoiArguments")
    void shouldSolveHanoiAndReturnCorrectOutput(int disksNumber, List<String> expected) throws IOException {
        List<Stack<Integer>> hanoiTowersList = new ArrayList<>();
        Stack<Integer> A = new Stack<>();
        for (int i = disksNumber; i > 0; i--) {
            A.push(i);
        }
        hanoiTowersList.add(A);
        hanoiTowersList.add(new Stack<>());
        hanoiTowersList.add(new Stack<>());
        new HanoiTower(hanoiTowersList, new HanoiLogger(new HanoiFileSupport("src/main/resources/HanoiOutput.txt"))).solveHanoi();
        assertTrue(hanoiTowersList.get(0).isEmpty());
        assertTrue(hanoiTowersList.get(1).isEmpty());
        assertThat(hanoiTowersList.get(2), contains(expected.toArray()));
    }

    private static Stream<Arguments> hanoiArguments() {
        return Stream.of(
                Arguments.of(3, Arrays.asList(3, 2, 1)),
                Arguments.of(4, Arrays.asList(4, 3, 2, 1)),
                Arguments.of(10, Arrays.asList(10, 9, 8, 7, 6, 5, 4, 3, 2, 1))
        );
    }
}
