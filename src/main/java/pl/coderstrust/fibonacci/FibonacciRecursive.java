package pl.coderstrust.fibonacci;

import java.util.Scanner;

class FibonacciRecursive {

    public static void main(String[] args) {
        int inputNumber;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Enter fibonacci's number in order you want to see: ");
            inputNumber = sc.nextInt();
        } while(inputNumber < 0);
        System.out.println("Your number is: " + fibonacci(inputNumber));
    }

    public static long fibonacci(int fibonacciNumberInOrder) {
        if (fibonacciNumberInOrder == 0) {
            return 0;
        }
        if (fibonacciNumberInOrder == 1) {
            return 1;
        }
        return fibonacci(fibonacciNumberInOrder - 1) + fibonacci((fibonacciNumberInOrder - 2));
    }
}
