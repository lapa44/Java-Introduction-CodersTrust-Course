package pl.coderstrust.numbers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Processor {
    private NumbersProcessor numbersProcessor;
    private FileProcessor fileProcessor;

    public static void main(String[] args) throws IOException {
        new Processor(new NumbersProcessor(), new FileProcessor()).process("src/main/resources/numbersInput.txt", "src/main/resources/numbersOutput.txt");
        new Processor(new NumbersProcessor(), new FileProcessor()).process("src/main/resources/1000.txt", "src/main/resources/numbersOutput2.txt");
    }

    public Processor(NumbersProcessor numbersProcessor, FileProcessor fileProcessor){
        if (numbersProcessor == null) {
            throw new IllegalArgumentException("NumbersProcessor cannot be null.");
        }
        if (fileProcessor == null) {
            throw new IllegalArgumentException("FileProcessor cannot be null.");
        }
        this.numbersProcessor = numbersProcessor;
        this.fileProcessor = fileProcessor;
    }

    public void process(String inputFilePath, String outputFilePath) throws IOException {
        if (inputFilePath == null) {
            throw new IllegalArgumentException("Input file path cannot be null.");
        }
        if (outputFilePath == null) {
            throw new IllegalArgumentException("Output file path cannot be null.");
        }
        List<String> linesFromFile = fileProcessor.readLinesFromFile(inputFilePath);
        List<String> resultLines = new ArrayList<>();
        for (String line : linesFromFile){
            resultLines.add(numbersProcessor.processLine(line));
        }
        resultLines.removeAll(Collections.singletonList(""));
        fileProcessor.writeLinesToFile(resultLines, outputFilePath);
    }
}
