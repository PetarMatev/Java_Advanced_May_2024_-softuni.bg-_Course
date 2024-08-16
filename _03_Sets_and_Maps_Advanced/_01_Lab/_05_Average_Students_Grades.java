package Java_Advanced_May_2024._03_Sets_and_Maps_Advanced._01_Lab;

import java.util.*;
import java.util.stream.Collectors;

public class _05_Average_Students_Grades {

    public static Map<String, ArrayList<Double>> fillMap(Scanner scan) {
        int num = Integer.parseInt(scan.nextLine());
        Map<String, ArrayList<Double>> box = new TreeMap<>();

        for (int i = 0; i < num; i++) {
            String[] line = scan.nextLine().split("\\s+");
            String name = line[0];
            double grade = Double.parseDouble(line[1]);

            box.putIfAbsent(name, new ArrayList<>());
            ArrayList<Double> studentGrades = box.get(name);
            studentGrades.add(grade);
            box.put(name, studentGrades);
        }

        return box;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, ArrayList<Double>> studentList = fillMap(scan);

        for(Map.Entry<String, ArrayList<Double>> entry : studentList.entrySet()) {
            String studentName = entry.getKey();
            System.out.print(studentName + " -> ");
            double avg = 0;
            for (int i=0; i < entry.getValue().size(); i++) {
                double currentGrade = entry.getValue().get(i);
                avg += currentGrade;
                System.out.printf("%.2f ", currentGrade);
            }
            System.out.printf("(avg: %.2f)%n", avg/entry.getValue().size());
        }
    }
}
