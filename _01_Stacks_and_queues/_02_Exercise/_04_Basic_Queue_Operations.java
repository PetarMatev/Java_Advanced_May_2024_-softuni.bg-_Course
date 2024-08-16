package Java_Advanced_May_2024._01_Stacks_and_queues._02_Exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class _04_Basic_Queue_Operations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Integer[] nums = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        String[] values = scan.nextLine().split(" ");
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for (int i=0; i < nums[0]; i++) {
            deque.offer(Integer.parseInt(values[i]));
        }

        for (int i=0; i < nums[1]; i++) {
            deque.poll();
        }


        if (deque.isEmpty()) {
            System.out.println(0);
        } else {
            if (deque.contains(nums[2])) {
                System.out.println(true);
            } else {
                int min_Value = Integer.MAX_VALUE;
                for (Integer item : deque) {
                    int NextItem = deque.poll();
                    if ( NextItem< min_Value) {
                        min_Value = NextItem;
                    }
                }
                System.out.println(min_Value);
            }
        }
    }
}
