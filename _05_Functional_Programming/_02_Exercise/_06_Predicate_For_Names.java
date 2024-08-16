package Java_Advanced_May_2024._05_Functional_Programming._02_Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class _06_Predicate_For_Names {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int num = Integer.parseInt(scan.nextLine());
        Predicate<String> evaluateName = x -> x.length() <= num;

        Arrays.stream(scan.nextLine().split("\\s+"))
                .filter(evaluateName)
                .forEach(System.out::println);
    }
}
