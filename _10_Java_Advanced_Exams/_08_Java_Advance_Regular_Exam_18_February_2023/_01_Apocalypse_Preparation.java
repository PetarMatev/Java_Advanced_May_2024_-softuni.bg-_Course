package Java_Advanced_May_2024._10_Java_Advanced_Exams._08_Java_Advance_Regular_Exam_18_February_2023;

import java.util.*;

public class _01_Apocalypse_Preparation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] textilesInputs = scan.nextLine().split("\\s+");
        String[] medicamentsInputs = scan.nextLine().split("\\s+");

        ArrayDeque<Integer> textiles = new ArrayDeque<>();
        Stack<Integer> medicaments = new Stack<>();

        for (String textilesInput : textilesInputs) {
            textiles.offer(Integer.parseInt(textilesInput));
        }

        for (String medicamentsInput : medicamentsInputs) {
            medicaments.push(Integer.parseInt(medicamentsInput));
        }

        TreeMap<String, Integer> box = new TreeMap<>();
        box.put("Patch", 0);
        box.put("MedKit", 0);
        box.put("Bandage", 0);
        int patch = 0;
        int bandage = 0;
        int medKit = 0;

        while (!textiles.isEmpty() && !medicaments.isEmpty()) {

            int firstTextile = textiles.poll();
            int lastMedicament = medicaments.pop();
            int result = firstTextile + lastMedicament;

            if (result == 30) {
                box.put("Patch", box.get("Patch") + 1);
            } else if (result == 40) {
                box.put("Bandage", box.get("Bandage") + 1);
            } else if (result == 100) {
                box.put("MedKit", box.get("MedKit") + 1);
            } else {
                if (result > 100) {
                    box.put("MedKit", box.get("MedKit") + 1);
                    int difference = result - 100;
                    if (!medicaments.isEmpty()) {
                        medicaments.push(medicaments.pop() + difference);
                    }
                } else {
                    medicaments.push(lastMedicament + 10);
                }
            }
        }
        if (textiles.isEmpty() && medicaments.isEmpty()) {
            System.out.println("Textiles and medicaments are both empty.");
        } else if (textiles.isEmpty()) {
            System.out.println("Textiles are empty.");
        } else {
            System.out.println("Medicaments are empty.");
        }

        box.entrySet()
                .stream()
                .filter(e -> e.getValue() > 0) // Filter entries with values greater than 0
                .sorted((a, b) -> {
                    // First sort by value in descending order
                    int valueCompare = b.getValue().compareTo(a.getValue());
                    if (valueCompare != 0) {
                        return valueCompare;
                    }
                    // if values are equal, sort by key alphabetically
                    return a.getKey().compareTo(b.getKey());
                })
                .forEach(x -> System.out.println(x.getKey() + " - " + x.getValue()));


        if (!textiles.isEmpty()) {
            System.out.println("Textiles left: " + textiles.toString().replaceAll("\\[|\\]", ""));
        }
        if (!medicaments.isEmpty()) {
            ArrayList<Integer> reversedMedicaments = new ArrayList<>();
            while(!medicaments.isEmpty()) {
                reversedMedicaments.add(medicaments.pop());
            }

            System.out.println("Medicaments left: " + reversedMedicaments.toString().replaceAll("\\[|\\]", ""));
        }
    }
}
