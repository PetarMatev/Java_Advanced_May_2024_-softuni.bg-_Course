package Java_Advanced_May_2024._04_Stream_Files_Dictionaries._02_Exercise;

import java.io.File;

public class _08_Get_Folder_Size {

    public static void main(String[] args) {
        String folderPath = "D:/Java 2024/Java Advanced Couse May 2024/src/Java_Advanced_May_2024/" +
                "_04_Stream_Files_Dictionaries/_02_Exercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/Exercises Resources";

        int size = 0;
        File folder = new File(folderPath);

        for (File file : folder.listFiles()) {
            size += file.length();
        }

        System.out.println("Folder size: " + size);
    }
}