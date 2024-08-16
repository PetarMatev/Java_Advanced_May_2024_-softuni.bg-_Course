package Java_Advanced_May_2024._04_Stream_Files_Dictionaries._02_Exercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class _01_Sum_Lines {

    public static void main(String[] args) throws IOException {

        String path = "D:/Java 2024/Java Advanced Couse May 2024/src/Java_Advanced_May_2024/_04_Stream_Files_Dictionaries/_02_Exercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt";

        List<String> lines = Files.readAllLines(Path.of(path));

        for (String line : lines) {
            int sum = 0;
            for (char symbol : line.toCharArray()) {
                sum += symbol;
            }
            System.out.println(sum);
        }
    }
}
