package pl.coderstrust.sort;

class MergeSortTest extends SortingTestBase {
    @Override
    SortingMethod getSortingMethod() {
        return new MergeSort();
    }
}
