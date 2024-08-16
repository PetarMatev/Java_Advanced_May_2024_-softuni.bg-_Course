package Java_Advanced_May_2024._10_Java_Advanced_Exams._04_Java_Advanced_Regular_Exam_21_October_2023;

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.Stack;

public class _01_OffRoad_Challenge {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] fuelInput = scan.nextLine().split("\\s+");
        String[] consumptionIndexesInput = scan.nextLine().split("\\s+");
        String[] quantitiesInput = scan.nextLine().split("\\s+");

        Stack<Integer> fuel = new Stack<>(); // take the last fuel quantity
        ArrayDeque<Integer> consumptionIndex = new ArrayDeque<>(); // take the first index
        ArrayDeque<Integer> quantities = new ArrayDeque<>(); // take the first element

        for (String s : fuelInput) {
            fuel.push(Integer.parseInt(s));
        }

        for (String x : consumptionIndexesInput) {
            consumptionIndex.offer(Integer.parseInt(x));
        }

        for (String z : quantitiesInput) {
            quantities.offer(Integer.parseInt(z));
        }


        int altitudes = 0;
        boolean hasNotReachedTheTop = false;

        while(!fuel.isEmpty() && !consumptionIndex.isEmpty() && !quantities.isEmpty()) {

            int fuelAmount = fuel.pop();
            int index = consumptionIndex.poll();
            int neededAmountOFFuel = quantities.poll();
            int result = fuelAmount - index;

            if (result >= neededAmountOFFuel) {
                altitudes ++;
                System.out.printf("John has reached: Altitude %d%n", altitudes);
            } else {
                System.out.printf("John did not reach: Altitude %d%n", altitudes + 1);
                hasNotReachedTheTop = true;
                break;
            }
        }


    if (!hasNotReachedTheTop) {
        System.out.println("John has reached all the altitudes and managed to reach the top!");
    } else {
        System.out.println("John failed to reach the top.");
        if (altitudes != 0) {
            System.out.print("Reached altitudes: ");
            for (int i=1; i <= altitudes; i++) {
                if (i < altitudes) {
                    System.out.printf("Altitude %d, ", i);
                } else {
                    System.out.printf("Altitude %d", i);
                }
            }
        } else {
            System.out.println("John didn't reach any altitude.");
        }
    }
    }
}
