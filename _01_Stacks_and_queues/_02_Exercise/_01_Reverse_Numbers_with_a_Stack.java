package Java_Advanced_May_2024._01_Stacks_and_queues._02_Exercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class _01_Reverse_Numbers_with_a_Stack {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<String> stack = new ArrayDeque<>();
        String[] nums = scan.nextLine().split("\\s+");
        for (String num : nums) {
            String currentNum = num;
            stack.push(currentNum);
        }
        StringBuilder newString = new StringBuilder();

        for(String item : stack) {
            String currentItem = stack.pop();
            newString.append(currentItem).append(" ");
        }

        System.out.println(newString.toString());
    }
}
