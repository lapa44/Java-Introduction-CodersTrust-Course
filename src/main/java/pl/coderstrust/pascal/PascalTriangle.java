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
        for(int i = 0 ; i < rowsNumber ; i++) {
            for(int u = i ; u <= rowsNumber ; u++) {
                System.out.printf("%3c", ' ');
            }
            for(int y = 0 ; y <= i ; y++) {
                System.out.printf("%6d", factorial(i) / (factorial(y) * factorial(i - y)));
            }
            System.out.println();
        }
    }

    public static int factorial(int number) {
        int result = 1;
        for(int i = 2  ; i <= number ; i++) {
            result *= i;
        }
        return result;
    }
}
