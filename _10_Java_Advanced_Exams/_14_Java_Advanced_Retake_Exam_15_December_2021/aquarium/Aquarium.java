package Java_Advanced_May_2024._10_Java_Advanced_Exams._14_Java_Advanced_Retake_Exam_15_December_2021.aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {

    private String name;
    private int capacity;
    private int size;
    private List<Fish> fishInPool;


    public Aquarium(String name, int capacity, int size) {
        setName(name);
        setCapacity(capacity);
        setSize(size);
        this.fishInPool = new ArrayList<>();
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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getFishInPool() {
        return fishInPool.size();
    }


    public void add(Fish fish) {
        if (getFishInPool() < capacity) {
            if (!fishInPool.contains(fish)) {
                fishInPool.add(fish);
            }
        }
    }

    public boolean remove(String name) {
        return fishInPool.removeIf(f -> f.getName().equals(name));
    }

    public Fish findFish(String name) {
        return fishInPool.stream().filter(f -> f.getName().equals(name)).findFirst().orElse(null);
    }

    public String report() {
        StringBuilder report = new StringBuilder();
        report.append(String.format("Aquarium: %s ^ Size: %d%n", getName(), getSize()));
        for (Fish fish : fishInPool) {
            report.append(fish).append(System.lineSeparator());
        }
        return report.toString();
    }
}
