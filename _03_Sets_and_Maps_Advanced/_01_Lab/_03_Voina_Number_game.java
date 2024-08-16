package Java_Advanced_May_2024._03_Sets_and_Maps_Advanced._01_Lab;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _03_Voina_Number_game {

    public static LinkedHashSet<Integer> returnDeck(Scanner scan) {

        List<Integer> line = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        return new LinkedHashSet<>(line);
    }

    public static void playVoina(LinkedHashSet<Integer> playerOne, LinkedHashSet<Integer> playerTwo) {
        Integer currentCardOne = playerOne.iterator().next();
        playerOne.remove(currentCardOne);
        Integer currentCardTwo = playerTwo.iterator().next();
        playerTwo.remove(currentCardTwo);

        if (currentCardOne > currentCardTwo) {
            playerOne.add(currentCardOne);
            playerOne.add(currentCardTwo);
        } else if (currentCardTwo > currentCardOne) {
            playerTwo.add(currentCardOne);
            playerTwo.add(currentCardTwo);
        } else {
            // If it's a draw, add the cards to the bottom of playerOne's deck
            playerOne.add(currentCardOne);
            playerTwo.add(currentCardTwo);
        }
    }

    public static void printResult(LinkedHashSet<Integer> playerOne, LinkedHashSet<Integer> playerTwo) {
        if (playerOne.size() > playerTwo.size()) {
            System.out.println("First player win!");
        } else if (playerTwo.size() > playerOne.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedHashSet<Integer> playerOne = returnDeck(scan);
        LinkedHashSet<Integer> playerTwo = returnDeck(scan);

        for (int i = 1; i <= 50; i++) {
            playVoina(playerOne, playerTwo);
            if (playerOne.isEmpty() || playerTwo.isEmpty()) break;
        }

        printResult(playerOne, playerTwo);
    }
}

