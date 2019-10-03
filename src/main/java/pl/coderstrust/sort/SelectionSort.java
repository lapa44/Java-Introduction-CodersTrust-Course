package pl.coderstrust.sort;

class SelectionSort {

    public static int[] sort(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null.");
        }
        int[] arrayToSort = array.clone();
        for (int i = 0; i < arrayToSort.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arrayToSort.length; j++) {
                if (arrayToSort[j] < arrayToSort[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arrayToSort, i, minIndex);
        }
        return arrayToSort;
    }

    private static void swap(int[] array, int a, int b) {
        int temp = array[b];
        array[b] = array[a];
        array[a] = temp;
    }
}
