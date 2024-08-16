package Java_Advanced_May_2024._02_Multidimensional_Arrays._02_Exercise;

import java.util.Scanner;

public class _01_Fill_the_Matrix {

    public static int[][] getMatrixPatternA(int num) {
        int[][] matrix = new int[num][num];

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if (j != 0) {
                    matrix[i][j] = matrix[i][j - 1] + num;
                } else {
                    matrix[i][j] = i + 1;
                }
            }
        }
        return matrix;
    }

    public static int[][] getMatrixPatternB(int num) {
        int[][] matrix = new int[num][num];

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if (j == 0) {
                    // fill down by adding 1 on each iteration.
                    matrix[i][j] = i + 1;

                } else if (j == 1) {
                    // multiply number of items by 2 and remove i to decrease it by 1;
                    matrix[i][j] = num * 2 - i;
                } else {

                    if (j % 2 == 0) {
                        int value = matrix[i][j - 1] + (i * 2 + 1);
                        matrix[i][j] = value;

                    } else {

                        int constant = matrix[i][j - 1];
                        // take previous value and add the size twice and reduce on each iteration starting from 1.
                        int value = constant + (num * 2) - 1 - (2 * i);
                        matrix[i][j] = value;
                    }

                }
            }
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
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
        String[] line = scan.nextLine().split(", ");
        int num = Integer.parseInt(line[0]);
        String pattern = line[1];

        if (pattern.equals("A")) {
            int[][] matrixA = getMatrixPatternA(num);
            printMatrix(matrixA);
        } else if (pattern.equals("B")) {
            int[][] matrixB = getMatrixPatternB(num);
            printMatrix(matrixB);
        }
    }
}
