package Java_Advanced_May_2024._03_Sets_and_Maps_Advanced._02_Exercise;

import java.util.*;

public class _03_Periodic_Table {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        Set<String> box = new TreeSet<>();
        for(int i=0; i < num; i++) {
            String[] line = scan.nextLine().split("\\s+");
            Collections.addAll(box, line);
        }

        for(String item : box) {
            System.out.printf("%s ", item);
        }
    }
}
