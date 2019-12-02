package pl.coderstrust.hanoi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class HanoiTowers {

    private static final String OUTPUT_FILE_PATH = "src/main/resources/HanoiOutput.txt";

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of disks: ");
        Files.write(Paths.get(OUTPUT_FILE_PATH), "".getBytes());
        int disksNumber = sc.nextInt();
        List<Stack<Integer>> hanoiTowers = new ArrayList<>();
        initializeStacks(hanoiTowers, disksNumber);
        solveHanoi(disksNumber, hanoiTowers.get(0), hanoiTowers.get(1), hanoiTowers.get(2));
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
            C.push(A.pop());
            printTowers(A, B, C);
            solveHanoi(n - 1, B, A, C);
        }
    }

    private static void printTowers(Stack<Integer> A, Stack<Integer> B, Stack<Integer> C) throws IOException {
        Files.write(Paths.get(OUTPUT_FILE_PATH), String.format("%-40s %-40s %-40s\n", "A: " + A.toString(), "B: " + B.toString(), "C: " + C.toString()).getBytes(), StandardOpenOption.APPEND);
    }
}
