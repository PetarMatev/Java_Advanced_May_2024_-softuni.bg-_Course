package Java_Advanced_May_2024._10_Java_Advanced_Exams._12_Java_Advanced_Retake_Exam_13_April_2022;

import java.util.Scanner;

public class _02_Armory_Problem {

    public static int[] getInitialPositions(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j].equals("S")) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0, 0};
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        String[][] matrix = new String[n][n];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scan.nextLine().split("");
        }

        int[] initialPositions = getInitialPositions(matrix);
        int positionRow = initialPositions[0];
        int positionCol = initialPositions[1];
        int mineCounter = 0;
        int battleshipCounter = 0;
        while (true) {
            String command = scan.nextLine();
            matrix[positionRow][positionCol] = "-";
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

            if (matrix[positionRow][positionCol].equals("*")) {
                mineCounter++;
                matrix[positionRow][positionCol] = "-";
                if (mineCounter > 2) {
                    System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!\n", positionRow, positionCol);
                    matrix[positionRow][positionCol] = "S";
                    break;
                }
            } else if (matrix[positionRow][positionCol].equals("C")) {
                battleshipCounter++;
                matrix[positionRow][positionCol] = "-";
                if (battleshipCounter == 3) {
                    System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
                    matrix[positionRow][positionCol] = "S";
                    break;
                }
            }
        }

        for (String[] row : matrix) {
            System.out.println(String.join("", row));
        }
    }

}

