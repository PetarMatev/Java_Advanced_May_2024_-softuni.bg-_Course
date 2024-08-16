package Java_Advanced_May_2024._02_Multidimensional_Arrays._01_Lab;

import java.util.Scanner;

public class _01_Compare_Matrices {

    public static String verifyIfTwoMatrixAreIdentical(int[][] matrix, int[][] matrixTwo) {
        if (matrix.length != matrixTwo.length || matrix[0].length != matrixTwo[0].length) {
            return "not equal";
        }

        for (int i=0; i < matrix.length; i++) {
            for (int j=0; j < matrix[i].length; j++) {
                if (matrix[i][j] != matrixTwo[i][j]) {
                    return "not equal";
                }
            }
        }

        return "equal";
    }

    public static int[][] readMatrix(Scanner scanner, int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            String[] nums = scanner.nextLine().split(" ");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Integer.parseInt(nums[j]);;
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] text = scan.nextLine().split(" ");
        int rows1 = Integer.parseInt(text[0]);
        int cols1    = Integer.parseInt(text[1]);
        int[][] matrixOne = readMatrix(scan, rows1, cols1);

        String[] textTwo = scan.nextLine().split(" ");
        int rows2 = Integer.parseInt(textTwo[0]);
        int cols2 = Integer.parseInt(textTwo[1]);
        int[][] matrixTwo = readMatrix(scan, rows2, cols2);

        System.out.println(verifyIfTwoMatrixAreIdentical(matrixOne, matrixTwo));
    }
}

