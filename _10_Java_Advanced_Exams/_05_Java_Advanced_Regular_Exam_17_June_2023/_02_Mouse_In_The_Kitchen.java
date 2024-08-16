package Java_Advanced_May_2024._10_Java_Advanced_Exams._05_Java_Advanced_Regular_Exam_17_June_2023;

import java.util.Scanner;

public class _02_Mouse_In_The_Kitchen {
    private static int[] getPositions(String command, int row, int col) {
        switch (command) {
            case "up":
                row--;
                break;
            case "down":
                row++;
                break;
            case "left":
                col--;
                break;
            case "right":
                col++;
                break;
        }

        return new int[]{row, col};
    }

    public static int[] getInitialPositions(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j].equals("M")) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0, 0};
    }

    public static int getTotalCheese(String[][] matrix) {
        int counter = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j].equals("C")) {
                    counter++;
                }
            }
        }

        return counter;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] nums = scan.nextLine().split(",");
        int rows = Integer.parseInt(nums[0]);
        int cols = Integer.parseInt(nums[1]);
        String[][] matrix = new String[rows][];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scan.nextLine().split("");
        }

        int[] initialPositions = getInitialPositions(matrix);
        int positionRow = initialPositions[0];
        int positionCol = initialPositions[1];


        int getTotalCheese = getTotalCheese(matrix);

        boolean cheeseHuntOver = false;
        boolean noMoreCheese = false;
        boolean trapped = false;

        String command = scan.nextLine();
        while (!command.equals("danger")) {
            int previousRow = positionRow;
            int previousCol = positionCol;
            int[] currentPositions = getPositions(command, positionRow, positionCol);
            positionRow = currentPositions[0];
            positionCol = currentPositions[1];

            if (positionRow < 0 || positionRow >= matrix.length || positionCol < 0 || positionCol >= matrix[0].length) {
                matrix[previousRow][previousCol] = "M";
                cheeseHuntOver = true;
                break;
            }

            matrix[previousRow][previousCol] = "*"; // update previous position

            if (matrix[positionRow][positionCol].equals("C")) {
                getTotalCheese--;
                if (getTotalCheese == 0) {
                    matrix[positionRow][positionCol] = "M";
                    noMoreCheese = true;
                    break;
                }
                matrix[positionRow][positionCol] = "*";
            } else if (matrix[positionRow][positionCol].equals("T")) {
                matrix[positionRow][positionCol] = "M";
                trapped = true;
                break;
            } else if (matrix[positionRow][positionCol].equals("@")) {
                positionRow = previousRow;
                positionCol = previousCol;
            }
            command = scan.nextLine();
        }

        if (cheeseHuntOver) {
            System.out.println("No more cheese for tonight!");
        } else {
            if (noMoreCheese) {
                System.out.println("Happy mouse! All the cheese is eaten, good night!");
            } else {
                if (trapped) {
                    System.out.println("Mouse is trapped!");
                } else {
                    System.out.println("Mouse will come back later!");
                    matrix[positionRow][positionCol] = "M"; // always have to update the position of the person.
                }
            }
        }
        for (String[] row : matrix) {
            System.out.println(String.join("", row));
        }
    }
}
