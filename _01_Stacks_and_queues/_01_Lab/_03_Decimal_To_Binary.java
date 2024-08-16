package Java_Advanced_May_2024._01_Stacks_and_queues._01_Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _03_Decimal_To_Binary {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> binaryConverter = new ArrayDeque<>();
        int number = Integer.parseInt(scan.nextLine());

        if (number == 0) {
            binaryConverter.push(0);
        }

        while (number != 0) {
            binaryConverter.push(number % 2);
            number /= 2;
        }

        StringBuilder string = new StringBuilder();
        while(!binaryConverter.isEmpty()) {
            string.append(binaryConverter.pop());
        }

        System.out.println(string.toString());
    }
}
