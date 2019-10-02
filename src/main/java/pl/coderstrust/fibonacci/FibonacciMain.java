package pl.coderstrust.fibonacci;

import java.util.Scanner;

public class FibonacciMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter fibonacci's number in order you want to see: ");
        int inputNumber = sc.nextInt();
        try {
            System.out.println("Recursive method number: " + FibonacciRecursive.fibonacci(inputNumber));
            System.out.println("Iterative method number: " + FibonacciIterative.fibonacci(inputNumber));
        } catch (IllegalArgumentException e) {
            System.out.println("Fibonacci's numbers in order can't be negative.");
        }
    }
}
