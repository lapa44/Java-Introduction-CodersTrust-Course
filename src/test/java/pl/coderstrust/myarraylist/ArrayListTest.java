package pl.coderstrust.myarraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ArrayListTest extends ArrayListTestBase {
    @Override
    List getArrayList() {
        return new ArrayList<>();
    }

    @Override
    List getArrayList(Long[] input) {
        return new ArrayList<>(Arrays.asList(input));
    }

}
