package Java_Advanced_May_2024._10_Java_Advanced_Exams._03_Java_Advanced_Retake_Exam_13_December_2023;

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.Stack;

public class _01_Warms_and_Holes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] wormsInput = scan.nextLine().split("\\s+");
        String[] holesInput = scan.nextLine().split("\\s+");

        // start with last worm
        Stack<Integer> worms = new Stack<>();
        for (String s : wormsInput) {
            worms.push(Integer.parseInt(s));
        }
        // start with first hole
        ArrayDeque<Integer> holes = new ArrayDeque<>();
        for (String x : holesInput) {
            holes.offer(Integer.parseInt(x));
        }

        int counter = 0;
        boolean notAllWormsFoundSuitableHoles = false;
        while (!worms.isEmpty() && !holes.isEmpty()) {
            int currentWorm = worms.pop();
            int currentHole = holes.poll();

            if (currentWorm == currentHole) {
                counter++;
            } else {
                if (currentWorm -3 > 0) {
                    worms.push(currentWorm - 3);
                } else {
                    notAllWormsFoundSuitableHoles = true;
                }
            }
        }

        // First Sentence:
        if (counter > 0) {
            System.out.printf("Matches: %d%n", counter);
        } else {
            System.out.println("There are no matches.");
        }
        // Second Sentence:
        if (worms.isEmpty()) {
            if (notAllWormsFoundSuitableHoles) {
                System.out.println("Worms left: none");
            } else {
                System.out.println("Every worm found a suitable hole!");
            }
        } else {
            System.out.println("Worms left: " + worms.toString().replaceAll("[\\[|\\]]", ""));
        }

        // Third Sentence:
        if (holes.isEmpty()) {
            System.out.println("Holes left: none");
        } else {
            System.out.println("Holes left: " + holes.toString().replaceAll("[\\[|\\]]", ""));
        }
    }
}
