package Java_Advanced_May_2024._04_Stream_Files_Dictionaries._01_Lab;

import java.io.*;
import java.util.Scanner;
import java.util.zip.ZipEntry;

public class _05_Write_Every_Third_Line {
    public static void main(String[] args) {
        // Get the current working directory
        String root = System.getProperty("user.dir");

        String inputFile = "input.txt";
        String outPutFile = "output.txt";

        String inputPath = "D:\\Java 2024\\Java Advanced Couse May 2024\\src\\Java_Advanced_May_2024._04_Stream_Files_Dictionaries" +
                "\\_01_Lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams\\" + inputFile;

        String outputPath = "D:\\Java 2024\\Java Advanced Couse May 2024\\src\\Java_Advanced_May_2024._04_Stream_Files_Dictionaries" +
                "\\_01_Lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams\\" + outPutFile;


        try (BufferedReader in = new BufferedReader(new FileReader(inputPath));
             PrintWriter out = new PrintWriter(new FileWriter(outputPath))) {

            int counter = 1;
            String line = in.readLine();
            while (line != null) {
                if (counter % 3 == 0) {
                    out.println(line);
                }
                counter++;
                line = in.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

