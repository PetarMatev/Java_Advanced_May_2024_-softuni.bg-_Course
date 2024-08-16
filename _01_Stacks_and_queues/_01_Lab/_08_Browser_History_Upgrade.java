package Java_Advanced_May_2024._01_Stacks_and_queues._01_Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _08_Browser_History_Upgrade {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<String> queue = new ArrayDeque<>();
        ArrayDeque<String> forwardPages = new ArrayDeque<>();

        String url = scan.nextLine();
        while (!url.equals("Home")) {
            if (url.equals("back")) {
                if (queue.size() <= 1) {
                    System.out.println("no previous URLs");
                } else {
                    forwardPages.addFirst(queue.poll());
                    System.out.println(queue.peek());
                }
            } else if (url.equals("forward")) {
                if (forwardPages.isEmpty()) {
                    System.out.println("no next URLs");
                } else {
                    queue.addFirst(forwardPages.poll());
                    System.out.println(queue.peek());
                }
            } else {
                if (!queue.isEmpty()) {
                    forwardPages.clear(); // Clear forward pages whenever a new URL is accessed after back
                }
                queue.addFirst(url);
                System.out.println(url);
            }
            url = scan.nextLine();
        }
    }
}
