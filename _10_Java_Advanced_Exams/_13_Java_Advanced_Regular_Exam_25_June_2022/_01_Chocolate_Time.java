package Java_Advanced_May_2024._10_Java_Advanced_Exams._13_Java_Advanced_Regular_Exam_25_June_2022;

import java.util.*;

public class _01_Chocolate_Time {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] milkInput = scan.nextLine().split("\\s+");
        String[] cacaoInput = scan.nextLine().split("\\s+");

        ArrayDeque<Double> milkQueue = new ArrayDeque<>(); // start from the first steel // First-in-First-Out //
        ArrayDeque<Double> cacaoStack = new ArrayDeque<>(); // start from the last carbon. // Last-in-First-Out

        for (String s : milkInput) {
            milkQueue.offer(Double.parseDouble(s));
        }

        for (String s : cacaoInput) {
            cacaoStack.push(Double.parseDouble(s));
        }

        Map<Double, String> bucket = new HashMap<>();
        bucket.putIfAbsent(30.0, "Milk Chocolate");
        bucket.putIfAbsent(50.0, "Dark Chocolate");
        bucket.putIfAbsent(100.0, "Baking Chocolate");

        TreeMap<String, Integer> chocoContainer = new TreeMap<>(); // for Alphabetical Order

        while (!milkQueue.isEmpty() && !cacaoStack.isEmpty()) {
            Double milk = milkQueue.poll();
            Double cacao = cacaoStack.pop();
            Double result = (cacao / (milk + cacao)) * 100;

            if (bucket.containsKey(result)) {
                String key = bucket.get(result);
                chocoContainer.putIfAbsent(key, 0);
                int currentCount = chocoContainer.get(key);
                chocoContainer.put(key, currentCount + 1);
            } else {
                milkQueue.offer(milk + 10);
            }
        }

        long count = chocoContainer.entrySet().stream().filter(entry -> entry.getValue() != 0).count();
        System.out.println(count);

        // First Line Output:
        if (chocoContainer.size() == 3) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        } else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }
        // Second Line:
        chocoContainer.forEach((key, value) -> System.out.println("# " + key + " --> " + value));

    }
}
