package Java_Advanced_May_2024._05_Functional_Programming._01_Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _06_Find_Evens_or_Odds {
    public static void returnFilteredRange(Integer lowerBound, Integer upperBound, Predicate<String> EvenOrOdd, String condition) {
        if (EvenOrOdd.test(condition)) {
            for (int i = lowerBound; i <= upperBound; i++) {
                if (i % 2 == 0) {
                    System.out.printf("%d ", i);
                }
            }
        } else {
            for (int i = lowerBound; i <= upperBound; i++) {
                if (i % 2 != 0) {
                    System.out.printf("%d ", i);
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> nums = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        int lowerBound = nums.get(0);
        int upperBound = nums.get(1);
        String condition = scan.nextLine();

        Predicate<String> EvenOrOdd = e -> {
            return e.equals("even");
        };

        returnFilteredRange(lowerBound, upperBound, EvenOrOdd, condition);


    }
}
