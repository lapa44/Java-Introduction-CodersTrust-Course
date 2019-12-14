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
        validateArguments();
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

    public void solveHanoi() throws IOException {
        solveHanoi(hanoiTowersList.get(0).size(), hanoiTowersList.get(0), hanoiTowersList.get(1), hanoiTowersList.get(2));
    }

    private void validateArguments() {
        if (hanoiTowersList == null) {
            throw new IllegalArgumentException("hanoiTowersList cannot be null.");
        }
        if (hanoiTowersList.size() != 3) {
            throw new IllegalArgumentException("hanoiTowersList should have 3 stacks.");
        }
        if (hanoiTowersList.get(0).isEmpty()) {
            throw new IllegalArgumentException("First hanoi stack shouldn't be empty.");
        }
        if (!hanoiTowersList.get(1).isEmpty()) {
            throw new IllegalArgumentException("Second hanoi stack should be empty.");
        }
        if (!hanoiTowersList.get(2).isEmpty()) {
            throw new IllegalArgumentException("Third hanoi stack should be empty.");
        }
        if (logger == null) {
            throw new IllegalArgumentException("logger cannot be null.");
        }
    }
}
