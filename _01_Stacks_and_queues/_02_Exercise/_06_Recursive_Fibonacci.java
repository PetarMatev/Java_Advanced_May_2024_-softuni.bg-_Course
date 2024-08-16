package Java_Advanced_May_2024._01_Stacks_and_queues._02_Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _06_Recursive_Fibonacci {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Long> queue = new ArrayDeque<>();
        long num = Integer.parseInt(scan.nextLine());

        if (num == 0 || num == 1) {
            System.out.println(1);
        } else {
            queue.offer(1L);
            queue.offer(1L);

            for (int i = 0; i < num; i++ ) {
                queue.offer(queue.poll() + queue.peek());
            }
            System.out.println(queue.poll());
        }
    }
}
