package Java_Advanced_May_2024._05_Functional_Programming._02_Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _09_List_Of_Predicate {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());
        List<Integer> listOfNumbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        for (int i = 1; i <= number; i++) {
            boolean isDivisible = true;
            for (Integer integer : listOfNumbers) {
                Predicate<Integer> predicate = x -> x % integer != 0;
                if (predicate.test(i)) {
                    isDivisible = false;
                    break;
                }
            }

            if (isDivisible) {
                System.out.print(i + " ");
            }
        }
    }
}
