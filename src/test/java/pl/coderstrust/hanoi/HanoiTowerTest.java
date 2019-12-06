package pl.coderstrust.hanoi;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;

class HanoiTowerTest {

    @ParameterizedTest
    @DisplayName("Solving hanoi towers")
    @MethodSource("hanoiArguments")
    void shouldSolveHanoiAndReturnCorrectOutput(int disksNumber, List<String> expected) {
        List<Stack<Integer>> hanoiTowersList = new ArrayList<>();
        Stack<Integer> A = new Stack<>();
        for (int i = disksNumber; i > 0; i--) {
            A.push(i);
        }
        hanoiTowersList.add(A);
        hanoiTowersList.add(new Stack<>());
        hanoiTowersList.add(new Stack<>());
        assertLinesMatch(new HanoiTower(hanoiTowersList).solveHanoi(disksNumber, hanoiTowersList.get(0), hanoiTowersList.get(1), hanoiTowersList.get(2)), expected);
    }

    private static Stream<Arguments> hanoiArguments() {
        return Stream.of(
                Arguments.of(3, Stream.of("A: [3, 2, 1]                             B: []                                    C: []                                   ",
                        "A: [3, 2]                                B: []                                    C: [1]                                  ",
                        "A: [3]                                   B: [2]                                   C: [1]                                  ",
                        "A: [3]                                   B: [2, 1]                                C: []                                   ",
                        "A: []                                    B: [2, 1]                                C: [3]                                  ",
                        "A: [1]                                   B: [2]                                   C: [3]                                  ",
                        "A: [1]                                   B: []                                    C: [3, 2]                               ",
                        "A: []                                    B: []                                    C: [3, 2, 1]                            ").collect(Collectors.toList())),
                Arguments.of(4, Stream.of("A: [4, 3, 2, 1]                          B: []                                    C: []                                   ",
                        "A: [4, 3, 2]                             B: [1]                                   C: []                                   ",
                        "A: [4, 3]                                B: [1]                                   C: [2]                                  ",
                        "A: [4, 3]                                B: []                                    C: [2, 1]                               ",
                        "A: [4]                                   B: [3]                                   C: [2, 1]                               ",
                        "A: [4, 1]                                B: [3]                                   C: [2]                                  ",
                        "A: [4, 1]                                B: [3, 2]                                C: []                                   ",
                        "A: [4]                                   B: [3, 2, 1]                             C: []                                   ",
                        "A: []                                    B: [3, 2, 1]                             C: [4]                                  ",
                        "A: []                                    B: [3, 2]                                C: [4, 1]                               ",
                        "A: [2]                                   B: [3]                                   C: [4, 1]                               ",
                        "A: [2, 1]                                B: [3]                                   C: [4]                                  ",
                        "A: [2, 1]                                B: []                                    C: [4, 3]                               ",
                        "A: [2]                                   B: [1]                                   C: [4, 3]                               ",
                        "A: []                                    B: [1]                                   C: [4, 3, 2]                            ",
                        "A: []                                    B: []                                    C: [4, 3, 2, 1]                         ").collect(Collectors.toList()))
        );
    }
}
