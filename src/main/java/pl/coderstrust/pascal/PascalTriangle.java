package pl.coderstrust.pascal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PascalTriangle {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter rows number: ");
        int input = sc.nextInt();
        System.out.println();
        getPascalTriangle(input).forEach(System.out::println);
    }

    public static List<String> getPascalTriangle(int rowsNumber) {
        if (rowsNumber < 0) {
            throw new IllegalArgumentException("Rows number cannot be lower than zero.");
        }
        List<String> result = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < rowsNumber; i++) {
            temp.delete(0, temp.length());
            for (int j = i; j <= rowsNumber; j++) {
                temp.append(String.format("%3s", ""));
            }
            for (int j = 0; j <= i; j++) {
                temp.append(String.format("%6d", factorial(i) / (factorial(j) * factorial(i - j))));
            }
            result.add(temp.toString());
        }
        return result;
    }

    private static int factorial(int number) {
        int result = 1;
        for (int i = 2; i <= number; i++) {
            result *= i;
        }
        return result;
    }
}
