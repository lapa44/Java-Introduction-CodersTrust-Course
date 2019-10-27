package pl.coderstrust.sort;

class QuickSortTest extends SortingTestBase {
    @Override
    SortingMethod getSortingMethod() {
        return new QuickSort();
    }
}
