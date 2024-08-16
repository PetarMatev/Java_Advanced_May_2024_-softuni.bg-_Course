package Java_Advanced_May_2024._03_Sets_and_Maps_Advanced._02_Exercise;

import java.util.*;

public class _07_Hands_Of_Cards {
    public static Map<String, ArrayList<String>> fillMap(Scanner scan) {
        Map<String, ArrayList<String>> box = new LinkedHashMap<>();
        String command = scan.nextLine();
        while (!command.equals("JOKER")) {
            String name = command.split(":\\s+")[0];
            String[] cards = command.split(":\\s+")[1].split(",\\s+");
            box.putIfAbsent(name, new ArrayList<>());
            for (String card : cards) {
                if (!box.get(name).contains(card)) {
                    box.get(name).add(card);
                }
            }
            command = scan.nextLine();
        }

        return box;
    }

    public static Map<String, Integer> fillPowers() {
        Map<String, Integer> powersBook = new HashMap<>();
        powersBook.put("2", 2);
        powersBook.put("3", 3);
        powersBook.put("4", 4);
        powersBook.put("5", 5);
        powersBook.put("6", 6);
        powersBook.put("7", 7);
        powersBook.put("8", 8);
        powersBook.put("9", 9);
        powersBook.put("10", 10);
        powersBook.put("J", 11);
        powersBook.put("Q", 12);
        powersBook.put("K", 13);
        powersBook.put("A", 14);
        return powersBook;
    }

    public static Map<Character, Integer> fillTypes() {
        Map<Character, Integer> typeBook = new HashMap<>();
        typeBook.put('S', 4);
        typeBook.put('H', 3);
        typeBook.put('D', 2);
        typeBook.put('C', 1);
        return typeBook;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Integer> powers = fillPowers();
        Map<Character, Integer> types = fillTypes();
        Map<String, ArrayList<String>> handOfCards = fillMap(scan);

        for (Map.Entry<String, ArrayList<String>> entry : handOfCards.entrySet()) {
            int playerPoints = 0;
            for (String card : entry.getValue()) {
                String power;
                char type;
                if (card.length() == 3) {
                    power = card.substring(0, 2);
                    type = card.charAt(2);
                } else {
                    power = String.valueOf(card.charAt(0));
                    type = card.charAt(1);
                }
                playerPoints += powers.get(power) * types.get(type);
            }
            System.out.printf("%s: %d%n", entry.getKey(), playerPoints);
        }
    }
}
