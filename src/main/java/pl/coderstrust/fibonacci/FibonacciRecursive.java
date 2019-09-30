package pl.coderstrust.fibonacci;

import java.util.Scanner;

public class FibonacciRecursive {

    public static void main(String[] args) {
        System.out.print("Enter fibonacci's number in order you want to see: ");
        Scanner sc = new Scanner(System.in);
        System.out.println("Your number is: " + fibonacci(sc.nextInt()));
    }

    public static long fibonacci(int fibonacciNumberInOrder) {
        if (fibonacciNumberInOrder == 0) {
            return 0;
        }
        else if (fibonacciNumberInOrder == 1) {
            return 1;
        }
        else {
            return fibonacci(fibonacciNumberInOrder - 1) + fibonacci((fibonacciNumberInOrder - 2));
        }
    }
}
