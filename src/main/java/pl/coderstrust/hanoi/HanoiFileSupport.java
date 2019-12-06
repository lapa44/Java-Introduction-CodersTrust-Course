package pl.coderstrust.hanoi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class HanoiFileSupport {

    private final String FILE_PATH;

    public HanoiFileSupport(String FILE_PATH) {
        this.FILE_PATH = FILE_PATH;
    }

    public void writeData(List<String> data) throws IOException {
        Files.write(Paths.get(FILE_PATH), data);
    }
}
