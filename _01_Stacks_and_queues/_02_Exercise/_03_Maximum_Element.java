package Java_Advanced_May_2024._01_Stacks_and_queues._02_Exercise;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class _03_Maximum_Element {

    public static Integer getMax(ArrayDeque<Integer> stack) {
        int maxNum = Integer.MIN_VALUE;
        ArrayDeque<Integer> temp = new ArrayDeque<>();

        while(!stack.isEmpty()) {
            int current = stack.pop();
            temp.push(current);

            if (current > maxNum) {
                maxNum = current;
            }
        }

        while(!temp.isEmpty()) {
            stack.push(temp.pop());
        }

        return maxNum;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numCommands = Integer.parseInt(scan.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < numCommands; i++) {

            String command = scan.nextLine();
            int sizeOfCommand = command.length();

            if (sizeOfCommand == 1) {
                int commandNum = Integer.parseInt(command);
                if (commandNum == 2) {
                    stack.pop();
                } else {
                    System.out.println(getMax(stack));
                }

            } else {
                int itemToAdd = Integer.parseInt(command.split(" ")[1]);
                stack.push(itemToAdd);
            }
        }
    }
}
