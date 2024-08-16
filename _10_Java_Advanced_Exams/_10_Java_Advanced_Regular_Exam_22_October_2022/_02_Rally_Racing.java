package Java_Advanced_May_2024._10_Java_Advanced_Exams._10_Java_Advanced_Regular_Exam_22_October_2022;

import java.util.Scanner;

public class _02_Rally_Racing {

    public static int[] returnSecondTunnelCoordinates(String[][] matrix, int row, int col) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j].equals("T")) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[] {0, 0};
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String racingNumber = scan.nextLine(); // number to be printed out as a String...

        String[][] matrix = new String[n][n];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scan.nextLine().split("\\s+");
        }

        int positionRow = 0;
        int positionCol = 0;

        int totalKM = 0;
        boolean raceIsCompleted = false;

        String command = scan.nextLine();
        while (!command.equals("End")) {
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
            totalKM += 10;
            if (matrix[positionRow][positionCol].equals("T")) {
                totalKM += 20;
                matrix[positionRow][positionCol] = "."; // mark Initial Tunnel point with "."
                int[] newCoordinates = returnSecondTunnelCoordinates(matrix, positionRow, positionCol);
                positionRow = newCoordinates[0];
                positionCol = newCoordinates[1];
                matrix[positionRow][positionCol] = "."; // mark the initials of second Tunnel with "."
            } else if (matrix[positionRow][positionCol].equals("F")) {
                matrix[positionRow][positionCol] = "C";
                raceIsCompleted = true;
                break;
            }
            command = scan.nextLine();
        }

        // First Print Sentence:
        if (raceIsCompleted) {
            System.out.printf("Racing car %s finished the stage!\n", racingNumber);
        } else {
            matrix[positionRow][positionCol] = "C";
            System.out.printf("Racing car %s DNF.\n", racingNumber);
        }
        // Second Print Sentence:
        System.out.printf("Distance covered %d km.\n", totalKM);
        for (String[] row : matrix) {
            System.out.println(String.join("", row));
        }
    }
}

