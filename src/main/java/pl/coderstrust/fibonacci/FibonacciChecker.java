package pl.coderstrust.fibonacci;

import java.util.HashMap;
import java.util.Map;

public class FibonacciChecker {

    private static Map<Long, Boolean> cache = new HashMap<Long, Boolean>();

    public static boolean isFibonacciNumber(long number) {
        if (number < 0) {
            throw new IllegalArgumentException("Fibonacci numbers cannot be negative.");
        }
        if (cache.containsKey(number)) {
            return cache.get(number);
        }
        long formula1 = 5 * (number * number) + 4;
        long formula2 = 5 * (number * number) - 4;
        boolean result = isPerfectSquare(formula1) || isPerfectSquare(formula2);
        cache.put(number, result);
        return result;
    }

    private static boolean isPerfectSquare(long number) {
        long temp = (long) Math.sqrt(number);
        return (temp * temp == number);
    }
}
