package Java_Advanced_May_2024._01_Stacks_and_queues._02_Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _07_Simple_Text_Editor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<String> stack = new ArrayDeque<>();
        int num = Integer.parseInt(scan.nextLine());
        ArrayDeque<String> instructions = new ArrayDeque<>();
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < num; i++) {
            String rowCommand = scan.nextLine();
            String[] command = rowCommand.split(" ");
            int instruction = Integer.parseInt(command[0]);
            if (instruction == 1) {
                String textToAmend = command[1];
                text.append(textToAmend);
                stack.push(rowCommand);
                instructions.push(textToAmend);
            } else if (instruction == 2) {
                int numsToErase = Integer.parseInt(command[1]);
                String subText = text.substring(text.length() - numsToErase, text.length());
                text.replace(text.length() - numsToErase, text.length(), "");
                stack.push(rowCommand);
                instructions.push(subText);
            } else if (instruction == 3) {
                int index = Integer.parseInt(command[1]) - 1;
                System.out.println(text.toString().charAt(index));
            } else if (instruction == 4) {
                String[] poppedCommand = stack.pop().split(" ");
                int inst = Integer.parseInt(poppedCommand[0]);

                if (inst == 1) {
                    int numsTormove = instructions.pop().length();
                    text.replace(text.length() - numsTormove, text.length(), "");
                } else if (inst == 2) {
                    text.append(instructions.pop());
                }
            }
        }
    }
}