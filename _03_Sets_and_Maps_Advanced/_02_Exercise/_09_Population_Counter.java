package Java_Advanced_May_2024._03_Sets_and_Maps_Advanced._02_Exercise;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _09_Population_Counter {

    public static LinkedHashMap<String, LinkedHashMap<String, Long>> fillMap(Scanner scan) {
        LinkedHashMap<String, LinkedHashMap<String, Long>> box = new LinkedHashMap<>();

        String command = scan.nextLine();
        while (!command.equals("report")) {
            String[] line = command.split("\\|");
            String town = line[0];
            String country = line[1];
            Long population = (long) Integer.parseInt(line[2]);

            box.putIfAbsent(country, new LinkedHashMap<>());
            box.get(country).putIfAbsent(town, population);

            command = scan.nextLine();
        }

        return box;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedHashMap<String, LinkedHashMap<String, Long>> countryPopulation = fillMap(scan);
        Map<String, Long> sortedCountries = new LinkedHashMap<>();

        for (Map.Entry<String, LinkedHashMap<String, Long>> entry : countryPopulation.entrySet()) {
            long totalPopulation = 0L;
            for (Map.Entry<String, Long> valueEntry : entry.getValue().entrySet()) {
                Long currentPopulation = valueEntry.getValue();
                totalPopulation += currentPopulation;
            }
            sortedCountries.put(entry.getKey(), totalPopulation);
        }

        sortedCountries.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(entry -> {
                            System.out.printf("%s (total population: %d)\n", entry.getKey(), entry.getValue());
                            countryPopulation.get(entry.getKey())
                                    .entrySet()
                                    .stream()
                                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                                    .forEach(pair -> {
                                        System.out.printf("=>%s: %d%n", pair.getKey(), pair.getValue());
                                    });
                        }
                );
    }
}
