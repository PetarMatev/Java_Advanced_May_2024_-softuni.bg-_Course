package Java_Advanced_May_2024._05_Functional_Programming._02_Exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _05_Reverse_And_Exclude {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> nums = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Collections.reverse(nums);

        int num = Integer.parseInt(scan.nextLine());
        Predicate<Integer> isNotDivisibleByNumber = number -> number % num != 0;

        nums.stream()
                .filter(isNotDivisibleByNumber)
                .forEach(x -> System.out.println(x + " "));
    }
}
