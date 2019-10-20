package pl.coderstrust.christmas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChristmasTree {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter tree's height: ");
        int size = sc.nextInt();

        getChristmasTree(size).forEach(System.out::println);
    }

    public static List<String> getChristmasTree(int height) {
        if (height < 0) {
            throw new IllegalArgumentException("Tree's height cannot be lower than zero.");
        }
        List<String> result = new ArrayList<>();
        String temp = "*";
        for (int i = 1 ; i <= height; i++) {
            result.add(String.format("%" + (i + height) + "s", temp));
            temp += "**";
        }
        result.add(String.format("%" + (1 + height) + "s", "**"));
        return result;
    }
}
