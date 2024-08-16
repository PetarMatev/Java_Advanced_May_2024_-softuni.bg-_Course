package Java_Advanced_May_2024._02_Multidimensional_Arrays._01_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _02_Positions_Of {

    public static int[][] readMatrix(int rows, int cols, Scanner scan) {

        int[][] givenMatrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            String[] text = scan.nextLine().split(" ");
            for (int j = 0; j < cols; j++) {
                givenMatrix[i][j] = Integer.parseInt(text[j]);
            }
        }
        return givenMatrix;
    }

    public static void searchMatrix(int[][] matrix, int num) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean notFound = true;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == num) {
                    notFound = false;
                    System.out.println(i + " " + j);
                }
            }
        }

        if (notFound) {
            System.out.println("not found");
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] sides = Arrays.stream(scan.nextLine().split("\\s++"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = sides[0];
        int cols = sides[1];
        int[][] matrix = readMatrix(rows, cols, scan);
        int num = Integer.parseInt(scan.nextLine());
        searchMatrix(matrix, num);
    }
}
