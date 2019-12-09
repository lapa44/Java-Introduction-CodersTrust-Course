package pl.coderstrust.hanoi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

class HanoiFileSupport {

    private final String FILE_PATH;

    public HanoiFileSupport(String FILE_PATH) throws IOException {
        this.FILE_PATH = FILE_PATH;
        Files.write(Paths.get(FILE_PATH), "".getBytes());
    }

    public void writeData(String message) throws IOException {
        Files.write(Paths.get(FILE_PATH), (message + "\n").getBytes(), StandardOpenOption.APPEND);
    }
}
