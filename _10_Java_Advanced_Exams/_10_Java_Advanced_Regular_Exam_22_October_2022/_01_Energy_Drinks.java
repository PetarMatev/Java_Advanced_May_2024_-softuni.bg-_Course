package Java_Advanced_May_2024._10_Java_Advanced_Exams._10_Java_Advanced_Regular_Exam_22_October_2022;

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.Stack;

public class _01_Energy_Drinks {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] milligramsOfCaffeineInput = scan.nextLine().split(",\\s+");
        String[] energyDrinksInput = scan.nextLine().split(",\\s+");

        Stack<Integer> milligramsOfCaffeine = new Stack<>();
        ArrayDeque<Integer> energyDrinks = new ArrayDeque<>();

        for (String s : milligramsOfCaffeineInput) {
            milligramsOfCaffeine.push(Integer.parseInt(s));
        }

        for (String s : energyDrinksInput) {
            energyDrinks.offer(Integer.parseInt(s));
        }

        int totalCaffeine = 0;
        while (!milligramsOfCaffeine.isEmpty() && !energyDrinks.isEmpty()) {
            int milligram = milligramsOfCaffeine.pop();
            int energyDrink = energyDrinks.poll();
            int result = milligram * energyDrink;
            if (totalCaffeine <= 300) {
                if (totalCaffeine + result <= 300) {
                    totalCaffeine += result;
                } else {
                    energyDrinks.offer(energyDrink);
                    if (totalCaffeine - 30 >= 0) {
                        totalCaffeine -= 30;
                    }
                }
            }
        }

        if (!energyDrinks.isEmpty()) {
            System.out.println("Drinks left: " + energyDrinks.toString().replaceAll("[\\[\\]]", ""));
        } else {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        }

        System.out.printf("Stamat is going to sleep with %d mg caffeine.", totalCaffeine);

    }
}
