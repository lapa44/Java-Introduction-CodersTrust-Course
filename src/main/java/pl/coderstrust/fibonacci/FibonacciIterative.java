package pl.coderstrust.fibonacci;

import java.util.Scanner;

public class FibonacciIterative {

    public static void main(String[] args) {
        System.out.print("Enter fibonacci's number in order you want to see: ");
        Scanner sc = new Scanner(System.in);
        System.out.println("Your number is: " + fibonacci(sc.nextInt()));
    }

    public static long fibonacci(int fibonacciNumberInOrder) {
        int temp1 = 0, temp2 = 1, nextNumber;
        if (fibonacciNumberInOrder == 0) {
            return 0;
        }
        else if (fibonacciNumberInOrder == 1) {
            return 1;
        }
        else {
            for (int i = 2; i <= fibonacciNumberInOrder; i++) {
                nextNumber = temp1 + temp2;
                temp1 = temp2;
                temp2 = nextNumber;
            }
        }
        return temp2;
    }
}
