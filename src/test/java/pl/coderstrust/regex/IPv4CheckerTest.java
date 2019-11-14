package pl.coderstrust.regex;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IPv4CheckerTest {

    @ParameterizedTest
    @DisplayName("Parameterized test for invalid Ip Adresses")
    @ValueSource(strings = {"-1.0.0.0", "256.144.33.1000", "0.0.0.-10", "192.168.256.420", "1000.1000.1000.1000.1000"})
    void shouldNotAcceptProvidedAddresses(String input) {
        assertFalse(new IPv4Checker().isApAdress(input));
    }

    @Test
    @DisplayName("Smart test for valid ip addresses")
    void shouldAcceptProvidedAddresses() {
        for (int i = 0; i < 256; i++) {
            assertTrue(new IPv4Checker().isApAdress(i+".1.1.1"));
        }
    }

    @Disabled
    /*
    Time that this test took: 2 057 745 ms == 34,3 minutes.
     */
    @Test
    @DisplayName("Unit test for all valid IP Addresses")
    void shouldAcceptAllValidAddresses() {
        IPv4Checker ipChecker = new IPv4Checker();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 256; i++) {
            for (int y = 0; y < 256; y++) {
                for (int j = 0; j < 256; j++) {
                    for (int k = 0; k < 256; k++) {
                        assertTrue(ipChecker.isApAdress(i + "." + y + "." + j + "." + k));
                    }
                }
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}