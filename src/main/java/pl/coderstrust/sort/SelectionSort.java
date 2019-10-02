package pl.coderstrust.sort;

import java.util.Arrays;

class SelectionSort {

    public static int[] sort(int[] array) {
        int[] copyArray = Arrays.copyOf(array, array.length);
        for (int i = 0; i < copyArray.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (copyArray[j] < copyArray[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = copyArray[minIndex];
            copyArray[minIndex] = copyArray[i];
            copyArray[i] = temp;
        }
        return copyArray;
    }
}
