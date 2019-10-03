package pl.coderstrust.sort;

import java.util.Arrays;

public class SortMain {

    public static void main(String[] args) {
        int[] array = {401,6,5,400,3,2,444};
            System.out.println("Selection sort output: " + Arrays.toString(SelectionSort.sort(array)));
            System.out.println("Bubble sort output: " + Arrays.toString(BubbleSort.sort(array)));
        System.out.println("Unsorted array: " + Arrays.toString(array));
    }
}
