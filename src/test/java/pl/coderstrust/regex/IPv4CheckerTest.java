package pl.coderstrust.regex;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

class IPv4CheckerTest {

    @ParameterizedTest
    @DisplayName("Parameterized test for invalid Ip Adresses")
    @ValueSource(strings = {"-1.0.0.0", "256.144.33.1000", "0.0.0.-10", "192.168.256.420", "1000.1000.1000.1000.1000"})
    void shouldReturnFalseForInvalidIpAddress(String input) {
        assertFalse(new IPv4Checker().isIpAdress(input));
    }

    @ParameterizedTest
    @DisplayName("Parameterized test for valid Ip Adresses")
    @ValueSource(strings = {"0.0.0.0", "255.255.255.255", "1.0.0.10", "192.168.255.220", "192.168.0.131"})
    void shouldReturnTrueForValidIpAddress(String input) {
        assertTrue(new IPv4Checker().isIpAdress(input));
    }

    @ParameterizedTest
    @DisplayName("Smart test for valid ip addresses")
    @ValueSource(strings = {"%d.1.1.1", "1.%d.1.1", "1.1.%d.1", "1.1.1.%d"})
    void smartTest(String ipAddressTemplate) {
        for (int i = 0; i < 256; i++) {
            assertTrue(new IPv4Checker().isIpAdress(String.format(ipAddressTemplate, i)));
        }
    }

    @Test
    @DisplayName("Unit test throwing illegal argument exception as input")
    void shouldThrowExceptionForInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> new IPv4Checker().isIpAdress(null));
    }

    @Disabled
    /*
    Time that this test took using String: 2 057 745 ms == 34,3 minutes.
    Time that this test took using StringBuilder: 1 727 192 ms = 28,8 minutes.
     */
    @Test
    @DisplayName("Unit test for all valid IP Addresses")
    void shouldAcceptAllValidAddresses() {
        IPv4Checker ipChecker = new IPv4Checker();
        StringBuilder pattern = new StringBuilder();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 256; i++) {
            for (int j = 0; j < 256; j++) {
                for (int k = 0; k < 256; k++) {
                    for (int l = 0; l < 256; l++) {
                        pattern.append(i).append(".").append(j).append(".").append(k).append(".").append(l);
                        assertTrue(ipChecker.isIpAdress(pattern.toString()));
                        pattern.setLength(0);
                    }
                }
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}
