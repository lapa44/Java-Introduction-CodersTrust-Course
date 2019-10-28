package pl.coderstrust.numbers;

public class NumbersProcessor {
    public String processLine(String line) {
        StringBuilder result = new StringBuilder();
        int sum = 0;
        String[] array = line.split(" ");
        for (String element : array) {
            if (!element.equals("")) {
                result.append(element).append("+");
                sum += Integer.parseInt(element);
            }
        }
        result.deleteCharAt(result.length() - 1);
        result.append("=");
        result.append(sum);
        return result.toString();
    }
}
