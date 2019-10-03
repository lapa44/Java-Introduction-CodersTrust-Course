package pl.coderstrust.sieve;

import java.util.Arrays;
import java.util.Scanner;

public class SieveOfEratosthenes {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter maximum number for Sieve of Eratosthenes: ");
        System.out.println("Your prime numbers: " + Arrays.toString(sieve(sc.nextInt())));
    }

    private static int[] sieve(int maximumNumber) {
        if (maximumNumber < 0) {
            throw new IllegalArgumentException("Maximum number cannot be negative.");
        }
        int[] array = new int[maximumNumber - 1];
        int resultLength = maximumNumber - 1;
        for (int i = 2; i <= maximumNumber; i++) {
            array[i - 2] = i;
        }
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] == 0 || array[i] == 0) {
                    continue;
                }
                if (array[j] % array[i] == 0) {
                    array[j] = 0;
                    resultLength--;
                }
            }
        }
        int[] resultArray = new int[resultLength];
        int counter = 0;
        for (int e : array) {
            if (e != 0) {
                resultArray[counter] = e;
                counter++;
            }
        }
        return resultArray;
    }
}
