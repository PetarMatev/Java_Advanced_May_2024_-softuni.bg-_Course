package Java_Advanced_May_2024._02_Multidimensional_Arrays._02_Exercise;

import java.util.ArrayList;
import java.util.Scanner;

public class _06_String_Matrix_Rotation {

    public static void printMatrix(String[][] matrix) {
        for (String[] strings : matrix) {
            for (String string : strings) {
                if (string != null) {
                    System.out.print(string);
                }
            }
            System.out.println();
        }
    }

    public static String[][] fillMatrix(ArrayList<String> listOfWOrds) {
        int rows = listOfWOrds.size();
        int maxColLength = 0;

        for (String word : listOfWOrds) {
            if (word.length() > maxColLength) {
                maxColLength = word.length();
            }
        }
        String[][] matrix = new String[rows][maxColLength];
        for (int i = 0; i < rows; i++) {
            String line = listOfWOrds.get(i);
            for (int j = 0; j < maxColLength; j++) {
                if (j < line.length()) {
                    matrix[i][j] = String.valueOf(line.charAt(j));
                } else {
                    matrix[i][j] = " "; // padding with empty space.
                }
            }
        }
        return matrix;
    }

    public static int getMaxRows(String[][] matrix) {
        int max = Integer.MIN_VALUE;

        for (String[] strings : matrix) {
            int currentRow = strings.length;
            if (currentRow > max) {
                max = currentRow;
            }
        }
        return max;
    }

    public static int getDegrees(Scanner scan) {
        String[] instruction = scan.nextLine().split("\\(");
        int degreeInput = Integer.parseInt(instruction[1].split("\\)")[0]);

        // Normalize degrees to be between 0 and 360
        int degrees = degreeInput % 360;
        if (degrees < 0) {
            degrees += 360;
        }

        return degrees;
    }

    public static ArrayList<String> fillArrayListOfWords(Scanner scan) {
        ArrayList<String> listOfWOrds = new ArrayList<>();
        String command = scan.nextLine();
        while (!command.equals("END")) {
            listOfWOrds.add(command);
            command = scan.nextLine();
        }
        return listOfWOrds;
    }

    public static String[][] getMatrixOf90Degrees(String[][] matrix) {
        int originalRows = matrix.length;
        int originalCols = getMaxRows(matrix);

        String[][] matrixOf90Degrees = new String[originalCols][originalRows];

        for (int row = 0; row < originalRows; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                String entry = matrix[row][col];
                matrixOf90Degrees[col][originalRows - 1 - row] = entry;
            }
        }
        return matrixOf90Degrees;
    }

    public static String[][] getMatrixOf180Degrees(String[][] matrix) {
        int rows = matrix.length;
        int cols = getMaxRows(matrix);
        String[][] matrixOf180Degrees = new String[rows][cols];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                String entry = matrix[i][j];
                matrixOf180Degrees[matrix.length - 1 - i][matrix[i].length - 1 - j] = entry;
            }
        }
        return matrixOf180Degrees;
    }

    public static String[][] getMatrixOf270Degrees(String[][] matrix) {
        int rows = getMaxRows(matrix);
        int cols = matrix.length;
        String[][] matrixOf270Degrees = new String[rows][cols];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                String entry = matrix[i][j];
                matrixOf270Degrees[rows - 1 - j][i] = entry;
            }
        }
        return matrixOf270Degrees;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int degrees = getDegrees(scan);
        ArrayList<String> listOfWOrds = fillArrayListOfWords(scan);
        String[][] matrix = fillMatrix(listOfWOrds);

        if (degrees == 0) {
            printMatrix(matrix);
        } else if (degrees == 90) {
            String[][] matrixOf90Degrees = getMatrixOf90Degrees(matrix);
            printMatrix(matrixOf90Degrees);
        } else if (degrees == 180) {
            String[][] matrixOf180Degrees = getMatrixOf180Degrees(matrix);
            printMatrix(matrixOf180Degrees);
        } else if (degrees == 270) {
            String[][] matrixOf270Degrees = getMatrixOf270Degrees(matrix);
            printMatrix(matrixOf270Degrees);
        }
    }
}
