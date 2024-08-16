package Java_Advanced_May_2024._10_Java_Advanced_Exams._07_Java_Advance_Retake_Exam_12_April_2023;

import java.util.Scanner;

public class _02_The_Squirrel {

    public static int[] getInitialPositions(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j].equals("s")) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0, 0};
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int hazelnuts = 0;
        int n = Integer.parseInt(scan.nextLine());
        String[] instructions = scan.nextLine().split(", ");

        String[][] matrix = new String[n][n];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scan.nextLine().split("");
        }

        int[] initialPositions = getInitialPositions(matrix);
        int positionRow = initialPositions[0];
        int positionCol = initialPositions[1];

        boolean success = false;
        boolean defeat = false;

        for (int i = 0; i < instructions.length; i++) {
            String command = instructions[i];
            switch (command) {
                case "up":
                    positionRow--;
                    break;
                case "down":
                    positionRow++;
                    break;
                case "left":
                    positionCol--;
                    break;
                case "right":
                    positionCol++;
                    break;
            }
            if (positionRow < 0 || positionRow >= matrix.length || positionCol < 0 || positionCol >= matrix[0].length) {
                System.out.println("The squirrel is out of the field.");
                defeat = true;
                break;
            }
            if (matrix[positionRow][positionCol].equals("t")) {
                System.out.println("Unfortunately, the squirrel stepped on a trap...");
                defeat = true;
                break;
            }
            if (matrix[positionRow][positionCol].equals("h")) {
                hazelnuts++;
                matrix[positionRow][positionCol] = "*";

                if (hazelnuts == 3) {
                    System.out.println("Good job! You have collected all hazelnuts!");
                    success = true;
                    break;
                }
            }
        }
        if (!defeat && !success) {
            System.out.println("There are more hazelnuts to collect.");
        }
        System.out.printf("Hazelnuts collected: %d", hazelnuts);
    }
}
