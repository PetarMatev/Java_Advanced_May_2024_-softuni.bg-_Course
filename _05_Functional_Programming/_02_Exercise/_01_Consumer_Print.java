package Java_Advanced_May_2024._05_Functional_Programming._02_Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class _01_Consumer_Print {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> names = Arrays.stream(scan.nextLine().split("\\s+")).collect(Collectors.toList());
        Consumer<String> getNames = x -> System.out.println(x);
        names.forEach(currentName -> getNames.accept(currentName));

        //  Arrays.stream(scan.nextLine().split("\\s+")).forEach(getNames);

    }
}
