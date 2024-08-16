package Java_Advanced_May_2024._10_Java_Advanced_Exams._04_Java_Advanced_Regular_Exam_21_October_2023;

import java.util.Scanner;

public class _02_Fishing_Competition {

    public static int[] getPositions(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j].equals("S")) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0, 0};
    }

    public static int[] getUpdatedPositions(String command, int positionRow, int positionCol) {
        switch (command) {
            case "up":
                positionRow--;
                break;
            case "down":
                positionRow++;
                break;
            case "left":
                positionCol--;
                break;
            case "right":
                positionCol++;
                break;
        }
        return new int[]{positionRow, positionCol};
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String[][] matrix = new String[n][n];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scan.nextLine().split("");
        }
        int[] positions = getPositions(matrix);
        int positionRow = positions[0];
        int positionCol = positions[1];

        int pod = 0;

        boolean enteredWhirlpool = false;
        boolean successfulSeason = false;

        String command = scan.nextLine();
        while (!command.equals("collect the nets")) {
            matrix[positionRow][positionCol] = "-"; // update its current Position to "-".
            int[] pos = getUpdatedPositions(command, positionRow, positionCol);
            positionRow = pos[0];
            positionCol = pos[1];

            if (positionRow < 0 || positionRow >= matrix.length || positionCol < 0 || positionCol >= matrix[0].length) {
                switch (command) {
                    case "up" -> positionRow = matrix.length - 1;
                    case "down" -> positionRow = 0;
                    case "left" -> positionCol = matrix[0].length - 1;
                    case "right" -> positionCol = 0;
                }
            }

            if (Character.isDigit(matrix[positionRow][positionCol].charAt(0))) {
                pod += Integer.parseInt(matrix[positionRow][positionCol]);
                if (pod >= 20) {
                    successfulSeason = true;
                }
                matrix[positionRow][positionCol] = "-"; // mark the current position with S;
            }

            if (matrix[positionRow][positionCol].equals("W")) {
                enteredWhirlpool = true;
                break;
            } else if (matrix[positionRow][positionCol].equals("-")) {
                matrix[positionRow][positionCol] = "S";
            }
            command = scan.nextLine();
        }

        if (enteredWhirlpool) {
            System.out.printf("You fell into a whirlpool! " +
                    "The ship sank and you lost the fish you caught." +
                    " Last coordinates of the ship: [%d,%d]", positionRow, positionCol);
        } else {
            if (successfulSeason) {
                System.out.println("Success! You managed to reach the quota!");
            } else {
                System.out.print("You didn't catch enough fish and didn't reach the quota!");
                System.out.printf(" You need %d tons of fish more.\n", 20 - pod);
            }
            if (pod > 0){
                System.out.printf("Amount of fish caught: %d tons.\n", pod);
            }

            for (String[] row : matrix) {
                System.out.println(String.join("", row));
            }
        }
    }
}
