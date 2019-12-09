package pl.coderstrust.hanoi;

import java.io.IOException;
import java.util.List;
import java.util.Stack;

class HanoiTower {

    private List<Stack<Integer>> hanoiTowersList;
    private final HanoiLogger logger;

    HanoiTower(List<Stack<Integer>> hanoiTowersList, HanoiLogger logger) throws IOException {
        this.hanoiTowersList = hanoiTowersList;
        this.logger = logger;
        logger.log(String.format("%-40s %-40s %-40s", "A: " + hanoiTowersList.get(0).toString(), "B: " + hanoiTowersList.get(1).toString(), "C: " + hanoiTowersList.get(2).toString()));
    }

    private void solveHanoi(int n, Stack<Integer> A, Stack<Integer> B, Stack<Integer> C) throws IOException {
        if (n > 0) {
            solveHanoi(n - 1, A, C, B);
            C.push(A.pop());
            logger.log(String.format("%-40s %-40s %-40s", "A: " + hanoiTowersList.get(0).toString(), "B: " + hanoiTowersList.get(1).toString(), "C: " + hanoiTowersList.get(2).toString()));
            solveHanoi(n - 1, B, A, C);
        }
    }

    public void solveHanoi(Stack<Integer> A, Stack<Integer> B, Stack<Integer> C) throws IOException {
        solveHanoi(A.size(), A, B, C);
    }
}
