package Java_Advanced_May_2024._02_Multidimensional_Arrays._01_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _06_Print_Diagonals_of_Square_Matrix {
    public static int[][] fillMatrix(Scanner scan) {
        int num = Integer.parseInt(scan.nextLine());
        int[][] matrix = new int[num][num];

        for (int i = 0; i < num; i++) {
            int[] nums = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < num; j++) {
                matrix[i][j] = nums[j];
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] matrix = fillMatrix(scan);

        for (int i = 0; i < matrix.length; i ++) {
            System.out.print(matrix[i][i] + " ");
        }
        System.out.println();

        for (int i = matrix.length - 1; i >= 0; i--) {
            int colIndex = matrix.length - 1 - i;
            System.out.print(matrix[i][matrix.length - 1 - i] + " ");
        }
    }
}
