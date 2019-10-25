package pl.coderstrust.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionsSort implements SortingMethod {
    public int[] sort(int[] array) {
        List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toList());
        Collections.sort(list);
        array = list.stream().mapToInt(i->i).toArray();
        return array;
    }
}
