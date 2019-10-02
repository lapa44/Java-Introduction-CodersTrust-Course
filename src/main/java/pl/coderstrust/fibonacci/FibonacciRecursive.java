package pl.coderstrust.fibonacci;

class FibonacciRecursive {

    public static long fibonacci(int fibonacciNumberInOrder) {
        if (fibonacciNumberInOrder < 0) {
            throw new IllegalArgumentException("Number in order can't be negative.");
        }
        if (fibonacciNumberInOrder == 0) {
            return 0;
        }
        if (fibonacciNumberInOrder == 1) {
            return 1;
        }
        return fibonacci(fibonacciNumberInOrder - 1) + fibonacci((fibonacciNumberInOrder - 2));
    }
}
