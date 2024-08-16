package Java_Advanced_May_2024._10_Java_Advanced_Exams._06_Java_Advanced_Retake_Exam_9_August_2023;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class _01_Monster_Extermination {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] monstersInput = scan.nextLine().split(",");
        String[] soldersInput = scan.nextLine().split(",");

        ArrayDeque<Integer> monsters = new ArrayDeque<>();
        Stack<Integer> solders = new Stack<>();

        Arrays.stream(monstersInput).mapToInt(Integer::parseInt).forEach(monsters::offer);
        Arrays.stream(soldersInput).mapToInt(Integer::parseInt).forEach(solders::push);

        int killedMonsters = 0;
        while (!monsters.isEmpty() && !solders.isEmpty()) {
            int armour = monsters.poll();
            int attack = solders.pop();

            if (attack >= armour) {
                killedMonsters++;
                int difference = attack - armour;

                if (difference > 0) {
                    if (!solders.isEmpty()) {
                        solders.push(solders.pop() + difference);
                    } else {
                        solders.push(difference);
                    }
                }
            } else {
                monsters.offer(armour - attack);
            }
        }
        if (monsters.isEmpty()) {
            System.out.println("All monsters have been killed!");
        }
        if (solders.isEmpty()) {
            System.out.println("The soldier has been defeated.");
        }
        System.out.printf("Total monsters killed: %d", killedMonsters);
    }
}
