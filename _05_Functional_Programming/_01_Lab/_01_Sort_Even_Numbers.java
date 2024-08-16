package Java_Advanced_May_2024._05_Functional_Programming._01_Lab;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _01_Sort_Even_Numbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Predicate<Integer> filterEven = x -> {
            if (x % 2 == 0) {
                return true;
            }
            return false;
        };

        List<Integer> nums = Arrays.stream(scan.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .filter(e -> filterEven.test(e))
                .collect(Collectors.toList());

        System.out.println(nums.toString().replaceAll("\\[|]", ""));

        ArrayList<Integer> sortedList = nums.stream()
                .sorted((e1, e2) -> e1.compareTo(e2))
                .collect(Collectors.toCollection(ArrayList::new));

        System.out.println(sortedList.toString().replaceAll("\\[|]", ""));

    }
}