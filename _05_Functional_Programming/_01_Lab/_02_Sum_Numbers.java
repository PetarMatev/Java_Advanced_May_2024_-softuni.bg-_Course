package Java_Advanced_May_2024._05_Functional_Programming._01_Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _02_Sum_Numbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> stringList = Arrays.stream(scan.nextLine().split(",\\s+"))
                .collect(Collectors.toList());

        List<Integer> nums = stringList.stream().map(x -> Integer.parseInt(x)).collect(Collectors.toList());

        Function<List<Integer>, List<Integer>> getSummaryStaticstics  = x -> {
            int total = 0;
            int sum = 0;
            for (int i = 0; i < stringList.size(); i++) {
                total += 1;
                sum += nums.get(i);
            };

            List<Integer> statistics = new ArrayList<>();
            statistics.add(total);
            statistics.add(sum);
            return statistics;
        };

        List<Integer> finalResult = getSummaryStaticstics.apply(nums);
        System.out.println("Count = " + finalResult.get(0));
        System.out.println("Sum = " + finalResult.get(1));
    }
}
