package Java_Advanced_May_2024._03_Sets_and_Maps_Advanced._02_Exercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _04_Count_Symbols {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        int num = text.length();
        Map<Character, Integer> box = new TreeMap<>();

        for(int i=0; i< num; i++) {
            Character currentChar = text.charAt(i);
            box.putIfAbsent(text.charAt(i),0);
            int previous = box.get(currentChar);
            box.put(currentChar, previous + 1);
        }

        for(Map.Entry<Character, Integer> entry : box.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " time/s");
        }
    }
}
