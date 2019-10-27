package pl.coderstrust.sort;

class CollectionsSortTest extends SortingTestBase {
    @Override
    SortingMethod getSortingMethod() {
        return new CollectionsSort();
    }
}
