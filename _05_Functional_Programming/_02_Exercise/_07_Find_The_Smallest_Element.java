package Java_Advanced_May_2024._05_Functional_Programming._02_Exercise;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _07_Find_The_Smallest_Element {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> nums = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>, Integer> findSmallestValue = list -> {
            int smallestValue = Collections.min(list);
            int rightMost = 0;
            for (int i = list.size() - 1; i >= 0; i--) {
                int currentNum = list.get(i);
                if (currentNum == smallestValue) {
                    return i;
                }
            }
            return rightMost;
        };
        System.out.println(findSmallestValue.apply(nums));
    }
}
