package Java_Advanced_May_2024._10_Java_Advanced_Exams._03_Java_Advanced_Retake_Exam_13_December_2023.fishingPond;

import java.util.ArrayList;
import java.util.List;

public class Pond {
    private int capacity;
    private List<Fish> fishes;

    public Pond(int capacity) {
        setCapacity(capacity);
        this.fishes = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    //• Method addFish(Fish fish) – adds an entity to the data if an empty space for it
    public void addFish(Fish fish) {
        if (fishes.size() < getCapacity()) {
            fishes.add(fish);
        }
    }

    //•	Method removeFish(String species) – removes a fish by given species, if such exists, and returns boolean (true if it is removed, otherwise – false)
    public boolean removeFish(String species) {
        return fishes.removeIf(currentFish -> currentFish.getSpecies().equals(species));
    }

    //•	Method getOldestFish()– returns the oldest fish
    public Fish getOldestFish() {
        return fishes.stream()
                .max((a, b) -> Integer.compare(a.getAge(), b.getAge())).orElse(null);
    }

    //•	Method getFish(String species) – returns the fish with the given species
    public Fish getFish(String species) {
        return fishes.stream()
                .filter(fish -> fish.getSpecies().equals(species)).findFirst().orElse(null);
    }

    //•	Method getCount – returns the number of fishes
    public int getCount() {
        return fishes.size();
    }

    //•	Method getVacancies – returns the number of remaining vacancies in the pond
    public int getVacancies() {
        return capacity - fishes.size();
    }

    //•	Method report() – returns a string in the following format (print the fishes in order of addition):
    public String report() {
        StringBuilder report = new StringBuilder();
        report.append("Fishes in the pond:\n");
        for (Fish fish : fishes) {
            report.append(String.format("This %s is %d years old and reproduces through %s.\n",
                    fish.getSpecies(), fish.getAge(), fish.getMatingSeason()));
        }
        return report.toString();
    }
}
