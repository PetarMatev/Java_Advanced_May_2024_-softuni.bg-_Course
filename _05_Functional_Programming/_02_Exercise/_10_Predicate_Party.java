package Java_Advanced_May_2024._05_Functional_Programming._02_Exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _10_Predicate_Party {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> listOfNames = Arrays.stream(scan.nextLine().split("\\s+")).collect(Collectors.toList());

        Predicate<String> predicate;


        String line = scan.nextLine();
        while (!line.equals("Party!")) {
            List<String> info = Arrays.stream(line.split("\\s+")).collect(Collectors.toList());
            String command = info.get(0);
            String criteria = info.get(1);
            String parameter = info.get(2);

            switch (criteria) {
                case "StartsWith":
                    predicate = s -> s.startsWith(parameter);
                    break;
                case "EndsWith":
                    predicate = s -> s.endsWith(parameter);
                    break;
                default:
                    predicate = s -> s.length() == Integer.parseInt(parameter);
                    break;
            }

            if (command.equals("Remove")) {
                listOfNames.removeIf(predicate);
            } else {
                List<String> guestsToAdd = listOfNames.stream()
                        .filter(predicate)
                        .collect(Collectors.toList());
                listOfNames.addAll(guestsToAdd);
            }
            line = scan.nextLine();
        }

        if (listOfNames.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            String text = listOfNames.stream()
                            .sorted()
                                    .collect(Collectors.joining(", "));
            System.out.println(text + " are going to the party!");
        }

    }
}