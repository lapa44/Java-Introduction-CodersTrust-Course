package pl.coderstrust.hanoi;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class HanoiTower {

    private List<String> resultLines;
    private List<Stack<Integer>> hanoiTowersList;

    HanoiTower(List<Stack<Integer>> hanoiTowersList) {
        this.hanoiTowersList = hanoiTowersList;
        resultLines = new LinkedList<>();
        resultLines.add(String.format("%-40s %-40s %-40s", "A: " + hanoiTowersList.get(0).toString(), "B: " + hanoiTowersList.get(1).toString(), "C: " + hanoiTowersList.get(2).toString()));
    }

    public List<String> solveHanoi(int n, Stack<Integer> A, Stack<Integer> B, Stack<Integer> C) {
        if (n > 0) {
            solveHanoi(n - 1, A, C, B);
            C.push(A.pop());
            resultLines.add(String.format("%-40s %-40s %-40s", "A: " + hanoiTowersList.get(0).toString(), "B: " + hanoiTowersList.get(1).toString(), "C: " + hanoiTowersList.get(2).toString()));
            solveHanoi(n - 1, B, A, C);
        }
        return resultLines;
    }
}
