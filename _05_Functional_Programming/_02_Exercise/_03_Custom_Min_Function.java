package Java_Advanced_May_2024._05_Functional_Programming._02_Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _03_Custom_Min_Function {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

//        Set<Integer> nums = Arrays.stream(scan.nextLine().split("\\s+"))
//                .map(Integer::parseInt)
//                .collect(Collectors.toSet());
//
//        Function<Set<Integer>, Integer> getMin = s -> {
//            final Integer[] currentMin = {Integer.MAX_VALUE};
//            nums.forEach(e -> {
//                if (e < currentMin[0]) {
//                    currentMin[0] = e;
//                }
//            });
//            return currentMin[0];
//        };
//
//        System.out.println(getMin.apply(nums));


        Integer[] numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .toArray(Integer[]:: new);

        Function<Integer[], Integer> findTheSmallestNumber = arr -> Arrays.stream(arr).min(Integer::compareTo).get();
        System.out.println(findTheSmallestNumber.apply(numbers));


    };
}
