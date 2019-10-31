package pl.coderstrust.numbers;

import java.util.Scanner;

public class NumbersProcessor {
    public String processLine(String line) {
        if (!isLineValid(line)) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        Scanner sc = new Scanner(line);
        int sum = 0, temp;
        while (sc.hasNextInt()) {
            temp = sc.nextInt();
            result.append(temp).append("+");
            sum += temp;
        }
        result.deleteCharAt(result.length() - 1);
        result.append("=");
        result.append(sum);
        return result.toString();
    }

    private boolean isLineValid(String line) {
        return line != null && line.matches("[-?\\d ]+");
    }
}
