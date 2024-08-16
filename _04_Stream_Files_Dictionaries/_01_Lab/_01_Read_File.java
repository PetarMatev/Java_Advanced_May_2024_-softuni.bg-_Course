package Java_Advanced_May_2024._04_Stream_Files_Dictionaries._01_Lab;

import java.io.FileInputStream;
import java.io.IOException;

public class _01_Read_File {
    public static void main(String[] args) throws IOException {

        String inputFile = "input.txt";
        String pathInput = "D:\\Java 2024\\Java Advanced Couse May 2024\\src\\Java_Advanced_May_2024._04_Stream_Files_Dictionaries" +
                "\\_01_Lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams\\" + inputFile;

        try (FileInputStream in = new FileInputStream(pathInput)) {
            int oneByte = in.read();
            while (oneByte >= 0) {
                String num = Integer.toBinaryString(oneByte);
                System.out.printf("%s ", num);
                oneByte = in.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
