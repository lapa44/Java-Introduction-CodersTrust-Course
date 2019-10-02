package pl.coderstrust.fibonacci;

class FibonacciIterative {

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
        int[] fib = {0, 1, 1};
        for (int i = 2; i <= fibonacciNumberInOrder; i++) {
            fib[2] = fib[0] + fib[1];
            fib[0] = fib[1];
            fib[1] = fib[2];
        }
        return fib[2];
    }
}
