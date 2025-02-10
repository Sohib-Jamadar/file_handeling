package Sohib;

import java.io.*;
import java.nio.file.*;

public class Filehandler {

    private static final String FILE_PATH = "sample.txt";

    public static void main(String[] args) {
        writeFile("Hello, this is a sample text file.\nLet's modify it later.");
        readFile();
        modifyFile("sample", "updated");
        readFile();
    }

    public static void writeFile(String content) {
        try {
            Files.write(Paths.get(FILE_PATH), content.getBytes(), StandardOpenOption.CREATE);
            System.out.println("File written successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFile() {
        try {
            String content = new String(Files.readAllBytes(Paths.get(FILE_PATH)));
            System.out.println("File contents:\n" + content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void modifyFile(String oldWord, String newWord) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(FILE_PATH)));
            content = content.replace(oldWord, newWord);
            Files.write(Paths.get(FILE_PATH), content.getBytes(), StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("File updated successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
