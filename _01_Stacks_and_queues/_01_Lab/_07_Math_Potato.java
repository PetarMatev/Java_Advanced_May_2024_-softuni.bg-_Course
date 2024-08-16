package Java_Advanced_May_2024._01_Stacks_and_queues._01_Lab;

import java.util.Collections;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Scanner;

public class _07_Math_Potato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] names = scanner.nextLine().split(" ");
        int num = Integer.parseInt(scanner.nextLine());
        PriorityQueue<String> mathPotato = new PriorityQueue<>();
        Collections.addAll(mathPotato, names);

        int cycle = 1;

        while (mathPotato.size() > 1) {
            for (int i = 1; i < num; i++) {
                String name = mathPotato.poll();
                mathPotato.offer(name);
            }

            if (isPrime(cycle)) {
                System.out.println("Prime " + mathPotato.peek());
            } else {
                System.out.println("Removed " + mathPotato.poll());
            }
            cycle++;
        }

        System.out.println("Last is " + mathPotato.poll());

    }

    private static boolean isPrime(int cycle) {
        boolean isPrime = true;
        for (int i = 2; i <= cycle - 1; i++) {
            if (cycle % i == 0) {
                isPrime = false;
                break;
            }
        }
        if (cycle == 1) {
            return false;
        }
        return isPrime;
    }

}