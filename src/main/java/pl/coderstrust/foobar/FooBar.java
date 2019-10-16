package pl.coderstrust.foobar;

import java.util.ArrayList;
import java.util.List;

class FooBar {

    public static void main(String[] args) {
        printList(createFooBarList(100));
    }

    public static List<String> createFooBarList(int number) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i <= number; i++) {
            String toAdd = Integer.toString(i);
            toAdd += " ";
            if (i % 3 == 0) {
                toAdd += "Foo";
            }
            if (i % 5 == 0) {
                toAdd += "Bar";
            }
            result.add(toAdd);
        }
        return result;
    }

    public static void printList(List<String> ls) {
        for (String e : ls) {
            System.out.println(e);
        }
    }
}
