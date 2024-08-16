package Java_Advanced_May_2024._09_Iterators_and_Comparators._02_Exercise.listy_iterator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ListyIterator<String> listyIterator = new ListyIterator<>();
        String command = scan.nextLine();
        while (!command.equals("END")) {
            String[] tokens = command.split("\\s+");
            String firstCommand = tokens[0];
            switch (firstCommand) {
                case "Create":
                    String[] elements = Arrays.stream(command.split("\\s+")).skip(1).toArray(String[]::new);

                    listyIterator = new ListyIterator<>(elements);
                    break;
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "Print":
                    try {
                        listyIterator.print();
                    } catch (IllegalStateException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
                case "PrintAll":
                    listyIterator.forEach(e -> System.out.print(e + " "));
                    System.out.println();
                    break;
            }
            command = scan.nextLine();
        }

    }
}
