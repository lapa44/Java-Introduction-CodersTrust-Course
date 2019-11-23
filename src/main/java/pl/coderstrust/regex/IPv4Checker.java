package pl.coderstrust.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class IPv4Checker {

    private static final String IP_REGEXP = "^(25[0-5]\\.|2[0-4]\\d\\.|[0-1]?\\d{0,2}\\.){3}(25[0-5]|2[0-4]\\d|[0-1]?\\d{0,2})$";
    private static final Pattern PATTERN = Pattern.compile(IP_REGEXP);

    public boolean isIpAdress(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null.");
        }
        Matcher Matcher = PATTERN.matcher(input);
        return Matcher.matches();
    }
}
