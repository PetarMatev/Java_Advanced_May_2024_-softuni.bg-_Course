package Java_Advanced_May_2024._05_Functional_Programming._01_Lab;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class _05_Filter_by_Age {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        Map<String, Integer> listOfPeople = new LinkedHashMap<>();
        for (int i = 0; i < num; i++) {
            List<String> user = Arrays.stream(scan.nextLine().split(",\\s+")).collect(Collectors.toList());
            listOfPeople.put(user.get(0), Integer.parseInt(user.get(1)));
        }

        String condition = scan.nextLine();
        int age = Integer.parseInt(scan.nextLine());
        String format = scan.nextLine();

        BiPredicate<String, Integer> filterByAge = (e, x) -> {

            if (e.equals("younger")) {
                return x <= age;
            } else if (e.equals("older")) {
                return x >= age;
            }
            return false;
        };

        LinkedHashMap<String, Integer> sortedList = new LinkedHashMap<>();

        listOfPeople.forEach((key, value) -> {
            if (filterByAge.test(condition, value)) {
                sortedList.put(key, value);
            }
        });

        Consumer<String> sorting = x -> {
            if (x.equals("name age")) {
                sortedList.forEach((k, v) -> System.out.println(k +" - " + v));
            } else if (x.equals("name")) {
                sortedList.forEach((k, v) -> System.out.println(k));
            } else if (x.equals("age")) {
                sortedList.forEach((k, v) -> System.out.println(v));
            }
        };

        sorting.accept(format);

    }
}
