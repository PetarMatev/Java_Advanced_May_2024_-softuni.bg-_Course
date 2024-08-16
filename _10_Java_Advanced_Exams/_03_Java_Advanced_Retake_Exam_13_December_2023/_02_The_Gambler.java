package Java_Advanced_May_2024._10_Java_Advanced_Exams._03_Java_Advanced_Retake_Exam_13_December_2023;

import java.util.Scanner;

public class _02_The_Gambler {

    public static int[] matrixMovement(String command, char[][] matrix, int positionRow, int positionCol) {
        matrix[positionRow][positionCol] = '-';
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
        return new int[]{positionRow, positionCol};
    }


    public static int[] getPositions(char[][] matrix) {
        int[] positions = new int[2];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j]=='G') {
                    positions[0] = i;
                    positions[1] = j;
                    return positions;
                }
            }
        }
        return new int[]{0, 0};
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int funds = 100;
        char[][] matrix = new char[n][n];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scan.nextLine().toCharArray();
        }
        int[] positions = getPositions(matrix);
        int positionRow = positions[0];
        int positionCol = positions[1];

        boolean gameOver = false;
        boolean jackPotWon = false;
        String command = scan.nextLine();
        while (!command.equals("end")) {
            int[] currentPositions = matrixMovement(command, matrix, positionRow, positionCol);
            positionRow = currentPositions[0];
            positionCol = currentPositions[1];
            if (positionRow < 0 || positionRow >= matrix.length || positionCol < 0 || positionCol >= matrix[0].length) {
                gameOver = true;
                break;
            }

            if (matrix[positionRow][positionCol]=='-'){
                matrix[positionRow][positionCol] = 'G';
            }

            if (matrix[positionRow][positionCol]=='W') {
                matrix[positionRow][positionCol] = 'G';
                funds += 100;
            }
            if (matrix[positionRow][positionCol]=='P') {
                matrix[positionRow][positionCol] = 'G';
                funds -= 200;
                if (funds <= 0) {
                    gameOver = true;
                    break;
                }
            }
            if (matrix[positionRow][positionCol]=='J') {
                matrix[positionRow][positionCol] = 'G';
                funds += 100000;
                jackPotWon = true;
                break;
            }
            command = scan.nextLine();
        }

        if (gameOver) {
            System.out.println("Game over! You lost everything!");
        } else {
            if (jackPotWon) {
                System.out.println("You win the Jackpot!");
            }
            System.out.println("End of the game. Total amount: " + funds + "$");
            for (char[] row : matrix) {
                System.out.println(row);
            }
        }

    }
}


