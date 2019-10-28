package pl.coderstrust.numbers;

import java.util.ArrayList;
import java.util.List;

public class Processor {
    private NumbersProcessor numbersProcessor;
    private FileProcessor fileProcessor;

    public Processor(NumbersProcessor numbersProcessor, FileProcessor fileProcessor){
        this.numbersProcessor = numbersProcessor;
        this.fileProcessor = fileProcessor;
    }

    public void process(String fileName, String resultFileName){
        List<String> linesFromFile = fileProcessor.readLinesFromFile(fileName);
        List<String> resultLines = new ArrayList<>();
        for (String line : linesFromFile){
            resultLines.add(numbersProcessor.processLine(line));
        }
        fileProcessor.writeLinesToFile(resultLines, resultFileName);
    }

    public static void main(String[] args) {
        new Processor(new NumbersProcessor(), new FileProcessor()).process("numbersInput.txt", "numbersOutput.txt");
        new Processor(new NumbersProcessor(), new FileProcessor()).process("1000.txt", "numbersOutput2.txt");
    }
}
