package pl.coderstrust.fibonacci;

import java.util.Scanner;

class FibonacciIterative {

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
        int[] fib = {0, 1, 1};
        for (int i = 2; i <= fibonacciNumberInOrder; i++) {
            fib[2] = fib[0] + fib[1];
            fib[0] = fib[1];
            fib[1] = fib[2];
        }
        return fib[2];
    }
}
