package Java_Advanced_May_2024._04_Stream_Files_Dictionaries._01_Lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.out;

public class _04_Extract_Integers {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        // Get the current working directory
        String root = System.getProperty("user.dir");

        String inputFile = "input.txt";
        String outPutFile = "output.txt";

        String pathInput = "D:\\Java 2024\\Java Advanced Couse May 2024\\src\\Java_Advanced_May_2024._04_Stream_Files_Dictionaries" +
                "\\_01_Lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams\\" + inputFile;

        String pathOutput = "D:\\Java 2024\\Java Advanced Couse May 2024\\src\\Java_Advanced_May_2024._04_Stream_Files_Dictionaries" +
                "\\_01_Lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams\\" + outPutFile;

//        try (FileInputStream in = new FileInputStream(pathInput);
//             FileOutputStream out = new FileOutputStream(pathOutput)) {


            while (scan.hasNext()) {
                if (scan.hasNextInt()) {
                    out.println(scan.nextInt());
                }
                scan.next();
            }


//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
