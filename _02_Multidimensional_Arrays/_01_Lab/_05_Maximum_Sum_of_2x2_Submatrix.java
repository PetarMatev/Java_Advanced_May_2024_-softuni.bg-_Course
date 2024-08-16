package Java_Advanced_May_2024._02_Multidimensional_Arrays._01_Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class _05_Maximum_Sum_of_2x2_Submatrix {

    private static int[][] getArray(Scanner scan) {
        int[] numbers = Arrays.stream(scan.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int rows = numbers[0];
        int cols = numbers[1];
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            int[] text = Arrays.stream(scan.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = text[j];
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] matrix = getArray(scan);
        int biggestSum = Integer.MIN_VALUE;
        int[][] maxMatrix = new int[2][2];
        ArrayList<Integer> box = new ArrayList<>();
        for (int r = 0; r < matrix.length - 1; r++) {
            for (int c = 0; c < matrix[0].length - 1; c++) {
                int topLeft = matrix[r][c];
                int topRight = matrix[r][c + 1];
                int bottomLeft = matrix[r + 1][c];
                int bottomRight = matrix[r + 1][c + 1];
                int interim = topLeft + topRight + bottomLeft + bottomRight;
                if (interim > biggestSum) {
                    biggestSum = interim;
                    maxMatrix[0][0] = topLeft;
                    maxMatrix[0][1] = topRight;
                    maxMatrix[1][0] = bottomLeft;
                    maxMatrix[1][1] = bottomRight;
                }
            }
        }
        for (int[] arr : maxMatrix) {
            for (int n : arr) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
        System.out.println(biggestSum);
    }
}
