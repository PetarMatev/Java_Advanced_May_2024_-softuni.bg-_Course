package Java_Advanced_May_2024._03_Sets_and_Maps_Advanced._02_Exercise;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class _10_Logs_Aggregator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        TreeMap<String, TreeMap<String, LinkedList<Integer>>> box = new TreeMap<>();
        int num = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < num; i++) {
            String[] line = scan.nextLine().split("\\s+");
            String IP = line[0];
            String name = line[1];
            Integer log = Integer.parseInt(line[2]);
            box.putIfAbsent(name, new TreeMap<>());
            box.get(name).putIfAbsent(IP, new LinkedList<>());
            box.get(name).get(IP).add(log);
        }

        // Create a Map to store the list of all IPs for each User.
        Map<String, LinkedList<String>> listOfIP = new TreeMap<>();
        box.entrySet().stream().forEach(entry -> {
            listOfIP.putIfAbsent(entry.getKey(), new LinkedList<>());
            entry.getValue().entrySet().stream().forEach(newEntry ->
                    listOfIP.get(entry.getKey()).add(newEntry.getKey()));
        });

        // Create another Map to store the total logs aggregation per user.
        Map<String, AtomicInteger> collectedBox = new HashMap<>();
        box.entrySet().stream().forEach(entry -> {
            AtomicInteger total = new AtomicInteger();
            entry.getValue().entrySet().stream().forEach(boxy -> {
                boxy.getValue().forEach(total::addAndGet);
            });
            collectedBox.put(entry.getKey(), total);
        });


        // finally use the original Map to iterate over each
        // entry and apply the other two Maps to access desired info.

        box.entrySet().stream().forEach(entry -> {
            System.out.printf("%s: %s ", entry.getKey(), collectedBox.get(entry.getKey()));
            System.out.println(listOfIP.get(entry.getKey()));
        });
    }
}
