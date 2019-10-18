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
        int[][] multiplicationTable = getMultiplicationTable(input);
        printMultiplicationTable(multiplicationTable);
    }

    public static int[][] getMultiplicationTable(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Size cannot be negative.");
        }
        int[][] array = new int[size][size];
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                array[i - 1][j - 1] = i * j;
            }
        }
        return array;
    }

    private static void printMultiplicationTable(int[][] table) {
        System.out.printf("%5s", "");
        for (int i = 1; i <= table.length; i++) {
            System.out.printf("%5d", i);
        }
        System.out.println();
        for (int i = 1; i <= table.length; i++) {
            System.out.printf("%5d", i);
            for (int j = 1; j <= table.length; j++) {
                System.out.printf("%5d", table[i - 1][j - 1]);
            }
            System.out.println();
        }
    }
}
