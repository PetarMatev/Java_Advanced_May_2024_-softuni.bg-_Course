package Java_Advanced_May_2024._10_Java_Advanced_Exams._11_Java_Advanced_Retake_Exam_18_August_2022;

import java.util.LinkedList;
import java.util.Scanner;

public class _02_Treasure_Hunt {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] numsInput = scan.nextLine().split("\\s+");
        int rows = Integer.parseInt(numsInput[0]);
        int cols = Integer.parseInt(numsInput[1]);
        String[][] matrix = new String[rows][cols];
        int initialPositionRow = -1;
        int initialPositionCol = -1;

        for (int row = 0; row < matrix.length; row++) {
            String[] input = scan.nextLine().split("\\s+");
            for (int col = 0; col < matrix[row].length; col++) {
                //    matrix[row][col] = input[col];
                if (col < input.length) {
                    matrix[row][col] = input[col];
                } else {
                    matrix[row][col] = "-";
                }
            }
        }


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j].equals("Y")) {
                    initialPositionRow = i;
                    initialPositionCol = j;
                }
            }
        }

        boolean searchEnds = false;

        LinkedList<String> rightDirections = new LinkedList<>();
        int currentRow = initialPositionRow;
        int currentCol = initialPositionCol;

        int previousRow = -1;
        int previousCol = -1;

        String command = scan.nextLine();
        while (!command.equals("Finish")) {
            previousRow = currentRow;
            previousCol = currentCol;
            switch (command) {
                case "up":
                    currentRow--;
                    break;
                case "down":
                    currentRow++;
                    break;
                case "left":
                    currentCol--;
                    break;
                case "right":
                    currentCol++;
                    break;
            }

            if (currentRow < 0 || currentRow >= matrix.length || currentCol < 0 || currentCol >= matrix[0].length || matrix[currentRow][currentCol].equals("T")) {
                currentRow = previousRow;
                currentCol = previousCol;
            } else {
                rightDirections.add(command);
                if (matrix[currentRow][currentCol].equals("X")) {
                    System.out.println("I've found the treasure!");
                    System.out.println("The right path is " + String.join(", ", rightDirections));
                    searchEnds = true;
                    break;
                }
            }
            command = scan.nextLine();
        }

        if (!searchEnds) {
            System.out.println("The map is fake!");
        }
    }
}

