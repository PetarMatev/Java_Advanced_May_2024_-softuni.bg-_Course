package Java_Advanced_May_2024._10_Java_Advanced_Exams._01_Java_Advanced_Retake_Exam_10_April_2024;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class _01_Pie_Pursuit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] contestantInput = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> queueOfContestants = new ArrayDeque<>();
        for (Integer item : contestantInput) {
            queueOfContestants.offer(item);
        }

        int[] pieInput = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Stack<Integer> stackOfPies = new Stack<>();
        for (int item : pieInput) {
            stackOfPies.push(item);
        }

        while (!queueOfContestants.isEmpty() && !stackOfPies.isEmpty()) {
            int currentContestant = queueOfContestants.poll();
            int currentPie = stackOfPies.pop();

            int result = currentContestant - currentPie;

            // if contestent survives
            if (result < 0) {
                if (stackOfPies.isEmpty()) {
                    stackOfPies.push(currentPie - currentContestant);
                } else {
                    if (stackOfPies.size() > 1) {
                        stackOfPies.push(stackOfPies.pop() + currentPie - currentContestant);
                    } else {

                    }
                }

            }
            // if pie survive


            if (queueOfContestants.peek() >= stackOfPies.peek()) {
                int contestantRemainingCapacity = queueOfContestants.peek() - stackOfPies.peek();
                stackOfPies.pop();
                if (contestantRemainingCapacity == 0) {
                    queueOfContestants.poll();
                } else {
                    queueOfContestants.poll();
                    queueOfContestants.offer(contestantRemainingCapacity);
                }
            } else {
                int remainingPieces = stackOfPies.peek() - queueOfContestants.peek();
                if (remainingPieces > 1) {
                    stackOfPies.pop();
                    stackOfPies.push(remainingPieces);
                } else {
                    if (stackOfPies.size() > 1) {
                        stackOfPies.pop();
                        stackOfPies.push(stackOfPies.pop() + 1);
                    } else {
                        stackOfPies.pop();
                        stackOfPies.push(remainingPieces);
                    }
                }
                queueOfContestants.poll();
            }
        }

        if (queueOfContestants.isEmpty() && stackOfPies.isEmpty()) {
            System.out.println("We have a champion!");
        } else {
            if (stackOfPies.isEmpty()) {
                System.out.println("We will have to wait for more pies to be baked!");
                System.out.print("Contestants left: " + queueOfContestants.toString().replaceAll("[\\[||\\]]", ""));
            } else {
                System.out.println("Our contestants need to rest!");
                System.out.println("Pies left: " + stackOfPies.toString().replaceAll("[\\[||\\]]", ""));
            }
        }
    }
}
