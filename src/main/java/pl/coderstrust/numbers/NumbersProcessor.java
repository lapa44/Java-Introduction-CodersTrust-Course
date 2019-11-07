package pl.coderstrust.numbers;

import java.util.Scanner;

public class NumbersProcessor {
    public String processLine(String line) {
        if (!isLineValid(line)) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        try(Scanner sc = new Scanner(line);) {
            int sum = 0;
            int temp = 0;
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
    }

    private boolean isLineValid(String line) {
        if (line == null || line.trim().isEmpty()) {
            return false;
        }
        return line.matches("^[-?\\d\\s]+$");
    }
}
