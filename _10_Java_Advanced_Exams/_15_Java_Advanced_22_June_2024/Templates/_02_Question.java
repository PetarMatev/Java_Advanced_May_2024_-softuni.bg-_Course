package Java_Advanced_May_2024._10_Java_Advanced_Exams._15_Java_Advanced_22_June_2024.Templates;

import java.util.Scanner;

public class _02_Question {


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
        int n = Integer.parseInt(scan.nextLine());

        String[][] matrix = new String[n][n];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scan.nextLine().split("");
        }

        int[] initialPositions = getInitialPositions(matrix);
        int positionRow = initialPositions[0];
        int positionCol = initialPositions[1];

        int unitsOfEnergy = 15;
        int totalUnitsCollected = 0;

        boolean lastChanceToSriverive = true;
        boolean hiveIsReached = false;

        while (true) {
            String command = scan.nextLine();
            matrix[positionRow][positionCol] = "-";
            unitsOfEnergy--; // With each move, the bee's energy decreases by 1 unit.
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

            if (positionRow < 0) {
                positionRow = matrix.length - 1;
            }

            if (positionRow >= matrix.length) {
                positionRow = 0;
            }

            if (positionCol < 0) {
                positionCol = matrix[0].length - 1;
            }

            if (positionCol >= matrix[0].length) {
                positionCol = 0;
            }

            if (matrix[positionRow][positionCol].equals("-")) {
                matrix[positionRow][positionCol] = "B";
            } else if (matrix[positionRow][positionCol].equals("H")) {
                matrix[positionRow][positionCol] = "B";
                hiveIsReached = true;
                break;
            } else {
                totalUnitsCollected += Integer.parseInt(matrix[positionRow][positionCol]);
                matrix[positionRow][positionCol] = "B";
            }
            if (unitsOfEnergy <= 0) {
                if (totalUnitsCollected < 30) {
                    break;
                } else {
                    if (lastChanceToSriverive) {
                        lastChanceToSriverive = false; // Taken 1 try to restore energy.
                        int difference = totalUnitsCollected - 30;
                        unitsOfEnergy += difference;
                        totalUnitsCollected = totalUnitsCollected - difference;
                    } else {
                        break;
                    }
                }
            }
        }

        // First Line Print:
        if (hiveIsReached) {
            if (totalUnitsCollected >= 30) {
                System.out.printf("Great job, Beesy! The hive is full. Energy left: %d%n", unitsOfEnergy);
            } else {
                System.out.println("Beesy did not manage to collect enough nectar.");
            }
        } else {
            System.out.println("This is the end! Beesy ran out of energy.");
        }
        // Second Line Print:
        matrix[positionRow][positionCol] = "B";
        for (String[] row : matrix) {
            System.out.println(String.join("", row));
        }
    }
}

