package Java_Advanced_May_2024._03_Sets_and_Maps_Advanced._01_Lab;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class _07_Cities_by_Continent_and_Country {

    public static Map<String, LinkedHashMap<String, LinkedList<String>>> filltheMap(Scanner scan) {
        Map<String, LinkedHashMap<String, LinkedList<String>>> box = new LinkedHashMap<>();
        int num = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < num; i++) {
            String[] line = scan.nextLine().split("\\s+");
            String continent = line[0];
            String country = line[1];
            String town = line[2];

            box.putIfAbsent(continent, new LinkedHashMap<String, LinkedList<String>>());
            box.get(continent).putIfAbsent(country, new LinkedList<String>());
            box.get(continent).get(country).add(town);
        }
        return box;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, LinkedHashMap<String, LinkedList<String>>> world = filltheMap(scan);

        world.forEach((continent, countryList) -> {
            System.out.printf("%s: %n", continent);
            countryList.forEach((country, townList) -> {
                System.out.printf("%s -> ", country);
                int townIndex = 0;
                for (String town : townList) {
                    System.out.printf("%s%s", town, townIndex < townList.size() - 1 ? ", " : "\n");
                    townIndex ++;
                }
            });
        });
    }
}

