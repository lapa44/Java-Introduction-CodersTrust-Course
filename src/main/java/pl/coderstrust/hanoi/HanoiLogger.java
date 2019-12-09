package pl.coderstrust.hanoi;

import java.io.IOException;

class HanoiLogger {

    private final HanoiFileSupport hanoiFileSupport;

    HanoiLogger(HanoiFileSupport hanoiFileSupport) {
        this.hanoiFileSupport = hanoiFileSupport;
    }

    public void log(String message) throws IOException {
        hanoiFileSupport.writeData(message);
    }
}
