package Java_Advanced_May_2024._01_Stacks_and_queues._01_Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _01_Browser_History {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<String> stack = new ArrayDeque<>();

        String command = scan.nextLine();
        while (!command.equals("Home")) {

            if (!command.equals("back")) {
                stack.push(command);
                System.out.println(command);
            } else {
                if (stack.size() <= 1) {
                    System.out.println("no previous URLs");
                } else {
                    stack.pop();
                    System.out.println(stack.peek());
                }
            }
            command = scan.nextLine();
        }

    }
}
