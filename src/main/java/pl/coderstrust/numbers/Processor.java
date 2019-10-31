package pl.coderstrust.numbers;

import java.util.ArrayList;
import java.util.List;

public class Processor {
    private NumbersProcessor numbersProcessor;
    private FileProcessor fileProcessor;

    public static void main(String[] args) {
        new Processor(new NumbersProcessor(), new FileProcessor()).process("src/main/resources/numbersInput.txt", "src/main/resources/numbersOutput.txt");
        new Processor(new NumbersProcessor(), new FileProcessor()).process("src/main/resources/1000.txt", "src/main/resources/numbersOutput2.txt");
    }

    public Processor(NumbersProcessor numbersProcessor, FileProcessor fileProcessor){
        if (numbersProcessor == null || fileProcessor == null) {
            throw new NullPointerException("NumbersProcessor and FileProcessor cannot be null.");
        }
        this.numbersProcessor = numbersProcessor;
        this.fileProcessor = fileProcessor;
    }

    public void process(String inputFilePath, String outputFilePath){
        if (inputFilePath == null || outputFilePath == null) {
            throw new NullPointerException("NumbersProcessor and FileProcessor cannot be null.");
        }
        List<String> linesFromFile = fileProcessor.readLinesFromFile(inputFilePath);
        List<String> resultLines = new ArrayList<>();
        for (String line : linesFromFile){
            resultLines.add(numbersProcessor.processLine(line));
        }
        fileProcessor.writeLinesToFile(resultLines, outputFilePath);
    }
}
