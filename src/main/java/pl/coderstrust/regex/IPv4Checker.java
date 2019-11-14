package pl.coderstrust.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class IPv4Checker {

    private Pattern ipCompiledPattern;

    IPv4Checker() {
        String ipPattern = "^(25[0-5]\\.|" + "2[0-4]\\d\\.|" + "[0-1]?\\d{0,2}\\.){3}" +
                            "(25[0-5]|" + "2[0-4]\\d|" + "[0-1]?\\d{0,2})$";
        ipCompiledPattern = Pattern.compile(ipPattern);
    }

    boolean isApAdress(String input) {
        Matcher ipMatcher = ipCompiledPattern.matcher(input);
        return ipMatcher.matches();
    }
}
