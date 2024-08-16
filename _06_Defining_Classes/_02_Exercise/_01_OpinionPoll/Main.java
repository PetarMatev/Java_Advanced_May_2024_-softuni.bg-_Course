package Java_Advanced_May_2024._06_Defining_Classes._02_Exercise._01_OpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());

        LinkedList<Person> people = new LinkedList<>();

        for (int i = 0; i < num; i++) {
            String[] info = scan.nextLine().split("\\s+");
            String name = info[0];
            int age = Integer.parseInt(info[1]);
            Person person = new Person(name, age);
            people.add(person);
        }

        people.stream()
                .filter(person -> person.getAge() > 30)
                .sorted()
                .forEach(System.out::println);
    }
}
