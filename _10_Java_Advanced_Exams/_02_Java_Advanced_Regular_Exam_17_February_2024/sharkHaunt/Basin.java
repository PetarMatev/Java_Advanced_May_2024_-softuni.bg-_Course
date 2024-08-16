package Java_Advanced_May_2024._10_Java_Advanced_Exams._02_Java_Advanced_Regular_Exam_17_February_2024.sharkHaunt;

import java.util.ArrayList;
import java.util.List;

public class Basin {
    private String name;
    private int capacity;
    private List<Shark> sharks;

    public Basin(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.sharks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    //• Method addShark(Shark shark) – adds an entity to the data if a space for it, otherwise print: "This basin is at full capacity!"
    public void addShark(Shark shark) {
        if (sharks.size() < getCapacity()) {
            sharks.add(shark);
        } else {
            System.out.println("This basin is at full capacity!");
        }
    }

    //•	Method removeShark(String kind) – removes a shark by given kind, if such exists, and returns boolean (true if it is removed, otherwise – false)
    public boolean removeShark(String kind) {
        return sharks.removeIf(e -> e.getKind().equals(kind));
    }

    //•	Method getLargestShark()– returns the largest shark by length in the given basin
    public Shark getLargestShark() {
        return sharks.stream()
                .max((a, b) -> Integer.compare(a.getLength(), b.getLength())).orElse(null);
    }
    //•	Method getShark(String kind) – returns the shark with the given kind, otherwise – returns null
    public Shark getShark(String kind) {
        return sharks.stream().filter(e -> e.getKind().equals(kind)).findFirst().orElse(null);
    }

    //•	Method getCount – returns the count of sharks in the given basin
    public int getCount() {
        return sharks.size();
    }

    //•	Method getAverageLength – returns integer - the average length of the sharks in the given basin
    public int getAverageLength() {
        double average = sharks.stream().mapToInt(Shark::getLength).average().orElse(0);
        return (int) average;
    }

    //•	Method report() – returns a string in the following format (print the sharks in order of addition):
    public String report() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Sharks in %s:\n", this.name));
        for (Shark shark : sharks) {
            res.append(String.format("The %s is %d centimeters long, eats %s and inhabits %s.\n",
                    shark.getKind(), shark.getLength(), shark.getFood(), shark.getHabitation()));
        }
        return res.toString();
    }
}
