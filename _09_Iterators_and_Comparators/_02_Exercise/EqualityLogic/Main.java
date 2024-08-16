package Java_Advanced_May_2024._09_Iterators_and_Comparators._02_Exercise.EqualityLogic;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Person> treeSet = new TreeSet<>();
        Set<Person> hashSet = new HashSet<>();

        int n = Integer.parseInt(sc.nextLine());

        while (n-- > 0) {
            String[] input = sc.nextLine().split("\\s+");
            treeSet.add(new Person(input[0], Integer.parseInt(input[1])));
            hashSet.add(new Person(input[0], Integer.parseInt(input[1])));
        }

        System.out.println(treeSet.size());
        System.out.println(hashSet.size());
    }
}