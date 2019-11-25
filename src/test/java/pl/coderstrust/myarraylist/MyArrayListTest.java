package pl.coderstrust.myarraylist;

import java.util.List;

class MyArrayListTest extends ArrayListTestBase {
    @Override
    List getArrayList() {
        return new MyArrayList<>();
    }

    @Override
    List getArrayList(Long[] input) {
        return new MyArrayList<>(input);
    }
}
