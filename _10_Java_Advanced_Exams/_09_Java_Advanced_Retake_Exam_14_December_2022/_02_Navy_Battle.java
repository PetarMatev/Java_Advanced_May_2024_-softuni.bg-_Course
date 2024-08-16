package Java_Advanced_May_2024._10_Java_Advanced_Exams._09_Java_Advanced_Retake_Exam_14_December_2022;

import java.util.Scanner;

public class _02_Navy_Battle {

    public static int[] getInitialPositions(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j].equals("A")) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0, 0};
    }

    public static int[] getTeleport(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j].equals("M")) {
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

        //////////////////////////////////////////////////////////////////////////////////

        int swordsValue = 0;

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

            if (positionRow < 0 || positionRow >= matrix.length || positionCol < 0 || positionCol >= matrix[0].length) {
                break;
            }

            if (matrix[positionRow][positionCol].equals("M")) {
                int[] teleportPartOne = getTeleport(matrix); // get entry
                matrix[teleportPartOne[0]][teleportPartOne[1]] = "-";
                int[] teleportPartTwo = getTeleport(matrix); // get exit
                positionRow = teleportPartTwo[0];
                positionCol = teleportPartTwo[1];
                matrix[positionRow][positionCol] = "A";
            } else if  (matrix[positionRow][positionCol].equals("-")) {
                matrix[positionRow][positionCol] = "A";
            } else {
                swordsValue += Integer.parseInt(matrix[positionRow][positionCol]);
                if (swordsValue >= 65) {
                    matrix[positionRow][positionCol] = "A";
                    break;
                } else {
                    matrix[positionRow][positionCol] = "-";
                }
            }

        }

        // First Line:
        if (swordsValue < 65) {
            System.out.println("I do not need more swords!");
        } else {
            System.out.println("Very nice swords, I will come back for more!");
        }

        // Second Line:
        System.out.printf("The king paid %d gold coins.%n", swordsValue);
        for (String[] row : matrix) {
            System.out.println(String.join("", row));
        }
    }
}