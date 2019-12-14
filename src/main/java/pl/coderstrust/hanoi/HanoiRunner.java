package pl.coderstrust.hanoi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

class HanoiRunner {

    private static final String OUTPUT_FILE_PATH = "src/main/resources/HanoiOutput.txt";

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of disks: ");
        int disksNumber = sc.nextInt();
        List<Stack<Integer>> hanoiTowersList = initializeStacks(disksNumber);
        HanoiFileSupport fileSupport = new HanoiFileSupport(OUTPUT_FILE_PATH);
        HanoiLogger logger = new HanoiLogger(fileSupport);
        HanoiTower hanoi = new HanoiTower(hanoiTowersList, logger);
        hanoi.solveHanoi();
    }

    public static List<Stack<Integer>> initializeStacks(int disksNumber) {
        List<Stack<Integer>> toInitialize = new ArrayList<>();
        Stack<Integer> temp = new Stack<>();
        for (int i = disksNumber; i > 0; i--) {
            temp.push(i);
        }
        toInitialize.add(temp);
        toInitialize.add(new Stack<>());
        toInitialize.add(new Stack<>());
        return toInitialize;
    }
}
