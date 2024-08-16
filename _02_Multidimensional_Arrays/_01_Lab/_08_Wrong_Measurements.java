package Java_Advanced_May_2024._02_Multidimensional_Arrays._01_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _08_Wrong_Measurements {
    public static int[][] fillMatrix(int num, Scanner scan) {
        int[][] matrix = new int[num][];

        for (int i = 0; i < num; i++) {
            int[] nums = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = nums;
        }
        return matrix;
    }

    public static int getBottom(int i, int j, int num, int[][] matrix, int wrongNumber) {
        int bottom = 0;
        if (i + 1 < num && matrix[i + 1][j] != wrongNumber) {
            bottom = matrix[i + 1][j];
        }
        return bottom;
    }

    public static int getTop(int i, int j, int num, int[][] matrix, int wrongNumber) {
        int top = 0;
        if (i - 1 >= 0 && matrix[i - 1][j] != wrongNumber) {
            top = matrix[i - 1][j];
        }
        return top;
    }

    public static int getLeft(int i, int j, int num, int[][] matrix, int wrongNumber) {
        int left = 0;
        if (j - 1 >= 0 && matrix[i][j - 1] != wrongNumber) {
            left = matrix[i][j - 1];
        }

        return left;
    }

    public static int getRight(int i, int j, int num, int[][] matrix, int wrongNumber) {
        int right = 0;
        if (j + 1 < matrix[0].length && matrix[i][j + 1] != wrongNumber) {
            right = matrix[i][j + 1];
        }
        return right;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        int[][] matrix = fillMatrix(num, scan);

        int[] text = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int row = text[0];
        int column = text[1];

        int wrongNumber = matrix[row][column];
        int[][] resultMatrix = new int[num][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                if (matrix[i][j] != wrongNumber) {
                    resultMatrix[i][j] = matrix[i][j];
                } else {
                    int top = getTop(i, j, num, matrix, wrongNumber);
                    int bottom = getBottom(i, j, num, matrix, wrongNumber);
                    int left = getLeft(i, j, num, matrix, wrongNumber);
                    int right = getRight(i, j, num, matrix, wrongNumber);
                    resultMatrix[i][j] = top + bottom + left + right;
                }
            }
        }

        for (
                int rows = 0;
                rows < num; rows++) {
            for (int cols = 0; cols < matrix[0].length; cols++) {
                if (cols == matrix[0].length - 1) {
                    System.out.print(resultMatrix[rows][cols]);
                } else {
                    System.out.print(resultMatrix[rows][cols] + " ");
                }
            }
            System.out.println();
        }

    }
}
