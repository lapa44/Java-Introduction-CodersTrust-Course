package pl.coderstrust.hanoi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

class HanoiTowers {

    private static final String OUTPUT_FILE_PATH = "src/main/resources/HanoiOutput.txt";
    private static List<Stack<Integer>> hanoiTowersList;

    public HanoiTowers(int disksNumber) throws IOException {
        Files.write(Paths.get(OUTPUT_FILE_PATH), "".getBytes());
        hanoiTowersList = new ArrayList<>();
        initializeStacks(hanoiTowersList, disksNumber);
        solveHanoi(disksNumber, hanoiTowersList.get(0), hanoiTowersList.get(1), hanoiTowersList.get(2));
        printTowers();
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of disks: ");
        int disksNumber = sc.nextInt();
        new HanoiTowers(disksNumber);
    }

    private static void initializeStacks(List<Stack<Integer>> toInitialize, int disksNumber) {
        Stack<Integer> temp = new Stack<>();
        for (int i = disksNumber; i > 0; i--) {
            temp.push(i);
        }
        toInitialize.add(temp);
        toInitialize.add(new Stack<>());
        toInitialize.add(new Stack<>());
    }

    private static void solveHanoi(int n, Stack<Integer> A, Stack<Integer> B, Stack<Integer> C) throws IOException {
        if (n > 0) {
            solveHanoi(n - 1, A, C, B);
            printTowers();
            C.push(A.pop());
            solveHanoi(n - 1, B, A, C);
        }
    }

    private static void printTowers() throws IOException {
        Files.write(Paths.get(OUTPUT_FILE_PATH), String.format("%-40s %-40s %-40s\n", "A: " + hanoiTowersList.get(0).toString(), "B: " + hanoiTowersList.get(1).toString(), "C: " + hanoiTowersList.get(2).toString()).getBytes(), StandardOpenOption.APPEND);
    }
}
