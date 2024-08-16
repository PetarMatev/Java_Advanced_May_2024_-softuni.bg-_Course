package Java_Advanced_May_2024._03_Sets_and_Maps_Advanced._02_Exercise;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class _06_Fix_Emails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, String> box = new LinkedHashMap<>();

        String command = scan.nextLine();
        while(!command.equals("stop")) {
            String name = command;
            String email = scan.nextLine();
            box.put(name, email);

            command = scan.nextLine();
        }


        for(Map.Entry<String, String> entry : box.entrySet()) {
            String text = entry.getValue().split("@")[1];
            String currDomain = text.split("\\.")[1];
            if (!currDomain.equals("us") && !currDomain.equals("uk") && !currDomain.equals("com")) {
                System.out.println(entry.getKey() + " -> " + entry.getValue());
            }
        }
    }
}
