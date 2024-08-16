import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;

public class _03_Copy_Bytes {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("D:/Java 2024/Java Advanced Couse May 2024/src/Java_Advanced_May_2024" +
                "/_04_Stream_Files_Dictionaries/_01_Lab/04. Java-Advanced-Files-and-Streams-Lab-Resources/input.txt");
        PrintStream outputStream = new PrintStream("D:/Java 2024/Java Advanced Couse May 2024/src/Java_Advanced_May_2024" +
                "/_04_Stream_Files_Dictionaries/_01_Lab/04. Java-Advanced-Files-and-Streams-Lab-Resources/output.txt");

        int oneByte = inputStream.read();
        while (oneByte != -1) {
            if ((char) oneByte != ' ' && (char) oneByte != '\n') {
                outputStream.print(oneByte);
            } else {
                outputStream.print((char) oneByte);
            }
            oneByte = inputStream.read();
        }
    }
}