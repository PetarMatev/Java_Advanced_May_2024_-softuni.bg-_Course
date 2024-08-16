package Java_Advanced_May_2024._10_Java_Advanced_Exams._02_Java_Advanced_Regular_Exam_17_February_2024;

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.Stack;

public class _01_Chicken_Snack {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] line = scan.nextLine().split("\\s+");
        Stack<Integer> money = new Stack<>();
        for (String amount : line) {
            money.push(Integer.parseInt(amount));
        }

        String[] linePrices = scan.nextLine().split("\\s+");
        ArrayDeque<Integer> prices = new ArrayDeque<>();
        for (String givenPrice : linePrices) {
            prices.offer(Integer.parseInt(givenPrice));
        }


        int eatenFoods = 0;
        while(!money.isEmpty() && !prices.isEmpty()) {
            int currentAmount = money.pop();
            int currentPrice = prices.poll();
            if (currentAmount == currentPrice) {
                eatenFoods++;
            } else if (currentAmount > currentPrice) {
                int difference = currentAmount - currentPrice;
                if (!money.isEmpty()) {
                    money.push(money.pop() + difference);
                } else {
                    money.push(difference);
                }

                eatenFoods++;
            }
        }

        if (eatenFoods >= 4) {
            System.out.printf("Gluttony of the day! Henry ate %d foods.", eatenFoods);
        } else {
            if (eatenFoods == 0) {
                System.out.println("Henry remained hungry. He will try next weekend again.");
            } else if (eatenFoods == 1) {
                System.out.println("Henry ate: 1 food.");
            } else {
                System.out.printf("Henry ate: %d foods.", eatenFoods);
            }
        }


    }
}
