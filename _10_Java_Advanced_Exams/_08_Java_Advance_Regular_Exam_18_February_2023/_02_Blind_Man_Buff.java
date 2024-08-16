package Java_Advanced_May_2024._10_Java_Advanced_Exams._08_Java_Advance_Regular_Exam_18_February_2023;

import java.util.Scanner;

public class _02_Blind_Man_Buff {

    public static int[] getInitialPositions(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j].equals("B")) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0, 0};
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] nums = scan.nextLine().split("\\s+");
        int row = Integer.parseInt(nums[0]);
        int col = Integer.parseInt(nums[1]);

        String[][] matrix = new String[row][col];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scan.nextLine().split("\\s+");
        }

        int[] initialPositions = getInitialPositions(matrix);
        int positionRow = initialPositions[0];
        int positionCol = initialPositions[1];

        int moveCounter = 0;
        int playersTouched = 0;

        String command = scan.nextLine();
        while (!command.equals("Finish")) {

            switch (command) {
                case "up":
                    if (positionRow - 1 >= 0 && !matrix[positionRow - 1][positionCol].equals("O")) {
                        // mark the current position "-"
                        matrix[positionRow][positionCol] = "-";
                        positionRow--;
                    }
                    break;
                case "down":
                    if (positionRow + 1 < matrix.length && !matrix[positionRow + 1][positionCol].equals("O")) {
                        // mark the current position "-"
                        matrix[positionRow][positionCol] = "-";
                        positionRow++;
                    }
                    break;
                case "left":
                    if (positionCol - 1 >= 0 && !matrix[positionRow][positionCol - 1].equals("O")) {
                        // mark the current position "-"
                        matrix[positionRow][positionCol] = "-";
                        positionCol--;
                    }
                    break;
                case "right":
                    if (positionCol + 1 < matrix[0].length && !matrix[positionRow][positionCol + 1].equals("O")) {
                        // mark the current position "-"
                        matrix[positionRow][positionCol] = "-";
                        positionCol++;
                    }
                    break;
            }

            if (matrix[positionRow][positionCol].equals("P")) {
                moveCounter++;
                playersTouched++;
                matrix[positionRow][positionCol] = "-";
                // mark the current position "B"
                matrix[positionRow][positionCol] = "B";
                if (playersTouched == 3) {
                    break;
                }
            } else if (matrix[positionRow][positionCol].equals("-")) {
                moveCounter++;
                // mark the current position "B"
                matrix[positionRow][positionCol] = "B";
            }

            command = scan.nextLine();
        }

        System.out.println("Game over!");
        System.out.printf("Touched opponents: %d Moves made: %d", playersTouched, moveCounter);
    }
}
