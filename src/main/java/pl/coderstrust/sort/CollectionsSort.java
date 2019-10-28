package pl.coderstrust.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class CollectionsSort implements SortingMethod {
    @Override
    public int[] sort(int[] array) {
        List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toList());
        Collections.sort(list);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
