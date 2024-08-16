package Java_Advanced_May_2024._05_Functional_Programming._01_Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _03_Count_Uppercase_Words {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> text = Arrays.stream(scan.nextLine().split("\\s+")).collect(Collectors.toList());

        Predicate<String> getUpper = x -> {
            String word = x;
            if (Character.isUpperCase(word.toCharArray()[0])) {
                return true;
            }
            return false;
        };

        List<String> finalContainer = new ArrayList<>();
        for (int i =0 ; i < text.size(); i++) {
            if (getUpper.test(text.get(i))) {
                finalContainer.add(text.get(i));
            }
        }

        System.out.println(finalContainer.size());
        finalContainer.forEach(e -> System.out.println(e));
    }
}
