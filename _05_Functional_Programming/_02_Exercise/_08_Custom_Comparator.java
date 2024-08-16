package Java_Advanced_May_2024._05_Functional_Programming._02_Exercise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class _08_Custom_Comparator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // The custom comparator does not swap when it gets -1 but does swap when it gets 1
        Comparator<Integer> customComparator = (first, second) -> {

            // first even, second odd -> no swap
            if (first % 2 == 0 && second % 2 != 0) {
                return -1;

                // first odd, second even -> swap
            } else if (first % 2 != 0 && second % 2 == 0) {
                return 1;

                // first even, second even
                // first odd, second odd
            } else {
                return first.compareTo(second);
            }
        };

        Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .sorted(customComparator)
                .forEach(e -> System.out.print(e + " "));
    }
}
