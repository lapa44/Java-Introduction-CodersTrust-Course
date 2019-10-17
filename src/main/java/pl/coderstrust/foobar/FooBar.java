package pl.coderstrust.foobar;

import java.util.ArrayList;
import java.util.List;

class FooBar {

    public static void main(String[] args) {
        getFooBar(100).forEach(System.out::println);
    }

    public static List<String> getFooBar(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Number cannot be lower than zero.");
        }
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= number; i++) {
            sb.append(i).append(" ");
            if (i % 3 == 0) {
                sb.append("Foo");
            }
            if (i % 5 == 0) {
                sb.append("Bar");
            }
            result.add(sb.toString());
            sb.delete(0, sb.length());
        }
        return result;
    }
}
