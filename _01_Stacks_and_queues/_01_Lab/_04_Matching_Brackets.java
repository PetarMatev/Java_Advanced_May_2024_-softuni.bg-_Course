package Java_Advanced_May_2024._01_Stacks_and_queues._01_Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _04_Matching_Brackets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // initial text

        //TODO 1 + (2 - (2 + 3) * 4 / (3 + 1)) * 5

        String expression = scan.nextLine();
        // create a stack of integers
        ArrayDeque<Integer> arithmetical = new ArrayDeque<>();

        // loop through each char in the expression
        for (int i = 0; i< expression.length(); i++){
            // create a current char
            char currentItem = expression.charAt(i);
            // if the current char is an opening bracket (
            if (currentItem == '(') {
                // we will add the index of that opening bracket.
                // The next opening bracket will have higher
                // index and will be an inner bracket opening.
                arithmetical.push(i);
            }
            else if (currentItem == ')') {
                // when we find a closing bracket we check if the stack is empty.
                if (!arithmetical.isEmpty()) {
                    // then we pop the most inner opening bracket and mark the index of that opening bracket.
                    int startIndex = arithmetical.pop();
                    int closingIndex = i;
                    // then we collect the full expression from the initial text using substring.
                    String subExpression = expression.substring(startIndex, closingIndex + 1);
                    System.out.println(subExpression);
                }
            }
        }
    }
}
