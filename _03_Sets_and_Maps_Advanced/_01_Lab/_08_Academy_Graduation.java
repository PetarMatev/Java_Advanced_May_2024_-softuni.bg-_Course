package Java_Advanced_May_2024._03_Sets_and_Maps_Advanced._01_Lab;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class _08_Academy_Graduation {

    public static Map<String, List<Double>> fillMap(Scanner scan) {
        Map<String, List<Double>> box = new TreeMap<>();
        int num = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < num; i++) {
            String name = scan.nextLine();
            ArrayList<Double> arr = Arrays
                    .stream(scan.nextLine().split("\\s+"))
                    .mapToDouble(Double::parseDouble)
                    .boxed()
                    .collect(Collectors.toCollection(ArrayList::new));
            box.putIfAbsent(name, arr);
        }
        return box;
    }

    public static String getAverageGrade(List<Double> grades) {
        double total = 0;
        for (int i=0; i < grades.size(); i++) {
            total += grades.get(i);
        }
        double averageGrade = total / grades.size();
        String formattedGrade = new DecimalFormat("#.################").format(averageGrade);

        return formattedGrade;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, List<Double>> academy = fillMap(scan);


        for(Map.Entry<String, List<Double>> entry : academy.entrySet()) {
            String name = entry.getKey();
            String averageGrade = getAverageGrade(entry.getValue());
            System.out.printf("%s is graduated with %s%n", name, averageGrade);
        }
    }
}
