package Java_Advanced_May_2024._03_Sets_and_Maps_Advanced._01_Lab;

import java.util.*;
import java.util.stream.Collectors;

public class _09_Largest_3_Numbers {

    public static void printLessThanTwONumbers(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (i < numbers.size() - 1) {
                System.out.printf("%d ", numbers.get(i));
            } else {
                System.out.printf("%d", numbers.get(i));
            }
        }
    }

    public static void printOutTopThree(List<Integer> numbers) {
        int size = 3;
        for (int i = 0; i < size; i++) {
            if (i < size - 1) {
                System.out.printf("%d ", numbers.get(i));
            } else {
                System.out.printf("%d", numbers.get(i));
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .sorted((n1, n2) -> n2.compareTo(n1))
                .collect(Collectors.toList());


        int size = numbers.size();
        if (size <= 2) {
            printLessThanTwONumbers(numbers);
        } else {
            printOutTopThree(numbers);
        }
    }


}
