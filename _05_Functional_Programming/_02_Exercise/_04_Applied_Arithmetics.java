package Java_Advanced_May_2024._05_Functional_Programming._02_Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _04_Applied_Arithmetics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> nums = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>, List<Integer>> add = list -> list.stream().map(e -> e + 1).collect(Collectors.toList());
        Function<List<Integer>, List<Integer>> subtract = list -> list.stream().map(e -> e - 1).collect(Collectors.toList());
        Function<List<Integer>, List<Integer>> multiplyByTwo = list -> list.stream().map(e -> e * 2).collect(Collectors.toList());
        Consumer<List<Integer>> printList = list -> list.forEach(System.out::println);

        String command = scan.nextLine();
        while (!command.equals("end")) {
            String info = command;
            switch (info) {
                case "add":
                    nums = add.apply(nums);
                    break;
                case "subtract":
                    nums = subtract.apply(nums);
                    break;
                case "multiply":
                    nums = multiplyByTwo.apply(nums);
                    break;
                case "print":
                    printList.accept(nums);
                    System.out.println();
            }
            command = scan.nextLine();
        }

    }
}
