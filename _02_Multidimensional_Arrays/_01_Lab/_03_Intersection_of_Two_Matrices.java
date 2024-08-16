package Java_Advanced_May_2024._02_Multidimensional_Arrays._01_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _03_Intersection_of_Two_Matrices {
    public static String[][] returnMatrix(int rows, int cols, Scanner scan) {
        String[][] matrix = new String[rows][cols];

        for(int i=0; i < rows; i++) {
            String[] line = scan.nextLine().split(" ");
            for (int j=0; j <cols; j++) {
               matrix[i][j] = line[j];
            }
        }

        return matrix;
    }

    public static String[][] returnMatrixC(int rows, int cols, String[][]A, String[][]B) {
        String[][] matrix = new String[rows][cols];
        for (int i=0; i < rows; i++) {
            for (int j=0; j< cols; j++) {

                if (A[i][j].equals(B[i][j])) {
                    matrix[i][j] = A[i][j];;
                } else {
                    matrix[i][j] = "*";
                }
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = Integer.parseInt(scan.nextLine());
        int cols = Integer.parseInt(scan.nextLine());
        String[][] A = returnMatrix(rows, cols, scan);
        String[][] B = returnMatrix(rows, cols, scan);
        String[][] C = returnMatrixC(rows, cols, A, B);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(C[i][j] + " ");
            }
            System.out.println(); // Move to the next line after printing each row
        }
    }
}
