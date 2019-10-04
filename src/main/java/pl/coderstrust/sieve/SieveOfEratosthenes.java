package pl.coderstrust.sieve;

import java.util.Arrays;
import java.util.Scanner;

public class SieveOfEratosthenes {

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
        int[] array = new int[size - 1];
        for (int i = 2; i <= size; i++) {
            array[i - 2] = i;
        }
        return array;
    }

    private static int markNonePrimeNumbers(int[] array) {
        int nonPrimeCounter = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] == 0 || array[i] == 0) {
                    continue;
                }
                if (array[j] % array[i] == 0) {
                    array[j] = 0;
                    nonPrimeCounter++;
                }
            }
        }
        return nonPrimeCounter;
    }

    private static int[] extractPrimesNumbers(int[] array, int countOfPrimeNumbers) {
        int[] extractedPrimes = new int[countOfPrimeNumbers];
        int counter = 0;
        for (int e : array) {
            if (e != 0) {
                extractedPrimes[counter] = e;
                counter++;
            }
        }
        return extractedPrimes;
    }
}
