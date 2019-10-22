package pl.coderstrust.fibonacci;

public class FibonacciChecker {

    public static boolean isFibonacciNumber(long number) {
        if (number < 0) {
            throw new IllegalArgumentException("Fibonacci numbers cannot be negative.");
        }
        return isPerfectSquare(5 * number * number + 4) || isPerfectSquare(5 * number * number - 4);
    }

    public static boolean isPerfectSquare(long number) {
        long temp = (long) Math.sqrt(number);
        return (temp * temp == number);
    }
}
