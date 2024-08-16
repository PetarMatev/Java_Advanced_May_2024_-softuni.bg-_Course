package Java_Advanced_May_2024._03_Sets_and_Maps_Advanced._01_Lab;

import java.util.*;
import java.util.stream.Collectors;

public class _04_Count_Real_Numbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Double> input = Arrays.stream(scan.nextLine()
                        .split("\\s+"))
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        Map<Double, Integer> myCollection = new LinkedHashMap<>();
        for (Double num : input) {
            myCollection.putIfAbsent(num, 0);
            int newCount = myCollection.get(num) + 1;
            myCollection.put(num, newCount);
        }
        myCollection.forEach((k, v) -> {
            System.out.printf("%.1f -> %d%n", k, v);
        });
    }
}
