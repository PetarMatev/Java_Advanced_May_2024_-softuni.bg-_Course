package Java_Advanced_May_2024._04_Stream_Files_Dictionaries._01_Lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _02_Write_to_File {

    public static void main(String[] args) throws IOException {

        String inputFile = "input.txt";
        String outPutFile = "output.txt";

        String pathInput = "D:\\Java 2024\\Java Advanced Couse May 2024\\src\\Java_Advanced_May_2024._04_Stream_Files_Dictionaries" +
                "\\_01_Lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams\\" + inputFile;

        String pathOutput = "D:\\Java 2024\\Java Advanced Couse May 2024\\src\\Java_Advanced_May_2024._04_Stream_Files_Dictionaries" +
                "\\_01_Lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams\\" + outPutFile;

        List<Character> symbols = new ArrayList<>();
        Collections.addAll(symbols, '.', ',', '!', '?');

        try (FileInputStream in = new FileInputStream(pathInput);
             FileOutputStream out = new FileOutputStream(pathOutput)) {

            int oneByte = 0;

            while ((oneByte = in.read()) >= 0) {
                if (!symbols.contains((char) oneByte)) {
                    out.write(oneByte);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
