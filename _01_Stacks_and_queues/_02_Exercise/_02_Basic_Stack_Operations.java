package Java_Advanced_May_2024._01_Stacks_and_queues._02_Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _02_Basic_Stack_Operations {

    public static String getMin(ArrayDeque<String> stack) {
        ArrayDeque<String> temp_queue = new ArrayDeque<>();
        int min_Value = Integer.MAX_VALUE;
        while(!stack.isEmpty()) {
            int current = Integer.parseInt((stack.pop()));
            min_Value = Math.min(min_Value, current);
            temp_queue.push(String.valueOf(current));
        }
        while(!temp_queue.isEmpty()) {
            stack.push(temp_queue.pop());
        }
        return String.valueOf(min_Value);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] conditions = scan.nextLine().split("\\s+");
        int numN = Integer.parseInt(conditions[0]);
        int numS = Integer.parseInt(conditions[1]);
        String numX = conditions[2];
        String[] nums = scan.nextLine().split("\\s+");
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < numN; i++) {
            stack.push(nums[i]);
        }

        for (int i = 0; i < numS; i++) {
            stack.pop();
        }

        if (stack.isEmpty()) {
            System.out.println(0);

        if (!stack.contains(numX)) {
            System.out.println(getMin(stack));

        } else
            System.out.println("true");
        }

    }


}
