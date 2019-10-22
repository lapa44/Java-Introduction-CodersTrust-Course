package pl.coderstrust.fibonacci;

import java.util.HashMap;
import java.util.Map;

public class FibonacciChecker {

    private static Map<Long, Boolean> numbersContainer = new HashMap<Long, Boolean>();

    public static boolean isFibonacciNumber(long number) {
        if (number < 0) {
            throw new IllegalArgumentException("Fibonacci numbers cannot be negative.");
        }
        long formula1 = 5 * (number * number) + 4;
        long formula2 = 5 * (number * number) - 4;
        if (!numbersContainer.containsKey(number)) {
            boolean condition = isPerfectSquare(formula1) || isPerfectSquare(formula2);
            numbersContainer.put(number, condition);
            return condition;
        }
        else {
            return numbersContainer.get(number);
        }
    }

    private static boolean isPerfectSquare(long number) {
        long temp = (long) Math.sqrt(number);
        return (temp * temp == number);
    }
}
