package Java_Advanced_May_2024._10_Java_Advanced_Exams._14_Java_Advanced_Retake_Exam_15_December_2021;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _01_Meeting {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] maleInput = scan.nextLine().split("\\s+");
        String[] femaleInput = scan.nextLine().split("\\s+");

        ArrayDeque<Integer> maleStack = new ArrayDeque<>(); // start from the last // Last-in-First-Out
        ArrayDeque<Integer> femaleQueue = new ArrayDeque<>();// start from the first // First-in-First-Out //

        for (String s : maleInput) {
            maleStack.push(Integer.parseInt(s));
        }

        for (String s : femaleInput) {
            femaleQueue.offer(Integer.parseInt(s));
        }

        int matches = 0;
        while (!maleStack.isEmpty() && !femaleQueue.isEmpty()) {
            Integer firstMale = maleStack.peek();
            if (firstMale <= 0) {
                maleStack.pop();
                continue;
            }

            Integer firstFemale = femaleQueue.peek();
            if (firstFemale <= 0) {
                femaleQueue.poll();
                continue;
            }

            if (firstMale % 25 == 0) {
                maleStack.pop();
                maleStack.pop();
                continue;
            }

            if (firstFemale % 25 == 0) {
                femaleQueue.poll();
                femaleQueue.poll();
                continue;
            }

            if (firstMale - firstFemale != 0) {
                maleStack.push(maleStack.pop() - 2);
                femaleQueue.poll();
            } else {
                maleStack.pop();
                femaleQueue.poll();
                matches++;
            }
        }

        // First Line Output:
        System.out.printf("Matches: %d%n", matches);
        // Second Line Output:
        if (!maleStack.isEmpty()) {
            System.out.printf("Males left: ");
            System.out.println(maleStack.toString().replaceAll("[\\[|\\]]", ""));
        } else {
            System.out.println("Males left: none");
        }
        // Third Line Output:
        if (!femaleQueue.isEmpty()) {
            System.out.printf("Females left: ");
            System.out.println(femaleQueue.toString().replaceAll("[\\[|\\]]", ""));
        } else {
            System.out.println("Females left: none");
        }
    }
}
