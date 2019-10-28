package pl.coderstrust.numbers;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

 class FileProcessor {
    public List<String> readLinesFromFile(String fileName) {
        try {
            FileInputStream fileIn = new FileInputStream("src/main/resources/" + fileName);
            List<String> result = new ArrayList<>();
            Scanner sc = new Scanner(fileIn);
            while(sc.hasNext()) {
                result.add(sc.nextLine());
            }
            fileIn.close();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void writeLinesToFile(List<String> resultLines, String resultFileName) {
        try {
            FileOutputStream fileOut = new FileOutputStream("src/main/resources/" + resultFileName);
            for (String element : resultLines) {
                fileOut.write((element + "\n").getBytes());
            }
            fileOut.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
