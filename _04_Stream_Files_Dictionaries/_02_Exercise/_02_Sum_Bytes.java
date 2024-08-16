package Java_Advanced_May_2024._04_Stream_Files_Dictionaries._02_Exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class _02_Sum_Bytes {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("D:/Java 2024/Java Advanced Couse May 2024/" +
                "src/Java_Advanced_May_2024/_04_Stream_Files_Dictionaries" +
                "/_02_Exercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt"));
        int sum = 0;
        String line = bufferedReader.readLine();
        while (line != null) {
            for (char symbol : line.toCharArray()) {
                sum += symbol;
            }
            line = bufferedReader.readLine();
        }
        System.out.println(sum);
    }
}
