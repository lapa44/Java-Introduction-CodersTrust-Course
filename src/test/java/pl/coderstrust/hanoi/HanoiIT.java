package pl.coderstrust.hanoi;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;

class HanoiIT {

    @ParameterizedTest
    @MethodSource("hanoiArguments")
    @DisplayName("Solving Hanoi Towers and checking if output was saved correctly.")
    void shouldSolveHanoiTowersAndSaveCorrectOutputInFile(int disksNumber, List<String> expected) throws IOException {
        String OUTPUT_FILE_PATH = "src/main/resources/HanoiOutput.txt";
        List<Stack<Integer>> hanoiTowersList = HanoiRunner.initializeStacks(disksNumber);
        new HanoiTower(hanoiTowersList, new HanoiLogger(new HanoiFileSupport(OUTPUT_FILE_PATH))).solveHanoi();
        assertLinesMatch(expected, Files.readAllLines(Paths.get("src/main/resources/HanoiOutput.txt")));
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
