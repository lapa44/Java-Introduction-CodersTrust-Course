package pl.coderstrust.sort;

class BubbleSortTest extends SortingTestBase {
    @Override
    SortingMethod getSortingMethod() {
        return new BubbleSort();
    }
}
