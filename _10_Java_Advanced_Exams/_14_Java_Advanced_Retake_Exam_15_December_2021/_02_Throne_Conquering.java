package Java_Advanced_May_2024._10_Java_Advanced_Exams._14_Java_Advanced_Retake_Exam_15_December_2021;

import java.util.Scanner;

public class _02_Throne_Conquering {

    public static int[] getInitialPositions(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j].equals("P")) {
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
        int energy = Integer.parseInt(scan.nextLine());
        int n = Integer.parseInt(scan.nextLine());

        String[][] matrix = new String[n][];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scan.nextLine().split("");
        }

        int[] initialPositions = getInitialPositions(matrix);
        int positionRow = initialPositions[0];
        int positionCol = initialPositions[1];

        boolean parisDied = false;

        while (true) {
            String[] info = scan.nextLine().split("\\s+");
            String command = info[0];

            int spawsRow = Integer.parseInt(info[1]);
            int spawsCol = Integer.parseInt(info[2]);
            matrix[spawsRow][spawsCol] = "S";
            switch (command) {
                case "up":
                    if (positionRow - 1 >= 0) {
                        matrix[positionRow][positionCol] = "-";
                        positionRow--;
                    }
                    break;
                case "down":
                    if (positionRow + 1 < matrix.length) {
                        matrix[positionRow][positionCol] = "-";
                        positionRow++;
                    }
                    break;
                case "left":
                    if (positionCol - 1 >= 0) {
                        matrix[positionRow][positionCol] = "-";
                        positionCol--;
                    }
                    break;
                case "right":
                    if (positionCol + 1 < matrix[0].length) {
                        matrix[positionRow][positionCol] = "-";
                        positionCol++;
                    }
                    break;
            }
            energy--;

            if (matrix[positionRow][positionCol].equals("H")) {
                matrix[positionRow][positionCol] = "-";
                break;
            } else if (matrix[positionRow][positionCol].equals("S")) {
                energy -= 2;
                if (energy > 0) {
                    matrix[positionRow][positionCol] = "-";
                } else {
                    matrix[positionRow][positionCol] = "X";
                    parisDied = true;
                    break;
                }
            } else {
                if (energy <= 0) {
                    matrix[positionRow][positionCol] = "X";
                    parisDied = true;
                    break;
                }
            }
        }

        if (parisDied) {
            System.out.printf("Paris died at %d;%d.%n", positionRow, positionCol);
        } else {
            System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n", energy);
        }
        for (String[] row : matrix) {
            System.out.println(String.join("", row));
        }
    }
}
