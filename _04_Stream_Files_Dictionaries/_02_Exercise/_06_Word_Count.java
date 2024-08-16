package Java_Advanced_May_2024._04_Stream_Files_Dictionaries._02_Exercise;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.Map;

public class _06_Word_Count {

    public static void main(String[] args) throws IOException {
        String[] words = Files.readString(Path.of("D:/Java 2024/Java Advanced Couse May 2024/src/Java_Advanced_May_2024/_04_Stream_Files_Dictionaries" +
                "/_02_Exercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/words.txt")).split("\\s+");

        String text = Files.readString(Path.of("D:/Java 2024/Java Advanced Couse May 2024/src/Java_Advanced_May_2024/_04_Stream_Files_Dictionaries" +
                "/_02_Exercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/text.txt"));

        Map<String, Integer> wordCount = new LinkedHashMap<>();
        for (String word : words) {
            wordCount.put(word, 0);
        }

        for (String word : text.split("\\s+")) {
            if (wordCount.containsKey(word)) {
                int count = wordCount.get(word) + 1;
                wordCount.put(word, count);
            }
        }

        PrintWriter writer = new PrintWriter("D:/Java 2024/Java Advanced Couse May 2024/src/Java_Advanced_May_2024/_04_Stream_Files_Dictionaries" +
                "/_02_Exercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/result.txt");
        wordCount.entrySet().forEach(entry -> writer.println(entry.getKey() + " - " + entry.getValue()));
        writer.close();
    }
}