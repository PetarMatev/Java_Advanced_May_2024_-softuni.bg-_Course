package Java_Advanced_May_2024._01_Stacks_and_queues._01_Lab;

import java.util.*;

public class _06_Hot_Potato {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] names = scan.nextLine().split(" ");
        ArrayDeque<String> queue = new ArrayDeque<>();
        Collections.addAll(queue, names);
        int num = Integer.parseInt(scan.nextLine());

        while (queue.size() > 1) {
            // Pass the potato by removing and adding the child at the front of the queue
            for (int i = 1; i < num; i++) {
                String name = queue.poll();
                queue.offer(name);
            }
            // remove the first element from the queue (the element at position 0).
            String nameToRemove = queue.poll();
            System.out.println("Removed " + nameToRemove);
        }

        System.out.println("Last is " + queue.poll());
    }
}



