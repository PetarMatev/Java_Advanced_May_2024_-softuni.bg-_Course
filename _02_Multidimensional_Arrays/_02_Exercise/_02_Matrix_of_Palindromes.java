package Java_Advanced_May_2024._02_Multidimensional_Arrays._02_Exercise;

import java.util.Scanner;

public class _02_Matrix_of_Palindromes {

    public static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (j < matrix[0].length - 1) {
                    System.out.print(matrix[i][j] + " ");
                } else {
                    System.out.print(matrix[i][j]);
                }
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] line = scan.nextLine().split(" ");
        int rows = Integer.parseInt(line[0]);
        int cols = Integer.parseInt(line[1]);
        String[][] matrix = new String[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                char a = (char) (i + 97);
                char b = (char) (j + 97 + i);
                char c = (char) (i + 97);
                matrix[i][j] = "" + a + b + c;
            }
        }

        printMatrix(matrix);
    }
}
