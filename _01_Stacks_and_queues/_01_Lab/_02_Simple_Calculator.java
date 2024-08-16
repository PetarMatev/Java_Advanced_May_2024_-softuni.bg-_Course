package Java_Advanced_May_2024._01_Stacks_and_queues._01_Lab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class _02_Simple_Calculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<String> calculator = new ArrayDeque<>();
        int total = 0;

        String text = scan.nextLine();
        String[] arr = text.split("\\s+");

        // Add all items into the Stack with Collection
        Collections.addAll(calculator, arr);

        // Add all items into the Stack
//        for (int i = 0; i < arr.length; i ++) {
//            calculator.push(arr[i]);
//        }

        while(calculator.size() > 1) {
            int FirstNum = Integer.parseInt(calculator.pop());
            String sign = calculator.pop();
            int SecondNum = Integer.parseInt(calculator.pop());
            int newNumber = 0;
            if (sign.equals("+")) {
                newNumber = FirstNum + SecondNum;
            } else {
                newNumber = FirstNum - SecondNum;
            }
            calculator.push(String.valueOf(newNumber));
        }
        System.out.println(calculator.pop());
    }
}
