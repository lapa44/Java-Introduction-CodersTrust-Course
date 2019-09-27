package pl.coderstrust.pascal;

import java.util.Scanner;

public class PascalTriangle {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter rows number: ");
        int input = sc.nextInt();
        printPascalTriangle(input);
    }

    public static void printPascalTriangle(int rowsNumber) {
        for (int i = 0; i < rowsNumber; i++) {
            for (int j = i; j <= rowsNumber; j++) {
                System.out.printf("%3s", "");
            }
            for (int j = 0; j <= i; j++) {
                System.out.printf("%6d", factorial(i) / (factorial(j) * factorial(i - j)));
            }
            System.out.println();
        }
    }

    private static int factorial(int number) {
        int result = 1;
        for (int i = 2; i <= number; i++) {
            result *= i;
        }
        return result;
    }
}
