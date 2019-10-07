package pl.coderstrust.sieve;

import java.util.Arrays;
import java.util.Scanner;

public class SieveOfEratosthenes {

    private static final int NON_PRIME_MARKER = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter maximum number for Sieve of Eratosthenes: ");
        System.out.println("Your prime numbers: " + Arrays.toString(sieve(sc.nextInt())));
    }

    public static int[] sieve(int maximumNumber) {
        if (maximumNumber < 2) {
            return new int[0];
        }
        int[] array = createInitialArray(maximumNumber);
        int countOfNonPrimeNumbers = markNonePrimeNumbers(array);
        int countOfPrimeNumbers = array.length - countOfNonPrimeNumbers;
        return extractPrimesNumbers(array, countOfPrimeNumbers);
    }

    private static int[] createInitialArray(int size) {
        int[] array = new int[size + 1];
        for (int i = 0; i <= size; i++) {
            array[i] = i;
        }
        return array;
    }

    private static int markNonePrimeNumbers(int[] array) {
        int nonPrimeCount = 2;
        for (int i = 2; (i * i) <= array.length; i++) {
            for (int j = i; (i * j) <= array.length - 1; j++) {
                if (array[i * j] != NON_PRIME_MARKER) {
                    array[i * j] = NON_PRIME_MARKER;
                    nonPrimeCount++;
                }
            }
        }
        return nonPrimeCount;
    }

    private static int[] extractPrimesNumbers(int[] array, int countOfPrimeNumbers) {
        int[] extractedPrimes = new int[countOfPrimeNumbers];
        int counter = 0;
        for (int i = 2; i < array.length; i++) {
            if (array[i] != NON_PRIME_MARKER) {
                extractedPrimes[counter++] = array[i];
            }
        }
        return extractedPrimes;
    }
}
