package Java_Advanced_May_2024._10_Java_Advanced_Exams._13_Java_Advanced_Regular_Exam_25_June_2022;

import java.util.Scanner;

public class _02_Sticky_Fingers {
    public static int[] getInitialPositions(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j].equals("D")) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0, 0};
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String[] listOfDirections = scan.nextLine().split(",");

        String[][] matrix = new String[n][n];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scan.nextLine().split("\\s+");
        }

        int[] initialPositions = getInitialPositions(matrix);
        int positionRow = initialPositions[0];
        int positionCol = initialPositions[1];

        int totalFunds = 0;
        boolean jailed = false;

        for (int i = 0; i < listOfDirections.length; i++) {
            String command = listOfDirections[i];
            switch (command) {
                case "up":
                    if (positionRow - 1 >= 0) {
                        matrix[positionRow][positionCol] = "+";
                        positionRow--;
                    } else {
                        System.out.println("You cannot leave the town, there is police outside!");
                    }
                    break;
                case "down":
                    if (positionRow + 1 < matrix.length) {
                        matrix[positionRow][positionCol] = "+";
                        positionRow++;
                    } else {
                        System.out.println("You cannot leave the town, there is police outside!");
                    }
                    break;
                case "left":
                    if (positionCol - 1 >= 0) {
                        matrix[positionRow][positionCol] = "+";
                        positionCol--;
                    } else {
                        System.out.println("You cannot leave the town, there is police outside!");
                    }
                    break;
                case "right":
                    if (positionCol + 1 < matrix[0].length) {
                        matrix[positionRow][positionCol] = "+";
                        positionCol++;
                    } else {
                        System.out.println("You cannot leave the town, there is police outside!");
                    }
                    break;
            }

            if (matrix[positionRow][positionCol].equals("$")) {
                matrix[positionRow][positionCol] = "+";
                int stolenValue = positionRow * positionCol;
                totalFunds += stolenValue;
                System.out.printf("You successfully stole %d$.%n", stolenValue);

            } else if (matrix[positionRow][positionCol].equals("P")) {
                matrix[positionRow][positionCol] = "#";
                jailed = true;
                System.out.printf("You got caught with %d$, and you are going to jail.%n", totalFunds);
                break;
            }

            // Make last known position his current position "D";
            matrix[positionRow][positionCol] = "D";

        }

        // First Line:
        if (!jailed) {
            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", totalFunds);
        }
        // Second Line:
        for (String[] row : matrix) {
            System.out.println(String.join(" ", row));
        }
    }
}
