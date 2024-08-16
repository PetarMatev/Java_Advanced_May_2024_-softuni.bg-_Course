package Java_Advanced_May_2024._02_Multidimensional_Arrays._01_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _04_Sum_Matrix_Elements {

    public static void geTotal(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int total = 0;
        for (int i = 0; i < rows; i++) {
            for (int j=0; j < cols; j++) {
                total+= matrix[i][j];
            }
        }
        System.out.println(total);
    }

    public static int[][] getMatrix(Scanner scan) {
        int[] line = Arrays.stream(scan.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int[][] matrix = new int[line[0]][line[1]];
        for (int i = 0; i < line[0]; i++) {
            int[] text = Arrays.stream(scan.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < line[1]; j++) {
                matrix[i][j] = text[j];
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] matrix = getMatrix(scan);

        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
        geTotal(matrix);
    }
}
