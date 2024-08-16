package Java_Advanced_May_2024._02_Multidimensional_Arrays._02_Exercise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _04_Maximal_Sum {

    public static int[][] fillMatrix(String[] line, Scanner scan) {
        int row = Integer.parseInt(line[0]);
        int col = Integer.parseInt(line[1]);

        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            int[] values = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = values;
        }
        return matrix;
    }

    public static Map<Integer, int[][]> return3x3Matrix(int[][] matrix) {
        int[][] newMatrix = new int[3][3];
        int sumTotal = Integer.MIN_VALUE;

        for (int i = 0; i < matrix.length - 2; i++) {
            for (int j = 0; j < matrix[0].length - 2; j++) {

                int row1 = matrix[i][j] + matrix[i][j + 1] + matrix[i][j + 2];
                int row2 = matrix[i + 1][j] + matrix[i + 1][j + 1] + matrix[i + 1][j + 2];
                int row3 = matrix[i + 2][j] + matrix[i + 2][j + 1] + matrix[i + 2][j + 2];

                int total = row1 + row2 + row3;

                if (total > sumTotal) {
                    sumTotal = total;
                    newMatrix[0] = new int[]{matrix[i][j], matrix[i][j + 1], matrix[i][j + 2]};
                    newMatrix[1] = new int[]{matrix[i + 1][j], matrix[i + 1][j + 1], matrix[i + 1][j + 2]};
                    newMatrix[2] = new int[]{matrix[i + 2][j], matrix[i + 2][j + 1], matrix[i + 2][j + 2]};
                }
            }
        }

        Map<Integer, int[][]> result = new HashMap<>();
        result.put(sumTotal, newMatrix);

        return result;
    }

    public static void printMatrix(int[][] matrix) {
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

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] matrix = fillMatrix(scan.nextLine().split(" "), scan);

        Map<Integer, int[][]> finalAnswer = return3x3Matrix(matrix);
        finalAnswer.forEach((k, v) -> System.out.printf("Sum = %d%n", k));
        finalAnswer.forEach((k,v) -> printMatrix(v));
    }
}
