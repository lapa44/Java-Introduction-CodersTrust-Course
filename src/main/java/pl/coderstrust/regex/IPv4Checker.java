package pl.coderstrust.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class IPv4Checker {

    private static final String IP_REGEXP = "^(25[0-5]\\.|" + "2[0-4]\\d\\.|" + "[0-1]?\\d{0,2}\\.){3}" +
            "(25[0-5]|" + "2[0-4]\\d|" + "[0-1]?\\d{0,2})$";
    private static Pattern pattern = Pattern.compile(IP_REGEXP);

    public boolean isApAdress(String input) {
        if (input == null) {
            throw new IllegalArgumentException("IP Address cannot be equal to null.");
        }
        Matcher ipMatcher = pattern.matcher(input);
        return ipMatcher.matches();
    }
}
