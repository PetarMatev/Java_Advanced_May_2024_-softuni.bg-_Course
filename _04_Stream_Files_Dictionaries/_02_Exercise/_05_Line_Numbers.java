package Java_Advanced_May_2024._04_Stream_Files_Dictionaries._02_Exercise;


import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class _05_Line_Numbers {

    public static void main(String[] args) throws IOException {

        String path = "D:/Java 2024/Java Advanced Couse May 2024/src/Java_Advanced_May_2024/_04_Stream_Files_Dictionaries/_02_Exercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputLineNumbers.txt";

        List<String> lines = Files.readAllLines(Path.of(path));

        PrintWriter writer = new PrintWriter("D:/Java 2024/Java Advanced Couse May 2024/src/Java_Advanced_May_2024/_04_Stream_Files_Dictionaries/_02_Exercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/output.txt");

        int counter = 1;
        for (String line : lines) {
            String output = String.format("%d. %s", counter, line);
            counter++;
            writer.println(output);
        }

        writer.close();
    }
}