package pl.coderstrust.sort;

public class SortMain {

    public static void main(String[] args) {
        int[] array = {401,6,5,400,3,2,444};
        System.out.println("Selection sort output:");
        printArray(SelectionSort.sort(array));
        System.out.println("Bubble sort output:");
        printArray(BubbleSort.sort(array));
        System.out.println("Unsorted array:");
        printArray(array);
    }

    private static void printArray(int[] arr) {
        for (int e : arr) {
            System.out.print(e + " ");
        }
        System.out.println();
    }
}
