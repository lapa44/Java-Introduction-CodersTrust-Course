package pl.coderstrust.sort;

import java.util.Arrays;

class BubbleSort {

    public static int[] sort(int[] array) {
        int[] copyArray = Arrays.copyOf(array, array.length);
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < copyArray.length - 1; i++) {
                if (copyArray[i] > copyArray[i + 1]) {
                    int temp = copyArray[i + 1];
                    copyArray[i + 1] = copyArray[i];
                    copyArray[i] = temp;
                    swapped = true;
                }
            }
        } while(swapped);
        return copyArray;
    }
}
