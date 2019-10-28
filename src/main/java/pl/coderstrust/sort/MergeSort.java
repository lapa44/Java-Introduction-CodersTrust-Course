package pl.coderstrust.sort;

class MergeSort implements SortingMethod {
    @Override
    public int[] sort(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        int middle = array.length / 2;
        int[] leftArray = new int[middle];
        System.arraycopy(array, 0, leftArray, 0, middle);
        int[] rightArray = new int[array.length - middle];
        System.arraycopy(array, middle, rightArray, 0, array.length - middle);
        leftArray = sort(leftArray);
        rightArray = sort(rightArray);
        return merge(leftArray, rightArray);
    }

    private int[] merge(int[] leftArray, int[] rightArray) {
        int[] result = new int[leftArray.length + rightArray.length];
        int i = 0, j = 0, k = 0;
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] < rightArray[j]) {
                result[k++] = leftArray[i++];
            }
            else {
                result[k++] = rightArray[j++];
            }
        }
        while (i < leftArray.length) {
            result[k++] = leftArray[i++];
        }
        while (j < rightArray.length) {
            result[k++] = rightArray[j++];
        }
        return result;
    }

}
