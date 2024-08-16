package Java_Advanced_May_2024._04_Stream_Files_Dictionaries._01_Lab;

import java.io.File;

public class _07_List_Files {
    public static void main(String[] args) {
        String path = "D:/Java 2024/Java Advanced Couse May 2024/src/Java_Advanced_May_2024" +
                "/_04_Stream_Files_Dictionaries/_01_Lab/04. Java-Advanced-Files-and-Streams-Lab-Resources/Files-and-Streams";
        File file = new File(path);
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                for (File f : files) {
                    if (!f.isDirectory()) {
                        System.out.printf("%s: [%s]%n",
                                f.getName(), f.length());
                    }
                }
            }
        }
    }
}