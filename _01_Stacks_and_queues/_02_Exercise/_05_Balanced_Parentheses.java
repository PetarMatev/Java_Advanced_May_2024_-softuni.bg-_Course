package Java_Advanced_May_2024._01_Stacks_and_queues._02_Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _05_Balanced_Parentheses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        ArrayDeque<Character> queue = new ArrayDeque<>();
        if (line.length() % 2 != 0) {
            System.out.println("NO");
        } else {
            for (int i=0; i < line.length(); i++ ) {
                char currentChar = line.charAt(i);
                if (currentChar == '{' || currentChar=='[' || currentChar=='(') {
                    queue.push(currentChar);
                } else {
                    char item = queue.peek();
                    if (currentChar == '}' && item =='{') {
                        queue.pop();
                    } else if (currentChar == ']' && item =='[') {
                        queue.pop();
                    } else if (currentChar == ')' && item =='(') {
                        queue.pop();
                    }
                }
            }
            if (line.length() % 2 != 0) {
                System.out.println("NO");
            } else {
                if (queue.isEmpty()) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}
