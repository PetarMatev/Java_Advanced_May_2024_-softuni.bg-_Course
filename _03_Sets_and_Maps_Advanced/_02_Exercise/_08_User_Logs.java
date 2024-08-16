package Java_Advanced_May_2024._03_Sets_and_Maps_Advanced._02_Exercise;

import java.util.*;

public class _08_User_Logs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Map<String, ArrayList<String>>> box = new TreeMap<>();
        String command = scan.nextLine();

        // filling the nested map with the details
        while (!command.equals("end")) {
            String[] line = command.split("\\s+");
            String IP = line[0].split("=")[1];
            String message = line[1].split("=")[1];
            String user = line[2].split("=")[1];
            box.putIfAbsent(user, new LinkedHashMap<>());
            box.get(user).putIfAbsent(IP, new ArrayList<>());
            box.get(user).get(IP).add(message);

            command = scan.nextLine();
        }

        // printing out final result
        for (Map.Entry<String, Map<String, ArrayList<String>>> entry : box.entrySet()) {
            String currentUser = entry.getKey();
            System.out.printf("%s: %n", currentUser);
            ArrayList<String> currentList = new ArrayList<>();
            for (Map.Entry<String, ArrayList<String>> levelTwoEntry : entry.getValue().entrySet()) {
                String currentIP = levelTwoEntry.getKey();
                int numMessages = levelTwoEntry.getValue().size();

                if (entry.getValue().size() <= 1) {
                    System.out.printf("%s => %d.%n", currentIP, numMessages);
                } else {
                    String currentLine = currentIP + " => " + numMessages;
                    currentList.add(currentLine);
                }
            }

            if(!currentList.isEmpty()) {
                for (int i = 0; i < currentList.size(); i++) {
                    if (i < currentList.size()-1) {
                        System.out.printf("%s, ", currentList.get(i));
                    } else {
                        System.out.printf("%s.%n", currentList.get(i));
                    }
                }
            }

        }
    }
}