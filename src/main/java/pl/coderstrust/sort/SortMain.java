package pl.coderstrust.sort;

import java.util.Arrays;

public class SortMain {

    public static void main(String[] args) {
        int[] array = {401,6,5,400,3,2,444};
        System.out.println("Unsorted array: " + Arrays.toString(array));
        System.out.println("Selection sort output: " + Arrays.toString(new SelectionSort().sort(array)));
        System.out.println("Bubble sort output: " + Arrays.toString(new BubbleSort().sort(array)));
        System.out.println("Merge sort output: " + Arrays.toString(new MergeSort().sort(array)));
        System.out.println("QuickSort output: : " + Arrays.toString(new QuickSort().sort(array)));
        System.out.println("CollectionsSort output: " + Arrays.toString(new CollectionsSort().sort(array)));
    }
}
