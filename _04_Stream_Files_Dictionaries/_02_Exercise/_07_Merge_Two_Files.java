package Java_Advanced_May_2024._04_Stream_Files_Dictionaries._02_Exercise;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class _07_Merge_Two_Files {

    public static void main(String[] args) throws IOException {

        String firstFileContent = Files.readString(Path.of("D:/Java 2024/Java Advanced Couse May 2024/src/Java_Advanced_May_2024/_04_Stream_Files_Dictionaries" +
                "/_02_Exercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputOne.txt"));
        String secondFileContent = Files.readString(Path.of("D:/Java 2024/Java Advanced Couse May 2024/src/Java_Advanced_May_2024/_04_Stream_Files_Dictionaries" +
                "/_02_Exercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputTwo.txt"));

        PrintWriter writer = new PrintWriter("D:/Java 2024/Java Advanced Couse May 2024/src/Java_Advanced_May_2024/_04_Stream_Files_Dictionaries" + "/_02_Exercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/output.txt");
        writer.println(firstFileContent);
        writer.println(secondFileContent);
        writer.close();
    }
}