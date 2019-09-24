package vop.lektion6.runningThread.lektion5.WordCount;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


public class WordCount {
    private File file;

    public WordCount(String filename) {
        file = new File(filename);
        readFile();
    }

    public void readFile() {
        int wordCount = 0;
        try {
            FileReader fr = new FileReader(file);
            Scanner scanner = new Scanner(fr);
            String line = null;
            String[] words = null;
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                words = line.split("\\s+");
                wordCount += words.length;
            }
        System.out.println(wordCount);
    }
 catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        WordCount wc = new WordCount("Snow white.txt");


    }
}
