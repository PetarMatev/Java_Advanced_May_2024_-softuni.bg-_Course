package Java_Advanced_May_2024._03_Sets_and_Maps_Advanced._02_Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _05_Phonebook {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, String> box = new LinkedHashMap<>();
        String command = scan.nextLine();
        while (!command.equals("search")) {
            String[] line = command.split("-");
            String name = line[0];
            String number = line[1];
            box.put(name, number);
            command = scan.nextLine();
        }

        String instruction = scan.nextLine();
        while(!instruction.equals("stop")) {
             if (box.containsKey(instruction)) {
                 System.out.println(instruction + " -> " + box.get(instruction));
             } else {
                 System.out.println("Contact " + instruction + " does not exist.");
             }

            instruction = scan.nextLine();
        }
    }
}
