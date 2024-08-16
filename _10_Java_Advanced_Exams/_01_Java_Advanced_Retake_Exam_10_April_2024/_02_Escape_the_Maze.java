package Java_Advanced_May_2024._10_Java_Advanced_Exams._01_Java_Advanced_Retake_Exam_10_April_2024;

import java.util.Scanner;

public class _02_Escape_the_Maze {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        int health = 100;

        String[][] matrix = new String[n][n];
        for (int i = 0; i < n; i++) {
            matrix[i] = scan.nextLine().split("");
        }

        String startingPosition = "P";
        String monster = "M";
        String healthPotion = "H";
        String exit = "X";

        boolean defeated = false;
        boolean exitFound = false;

        // Finding the starting position and keeping position Row and position Col.
        int positionRow = 0;
        int positionCol = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col].equals(startingPosition)) {
                    positionRow = row;
                    positionCol = col;
                }
            }
        }

        while (true) {
            String command = scan.nextLine();
            if (command.equals("up")) {
                if (positionRow - 1 >= 0) {
                    matrix[positionRow][positionCol] = "-";
                    positionRow--;
                }
            } else if (command.equals("down")) {
                if (positionRow + 1 < matrix.length) {
                    matrix[positionRow][positionCol] = "-";
                    positionRow++;
                }
            } else if (command.equals("left")) {
                if (positionCol - 1 >= 0) {
                    matrix[positionRow][positionCol] = "-";
                    positionCol--;
                }
            } else if (command.equals("right")) {
                if (positionCol + 1 < matrix[0].length) {
                    matrix[positionRow][positionCol] = "-";
                    positionCol++;
                }
            }

            if (matrix[positionRow][positionCol].equals(monster)) {
                health -= 40;
                if (health <= 0) {
                    health = 0;
                    defeated = true;
                    matrix[positionRow][positionCol] = "P";
                }
            } else if (matrix[positionRow][positionCol].equals(healthPotion)) {
                health += 15;
                if (health > 100) {
                    health = 100;
                }
            } else if (matrix[positionRow][positionCol].equals(exit)) {
                matrix[positionRow][positionCol] = "P";
                exitFound = true;
            }

            if (defeated || exitFound) {
                break;
            }
            matrix[positionRow][positionCol] = "-";
        }

        if (defeated) {
            System.out.println("Player is dead. Maze over!");
            System.out.printf("Player's health: %d units%n", health);
        }

        if (exitFound) {
            System.out.println("Player escaped the maze. Danger passed!");
            System.out.printf("Player's health: %d units%n", health);
        }

        for (String[] strings : matrix) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }
    }
}
