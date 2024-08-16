package Java_Advanced_May_2024._10_Java_Advanced_Exams._12_Java_Advanced_Retake_Exam_13_April_2022;

import java.util.*;

public class _01_Blacksmith {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] steelInput = scan.nextLine().split("\\s+");
        String[] carbonInput = scan.nextLine().split("\\s+");

        ArrayDeque<Integer> steelQueue = new ArrayDeque<>(); // start from the first steel // First-in-First-Out //
        ArrayDeque<Integer> carboStack = new ArrayDeque<>(); // start from the last carbon. // Last-in-First-Out

        for (String s : steelInput) {
            steelQueue.offer(Integer.parseInt(s));
        }

        for (String s : carbonInput) {
            carboStack.push(Integer.parseInt(s));
        }

        Map<Integer, String> bucket = new HashMap<>();
        bucket.putIfAbsent(70, "Gladius");
        bucket.putIfAbsent(80, "Shamshir");
        bucket.putIfAbsent(90, "Katana");
        bucket.putIfAbsent(110, "Sabre");

        TreeMap<String, Integer> forgedSwords = new TreeMap<>(); // for Alphabetical Order

        while (!steelQueue.isEmpty() && !carboStack.isEmpty()) {
            Integer firstSteel = steelQueue.poll();
            Integer lastCarbon = carboStack.pop();
            Integer result = firstSteel + lastCarbon;

            if (bucket.containsKey(result)) {
                String currentKeyName = bucket.get(result);
                forgedSwords.putIfAbsent(currentKeyName, 0);
                int currentCount = forgedSwords.get(currentKeyName);
                forgedSwords.put(currentKeyName, currentCount + 1);
            } else {
                int carbon = lastCarbon + 5;
                carboStack.push(carbon);
            }
        }
        int totalNumberOfSwords = forgedSwords.values().stream().mapToInt(Integer::intValue).sum();

        // First Line Output:
        if (totalNumberOfSwords > 0) {
            System.out.printf("You have forged %d swords.%n", totalNumberOfSwords);
        } else {
            System.out.println("You did not have enough resources to forge a sword.");
        }
        // Second Line Output:
        if (!steelQueue.isEmpty()) {
            System.out.printf("Steel left: ");
            System.out.println(steelQueue.toString().replaceAll("[\\[|\\]]", ""));
        } else {
            System.out.println("Steel left: none");
        }
        // Third Line Output:
        if (!carboStack.isEmpty()) {
            System.out.printf("Carbon left: ");
            System.out.println(carboStack.toString().replaceAll("[\\[|\\]]", ""));
        } else {
            System.out.println("Carbon left: none");
        }
        // Forth Line Output:
        forgedSwords.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
