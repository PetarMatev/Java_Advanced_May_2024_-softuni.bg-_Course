package Java_Advanced_May_2024._02_Multidimensional_Arrays._02_Exercise;

import java.util.Scanner;

public class _05_Matrix_Shuffling {

    public static String[][] fillMatrix(String[] nums, Scanner scan) {
        int rows = Integer.parseInt(nums[0]);
        int cols = Integer.parseInt(nums[1]);
        String[][] matrix = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            matrix[i] = scan.nextLine().split(" ");
        }
        return matrix;
    }

    public static void printCurrentStateMatrix(String[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                if (j == matrix[0].length - 1) {
                    System.out.print(matrix[i][j]);
                } else {
                    System.out.print(matrix[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void swapEntries(String[][] matrix, int row1, int col1, int row2, int col2) {
        String temp1 = matrix[row1][col1];
        String temp2 = matrix[row2][col2];
        matrix[row1][col1] = temp2;
        matrix[row2][col2] = temp1;
    }

    public static boolean isValidInput(int row1, int col1, int row2, int col2, String[][] matrix) {
        return row1 >= 0 && row1 < matrix.length &&
                col1 >= 0 && col1 < matrix[0].length &&
                row2 >= 0 && row2 < matrix.length &&
                col2 >= 0 && col2 < matrix[0].length;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] line = scan.nextLine().split(" ");
        String[][] matrix = fillMatrix(line, scan);

        String command = scan.nextLine();
        while (!command.equals("END")) {
            String[] info = command.split(" ");
            String instruction = info[0];

            if (info.length != 5 || !instruction.equals("swap")) {
                System.out.println("Invalid input!");
                command = scan.nextLine();
                continue;
            }

            int row1 = Integer.parseInt(info[1]);
            int col1 = Integer.parseInt(info[2]);
            int row2 = Integer.parseInt(info[3]);
            int col2 = Integer.parseInt(info[4]);

            if (!isValidInput(row1, col1, row2, col2, matrix)) {
                System.out.println("Invalid input!");
                command = scan.nextLine();
                continue;
            }

            swapEntries(matrix, row1, col1, row2, col2);
            printCurrentStateMatrix(matrix);
            command = scan.nextLine();
        }
    }
}
