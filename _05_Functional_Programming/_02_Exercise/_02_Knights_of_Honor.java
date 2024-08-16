package Java_Advanced_May_2024._05_Functional_Programming._02_Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class _02_Knights_of_Honor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> names = Arrays.stream(scan.nextLine().split("\\s+")).collect(Collectors.toList());
        Consumer<List<String>> modifyList = x -> {
            names.forEach(currentName -> System.out.println("Sir " + currentName));
        };
        modifyList.accept(names);

//        Consumer<String> printWithSir = name -> System.out.println("Sir " + name);
//        Arrays.stream(scan.nextLine().split("\\s+")).forEach(printWithSir);

    }
}
