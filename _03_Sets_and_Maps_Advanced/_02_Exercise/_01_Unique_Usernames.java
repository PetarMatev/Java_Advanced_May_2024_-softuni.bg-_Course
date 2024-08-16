package Java_Advanced_May_2024._03_Sets_and_Maps_Advanced._02_Exercise;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class _01_Unique_Usernames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        Set<String> box = new LinkedHashSet<>();
        for (int i=0; i< num; i++) {
            box.add(scan.nextLine());
        }

        for(String word : box) {
            System.out.println(word);
        }
    }
}
