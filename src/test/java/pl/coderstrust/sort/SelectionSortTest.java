package pl.coderstrust.sort;

class SelectionSortTest extends SortingTestBase {
    @Override
    SortingMethod getSortingMethod() {
        return new SelectionSort();
    }
}
