package Java_Advanced_May_2024._10_Java_Advanced_Exams._07_Java_Advance_Retake_Exam_12_April_2023.magazine;

import java.util.ArrayList;
import java.util.List;

public class Magazine {

    private String type;
    private int capacity;
    private List<Cloth> data;


    public Magazine(String type, int capacity) {
        setType(type);
        setCapacity(capacity);
        this.data = new ArrayList<>();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    //•	Method addCloth(Cloth cloth) – adds an entity to the data if there is room for it
    public void addCloth(Cloth cloth) {
        if (getCount() < getCapacity()) {
            data.add(cloth);
        }
    }

    //•	Method removeCloth(String color) – removes a cloth by given color, if such exists, and returns boolean (true if it is removed, otherwise – false)
    public boolean removeCloth(String color) {
        return data.removeIf(c -> c.getColor().equals(color));
    }

    //•	Method getSmallestCloth() – returns the smallest cloth
    public Cloth getSmallestCloth() {
        return data.stream().min((c1,c2) -> Integer.compare(c1.getSize(), c2.getSize())).orElse(null);
    }

    //•	Method getCloth(String color) – returns the cloth with the given color
    public Cloth getCloth(String color) {
        return data.stream().filter(c -> c.getColor().equals(color)).findFirst().orElse(null);
    }

    //•	Method getCount – returns the number of clothes
    public int getCount() {
        return data.size();
    }

    //•	Method report() – returns a string in the following format (print the clothes in order of appearance):
    public String report() {
        StringBuilder report = new StringBuilder();
        report.append(String.format("%s Java_Advanced_May_2024._10_Java_Advanced_Exams._07_Java_Advance_Retake_Exam_12_April_2023.magazine contains:%n", getType()));
        for (Cloth cloth : data) {
            report.append(cloth).append(System.lineSeparator());
        }
        return report.toString().trim();
    }
}
