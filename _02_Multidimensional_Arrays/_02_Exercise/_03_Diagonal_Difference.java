package Java_Advanced_May_2024._02_Multidimensional_Arrays._02_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class _03_Diagonal_Difference {

    public static int[][] fillMatrix(int num, Scanner scan) {
        int[][] matrix = new int[num][num];
        for (int i = 0; i < num; i++) {
            int[] nums = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = nums;
        }
        return matrix;
    }


    public static int getPrimaryDiagonalNum(int[][] matrix) {
        int num = 0;

        for (int i = 0; i < matrix.length; i++) {
            num += matrix[i][i];
        }
        return num;
    }

    public static int getSecondaryDiagonal(int[][] matrix) {
        int num = 0;
        for (int i = 0; i < matrix.length; i++) {
            num += matrix[i][matrix.length-1-i];
        }
        return num;
    }

    public static void printDiagonalDifference(int primaryDiagonal, int secondaryDiagonal) {
        System.out.println(Math.abs(primaryDiagonal - secondaryDiagonal));
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = Integer.parseInt(scan.nextLine());
        int[][] matrix = fillMatrix(num, scan);
        int primaryDiagonal = getPrimaryDiagonalNum(matrix);
        int secondaryDiagonal = getSecondaryDiagonal(matrix);
        printDiagonalDifference(primaryDiagonal, secondaryDiagonal);

    }
}
