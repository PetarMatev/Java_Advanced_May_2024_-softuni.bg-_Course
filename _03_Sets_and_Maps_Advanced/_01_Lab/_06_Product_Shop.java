package Java_Advanced_May_2024._03_Sets_and_Maps_Advanced._01_Lab;

import java.util.*;
import java.util.stream.Collectors;

public class _06_Product_Shop {

    public static Map<String, LinkedHashMap<String, Double>> fillStore (Scanner scan) {
        Map<String, LinkedHashMap<String, Double>> box = new TreeMap<>();
        String command = scan.nextLine();
        while(!command.equals("Revision")) {
            String[] line = command.split(",\\s+");
            String shop = line[0];
            String product = line[1];
            double price = Double.parseDouble(line[2]);
            box.putIfAbsent(shop, new LinkedHashMap<String, Double>());
            box.get(shop).put(product, price);
            command = scan.nextLine();
        }
        return box;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, LinkedHashMap<String, Double>> shops = fillStore(scan);

        for(Map.Entry<String, LinkedHashMap<String, Double>> entry : shops.entrySet()) {
            System.out.println(entry.getKey() + "->");
            entry.getValue().forEach((product, price) -> System.out.printf("Product: %s, Price: %.1f%n", product, price));
        }
    }
}
