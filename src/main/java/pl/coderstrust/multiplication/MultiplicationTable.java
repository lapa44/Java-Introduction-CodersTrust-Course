package pl.coderstrust.multiplication;
import java.util.Scanner;

public class MultiplicationTable {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input;
        do {
            System.out.print("Please enter table's size (max 12): ");
            input = sc.nextInt();
        } while (input > 12);
        sc.close();
        int[][] multiplicationTable = makeArray(input);
        printMultiplicationTable(multiplicationTable);
    }

    public static int[][] makeArray(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Size cannot be negative.");
        }
        int[][] arr = new int[size][size];
        for (int i = 1; i <= size; i++) {
            for (int y = 1; y <= size; y++) {
                arr[i - 1][y - 1] = i * y;
            }
        }
        return arr;
    }

    private static void printMultiplicationTable(int[][] table) {
        System.out.printf("%5s", "");
        for (int i = 1; i <= table.length; i++) {
            System.out.printf("%5d", i);
        }
        System.out.println();
        for (int i = 1; i <= table.length; i++) {
            System.out.printf("%5d", i);
            for (int y = 1; y <= table.length; y++) {
                System.out.printf("%5d", table[i - 1][y - 1]);
            }
            System.out.println();
        }
    }
}
