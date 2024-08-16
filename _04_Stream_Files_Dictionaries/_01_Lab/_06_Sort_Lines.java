package Java_Advanced_May_2024._04_Stream_Files_Dictionaries._01_Lab;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

public class _06_Sort_Lines {
    public static void main(String[] args) throws IOException {
        String path = "D:/Java 2024/Java Advanced Couse May 2024/src/Java_Advanced_May_2024" +
                "/_04_Stream_Files_Dictionaries/_01_Lab/04. Java-Advanced-Files-and-Streams-Lab-Resources/input.txt";
        List<String> lines = Files.readAllLines(Path.of(path));
        Collections.sort(lines);

        PrintWriter out = new PrintWriter("D:/Java 2024/Java Advanced Couse May 2024/src/Java_Advanced_May_2024" +
                "/_04_Stream_Files_Dictionaries/_01_Lab/04. Java-Advanced-Files-and-Streams-Lab-Resources/output.txt");
        for (String line : lines) {
            out.println(line);
        }
        out.close();
    }
}