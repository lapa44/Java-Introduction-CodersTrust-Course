package pl.coderstrust.foobar;

import java.util.ArrayList;
import java.util.List;

class FooBar {

    public static void main(String[] args) {
        getFooBar(100).forEach(System.out::println);
    }

    public static List<String> getFooBar(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("FooBar numbers can't be negative.");
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i <= number; i++) {
            StringBuilder toAdd = new StringBuilder(Integer.toString(i));
            toAdd.append(" ");
            if (i % 3 == 0) {
                toAdd.append("Foo");
            }
            if (i % 5 == 0) {
                toAdd.append("Bar");
            }
            result.add(toAdd.toString());
        }
        return result;
    }
}
