package Java_Advanced_May_2024._10_Java_Advanced_Exams._02_Java_Advanced_Regular_Exam_17_February_2024;

import java.util.Scanner;

public class _02_Clear_Skies {

    public static int[] findTheStartingPosition(String[][] matrix, String target) {
        int[] positions = new int[2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j].equals(target)) {
                     positions[0] = i;
                     positions[1] = j;
                }
            }
        }
        return positions;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        String[][] matrix = new String[n][n];
        String jetfighterPosition = "J";
        int armour = 300;

        for (int i = 0; i < matrix.length; i++) {
            String[] line = scan.nextLine().split("");
            matrix[i] = line;
        }

        int[] startingPositions = findTheStartingPosition(matrix, jetfighterPosition);
        int positionRow = startingPositions[0];
        int positionCol = startingPositions[1];



        boolean missionFailed = false;
        boolean allfigherJetsDestroyed = false;
        int counter = 4;

        while (true) {
            String command = scan.nextLine();
            // Mark the current position as visited:
            matrix[positionRow][positionCol] = "-";

            switch (command) {
                case "up":
                    if (positionRow - 1 >= 0) {
                        positionRow--;
                    }
                    break;
                case "down":
                    if (positionRow + 1 < matrix.length) {
                        positionRow++;
                    }
                    break;
                case "left":
                    if (positionCol - 1 >= 0) {
                        positionCol--;
                    }
                    break;
                case "right":
                    if (positionCol + 1 < matrix[0].length) {
                        positionCol++;
                    }
                    break;
            }

            // E - enemy aircraft - battle begins
            if (matrix[positionRow][positionCol].equals("E")) {
                armour -= 100;
                if (armour < 100) {
                    missionFailed = true;
                    matrix[positionRow][positionCol] = "J";
                    System.out.printf("Mission failed, your jetfighter was shot down! Last coordinates [%d, %d]!\n", positionRow, positionCol);
                    break;
                } else {
                    counter--;
                    matrix[positionRow][positionCol] = "-";
                }

                if (counter == 0) {
                    allfigherJetsDestroyed = true;
                    matrix[positionRow][positionCol] = "J";
                    System.out.println("Mission accomplished, you neutralized the aerial threat!");
                    break;
                }

            } else if (matrix[positionRow][positionCol].equals("R")) {
                armour = 300;
                matrix[positionRow][positionCol] = "-";
            } else {

            }
        }

        for (String[] row : matrix) {
            System.out.println(String.join("", row));
        }
    }
}
