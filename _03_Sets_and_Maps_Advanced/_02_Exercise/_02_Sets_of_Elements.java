package Java_Advanced_May_2024._03_Sets_and_Maps_Advanced._02_Exercise;

import com.sun.source.tree.Tree;

import java.util.*;

public class _02_Sets_of_Elements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] line = scan.nextLine().split("\\s+");
        int box1 = Integer.parseInt(line[0]);
        int box2 = Integer.parseInt(line[1]);
        Set<Integer> box1Set = new LinkedHashSet<>();
        Set<Integer> box2Set = new LinkedHashSet<>();
        for (int i=0; i < box1; i++) {box1Set.add(Integer.parseInt(scan.nextLine()));}
        for (int i=0; i < box2; i++) {box2Set.add(Integer.parseInt(scan.nextLine()));}

        for(int num : box1Set) {
            if (box2Set.contains(num)) {
                System.out.printf("%d ", num);
            }
        }

    }
}
