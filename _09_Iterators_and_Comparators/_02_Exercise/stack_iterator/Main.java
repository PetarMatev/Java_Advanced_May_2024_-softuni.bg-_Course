package Java_Advanced_May_2024._09_Iterators_and_Comparators._02_Exercise.stack_iterator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();
        StackIterator stackIterator = new StackIterator<>();
        while (!command.equals("END")) {
            String[] tokens = command.split("\\s+");
            String firstCommand = tokens[0];
            switch (firstCommand) {
                case "Push":
                    Arrays.stream(command.split("[\\s,]+"))
                            .skip(1)
                            .mapToInt(Integer::parseInt)
                            .forEach(stackIterator::push);
                     break;
                case "Pop":
                    try{
                        stackIterator.pop();
                    } catch(IllegalStateException exception) {
                        System.out.println(exception.getMessage());
                    }
                    break;
            }
            command = scan.nextLine();
        }

        stackIterator.forEach(System.out::println);
        stackIterator.forEach(System.out::println);


    }
}
