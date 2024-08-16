package Java_Advanced_May_2024._10_Java_Advanced_Exams._07_Java_Advance_Retake_Exam_12_April_2023;

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.Stack;

public class _01_Rubber_Duck_Debuggers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] timeInput = scan.nextLine().split("\\s+");
        String[] taskInput = scan.nextLine().split("\\s+");

        ArrayDeque<Integer> time = new ArrayDeque<>();
        Stack<Integer> tasks = new Stack<>();

        for (String s : timeInput) {
            time.offer(Integer.parseInt(s));
        }

        for (String x : taskInput) {
            tasks.push(Integer.parseInt(x));
        }

        int DarthVaderDucky = 0;
        int ThorDucky = 0;
        int BigBlueRubberDucky = 0;
        int SmallYellowRubberDucky = 0;


        while (!time.isEmpty() && !tasks.isEmpty()) {

            int firsTime = time.poll();
            int lastTask = tasks.pop();

            int result = firsTime * lastTask;

            if (result <= 60) {
                DarthVaderDucky++;
            } else if (result <= 120) {
                ThorDucky++;
            } else if (result <= 180) {
                BigBlueRubberDucky++;
            } else if (result <= 240) {
                SmallYellowRubberDucky++;
            } else {

                if (lastTask - 2 > 0) {
                    tasks.push(lastTask - 2);
                }
                time.offer(firsTime);
            }
        }

        System.out.println("Congratulations, all tasks have been completed! Rubber ducks rewarded:");
        System.out.printf("Darth Vader Ducky: %d%n", DarthVaderDucky);
        System.out.printf("Thor Ducky: %d%n", ThorDucky);
        System.out.printf("Big Blue Rubber Ducky: %d%n", BigBlueRubberDucky);
        System.out.printf("Small Yellow Rubber Ducky: %d", SmallYellowRubberDucky);
    }
}
