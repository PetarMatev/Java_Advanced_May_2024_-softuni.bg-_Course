package Java_Advanced_May_2024._10_Java_Advanced_Exams._05_Java_Advanced_Regular_Exam_17_June_2023;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class _01_TempleOfDoomAuthor {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] toolsInput = scan.nextLine().split("\\s+");
        String[] substancesInput = scan.nextLine().split("\\s+");
        String[] challengesInput = scan.nextLine().split("\\s+");

        ArrayDeque<Integer> tools = new ArrayDeque<>();
        Stack<Integer> substances = new Stack<>();
        ArrayDeque<Integer> challenges = new ArrayDeque<>();

        for (String s : toolsInput) {
            tools.offer(Integer.parseInt(s));
        }

        for (String x : substancesInput) {
            substances.push(Integer.parseInt(x));
        }

        for (String z : challengesInput) {
            challenges.offer(Integer.parseInt(z));
        }

        while(!tools.isEmpty() && !substances.isEmpty() && !challenges.isEmpty()) {

            int currentTool = tools.poll();
            int currentSubstance = substances.pop();

            int result = currentTool * currentSubstance;

            if (challenges.contains(result)) {
                challenges.remove(result);
            } else {
                tools.offer(currentTool + 1);
                if (currentSubstance - 1 > 0) {
                    substances.push(currentSubstance - 1);
                }
            }
        }

        if (challenges.isEmpty()) {
            System.out.println("Harry found an ostracon, which is dated to the 6th century BCE.");
        } else {
            System.out.println("Harry is lost in the temple. Oblivion awaits him.");
        }

        if (!tools.isEmpty()){
            System.out.println("Tools: " + tools.toString().replaceAll("\\[|\\]", ""));
        }
        if (!substances.isEmpty()){
            System.out.println("Substances: " + substances.toString().replaceAll("\\[|\\]", ""));
        }
        if (!challenges.isEmpty()) {
            System.out.println("Challenges: " + challenges.toString().replaceAll("\\[|\\]", ""));
        }
    }
}
