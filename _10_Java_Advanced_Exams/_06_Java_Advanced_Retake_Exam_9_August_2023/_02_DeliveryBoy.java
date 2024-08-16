package Java_Advanced_May_2024._10_Java_Advanced_Exams._06_Java_Advanced_Retake_Exam_9_August_2023;

import java.util.Scanner;

public class _02_DeliveryBoy {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] numsInput = scan.nextLine().split("\\s+");
        int rows = Integer.parseInt(numsInput[0]);
        int cols = Integer.parseInt(numsInput[1]);
        String[][] matrix = new String[rows][cols];
        int initialPositionRow = -1;
        int initialPositionCol = -1;
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scan.nextLine().split("");
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j].equals("B")) {
                    initialPositionRow = i;
                    initialPositionCol = j;
                }
            }
        }

        boolean lateForDelivery = false;
        boolean pizzaIsDelivered = false;

        int currentRow = initialPositionRow;
        int currentCol = initialPositionCol;

        int previousRow = -1;
        int previousCol = -1;


        while (true) {
            String command = scan.nextLine();
            previousRow = currentRow;
            previousCol = currentCol;
            switch (command) {
                case "up":
                    currentRow--;
                    break;
                case "down":
                    currentRow++;
                    break;
                case "left":
                    currentCol--;
                    break;
                case "right":
                    currentCol++;
                    break;
            }


            // we check if we are out of the matrix and cancel the order if so and we mark initial position with " ";
            if (currentRow < 0 || currentRow >= matrix.length || currentCol < 0 || currentCol >= matrix[0].length) {
                lateForDelivery = true;
                matrix[initialPositionRow][initialPositionCol] = " ";
                System.out.println("The delivery is late. Order is canceled.");
                break;
            }

            // if we step on field marked with "*" then we cannot step here and revert previous move by using previous;
            if (matrix[currentRow][currentCol].equals("*")) {
                currentRow = previousRow;
                currentCol = previousCol;
            }

            // if we reach the Pizza Restaurant marked with "P" then we mark it with "R"
            if (matrix[currentRow][currentCol].equals("P")) {
                matrix[currentRow][currentCol] = "R";
                System.out.println("Pizza is collected. 10 minutes for delivery.");
            }

            // if he reaches the Address marked with "A" the pizza is delivered and we mark it with "P"
            if (matrix[currentRow][currentCol].equals("A")) {
                pizzaIsDelivered = true;
                matrix[currentRow][currentCol] = "P";
                System.out.println("Pizza is delivered on time! Next order...");
                break;
            }

            // if steps out on field marked with "-" we make this into "."
            if (matrix[currentRow][currentCol].equals("-")) {
                matrix[currentRow][currentCol] = ".";
            }
        }

        // printing out final result;
        for (String[] row : matrix) {
            System.out.println(String.join("", row));
        }
    }
}
