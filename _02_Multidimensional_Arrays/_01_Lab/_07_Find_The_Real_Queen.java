package Java_Advanced_May_2024._02_Multidimensional_Arrays._01_Lab;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class _07_Find_The_Real_Queen {

    public static Character[][] fillMatrix(Scanner scan) {
        Character[][] matrix = new Character[8][8];
        for (int i=0; i < 8; i++) {
            char[] characters =  scan.nextLine().replaceAll(" ", "").toCharArray();
            for (int j=0; j < 8; j++) {
                matrix[i][j] = characters[j];
            }
        }
        return matrix;
    }

    public static boolean checkColumnLEFT(int row, int col, String str, Character[][] matrix) {
        for (int v = 0; v < col; v++) {
            if (matrix[row][v].equals(str.charAt(0))) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkColumnRight(int row, int col, String str, Character[][] matrix) {
        for (int v = col + 1; v < matrix[0].length; v++) {
            if (matrix[row][v].equals(str.charAt(0))) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkRowTOP(int row, int col, String str, Character[][] matrix) {
        for (int v = 0; v < row; v++) {
            if (matrix[v][col].equals(str.charAt(0))) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkRowBottom(int row, int col, String str, Character[][] matrix) {
        for (int v = row+1; v < matrix.length; v++) {
            if (matrix[v][col].equals(str.charAt(0))) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkDiagonalTop(int row, int col, String str, Character[][] matrix) {
        for (int v = 1; row - v >= 0 && col - v >= 0; v ++) {
            if (matrix[row-v][col-v].equals(str.charAt(0))) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkDiagonalBottom(int row, int col, String str, Character[][] matrix) {
        for (int v = 1; row + v < 8 && col + v < 8; v ++) {
            if (matrix[row+v][col+v].equals(str.charAt(0))) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkDiagonalTwoToP(int row, int col, String str, Character[][] matrix) {
        for (int v = 1; row - v >= 0 && col + v < 8; v ++) {
            if (matrix[row-v][col+v].equals(str.charAt(0))) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkDiagonalTwoBottom(int row, int col, String str, Character[][] matrix) {
        for (int v = 1; row + v < 8 && col - v >= 0; v ++) {
            if (matrix[row+v][col-v].equals(str.charAt(0))) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Character[][] matrix = fillMatrix(scan);
        String str = "q";
        for (int i=0; i< 8; i++) {
            for (int j=0; j<8; j++) {

                int row = i;
                int col = j;

                if (matrix[i][j].equals(str.charAt(0))) {

                    boolean columnsLeft = checkColumnLEFT(row, col, str, matrix);
                    boolean columnsRight = checkColumnRight(row, col, str, matrix);
                    boolean rowTop = checkRowTOP(row, col, str, matrix);
                    boolean rowBottom = checkRowBottom(row, col, str, matrix);
                    boolean diagonalTop = checkDiagonalTop(row, col, str, matrix);
                    boolean diagonalBottom = checkDiagonalBottom(row, col, str, matrix);
                    boolean diagonalTwoTOP = checkDiagonalTwoToP(row, col, str, matrix);
                    boolean diagonalTwoBottom = checkDiagonalTwoBottom(row, col, str, matrix);

                    if(columnsLeft && columnsRight && rowTop && rowBottom && diagonalTop && diagonalBottom && diagonalTwoTOP && diagonalTwoBottom) {
                        System.out.println(i + " " + j);
                    }
                }
            }
        }
    }
}
