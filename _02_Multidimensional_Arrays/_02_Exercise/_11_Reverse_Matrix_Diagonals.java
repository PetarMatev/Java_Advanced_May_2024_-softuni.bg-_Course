package Java_Advanced_May_2024._02_Multidimensional_Arrays._02_Exercise;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class _11_Reverse_Matrix_Diagonals {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] info = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = info[0];
        int cols = info[1];

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }


        LinkedList<Integer> bucket = new LinkedList<>();
        
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                int IndexOutOfBoundsException = -100;
                while (matrix[i][j] == IndexOutOfBoundsException) {
                    
                }
                
                
                
            }
        }


    }
}
