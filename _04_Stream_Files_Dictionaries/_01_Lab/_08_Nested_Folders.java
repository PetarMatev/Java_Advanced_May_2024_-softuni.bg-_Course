package Java_Advanced_May_2024._04_Stream_Files_Dictionaries._01_Lab;

import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;

public class _08_Nested_Folders {

    public static void main(String[] args) throws IOException {
        File file = new File("D:/Java 2024/Java Advanced Couse May 2024/src/Java_Advanced_May_2024" +
                "/_04_Stream_Files_Dictionaries/_01_Lab/04. Java-Advanced-Files-and-Streams-Lab-Resources");

        ArrayDeque<File> queue = new ArrayDeque<>();
        queue.offer(file);
        int count = 0;

        while (!queue.isEmpty()) {
            File[] files = queue.poll().listFiles();

            for (File f : files) {
                if (f.isDirectory()) {
                    queue.offer(f);
                    System.out.println(f.getName());
                    count++;
                }
            }
        }
        System.out.println(count + " folders");
    }
}