package Java_Advanced_May_2024._02_Multidimensional_Arrays._02_Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _07_Crossfire {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] nums = scan.nextLine().split("\\s+");
        int[][] matrix = new int[Integer.parseInt(nums[0])][Integer.parseInt(nums[1])];
        int value = 1;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                matrix[r][c] = value++;
            }
        }

        // Convert the matrix to a list of lists
        List<List<Integer>> listMatrix = new ArrayList<>();
        for (int[] row : matrix) {
            List<Integer> listRow = new ArrayList<>();
            for (int num : row) {
                listRow.add(num);
            }
            listMatrix.add(listRow);
        }


        String command = scan.nextLine();
        while (!command.equals("Nuke it from orbit")) {
            int[] info = Arrays.stream(command.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            for (int row = 0; row < listMatrix.size(); row++) {
                for (int col = 0; col < listMatrix.get(0).size(); col++) {
                    if (row == info[0] && col == info[1]) {
                        matrix[row][col] = 0;
                        for (int i = 1; i < info[2] + 1; i++) {
                            // Pointing Top
                            if (row - i >= 0) {
                                listMatrix.get(row-i).remove(col);
                            }
                            // Pointing Down
                            if (row + i < listMatrix.size()) {
                                listMatrix.get(row+i).remove(col);
                            }
                            // Pointing Left
                            if (col - i >= 0) {
                                listMatrix.get(row).remove(col-i);
                            }
                            // Pointing Right
                            if (col + i < listMatrix.get(0).size()) {
                                listMatrix.get(row).remove(col+i);
                            }
                        }
                    }
                }
            }
            command = scan.nextLine();

        }

        for (List<Integer> row : listMatrix) {
            for (Integer col : row) {
                System.out.print(col);
            }
            System.out.println();
        }


    }
}




