package pl.coderstrust.christmas;
import java.util.Scanner;

public class ChristmasTree {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter tree's height: ");
        int size = sc.nextInt();
        printChristmasTree(size);
    }

    private static void printChristmasTree(int height) {
        String temp = "*";
        for(int i = 1 ; i <= height; i++) {
            System.out.printf("%" + (i + height) + "s\n", temp);
            temp += "**";
        }
        System.out.printf("%" + (1 + height) + "s", "**");
    }
}
