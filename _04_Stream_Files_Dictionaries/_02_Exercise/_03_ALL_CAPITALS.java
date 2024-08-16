package Java_Advanced_May_2024._04_Stream_Files_Dictionaries._02_Exercise;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class _03_ALL_CAPITALS {

    public static void main(String[] args) throws IOException {
        String content = Files.readString(Path.of("D:/Java 2024/Java Advanced Couse May 2024/src/Java_Advanced_May_2024/_04_Stream_Files_Dictionaries/_02_Exercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt"));
        content = content.toUpperCase();
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:/Java 2024/Java Advanced Couse May 2024/src/Java_Advanced_May_2024/_04_Stream_Files_Dictionaries/_02_Exercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/output.txt"));
        bufferedWriter.write(content);
        bufferedWriter.close();
    }
}