package Java_Advanced_May_2024._10_Java_Advanced_Exams._15_Java_Advanced_22_June_2024.vintageLocos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TrainStation {
    private String name;
    private int capacity;
    private int railGauge;
    private List<Locomotive> locomotives;

    public TrainStation(String name, int capacity, int railGauge) {
        setName(name);
        setCapacity(capacity);
        setRailGauge(railGauge);
        this.locomotives = new ArrayList<>();
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

    public int getRailGauge() {
        return railGauge;
    }

    public void setRailGauge(int railGauge) {
        this.railGauge = railGauge;
    }

    public void addLocomotive(Locomotive locomotive) {
        if (locomotives.size() < getCapacity() && locomotive.getGauge()==getRailGauge()) {
            locomotives.add(locomotive);
        }

        if (locomotives.size() >= getCapacity()) {
            System.out.println("This train station is full!");
        }

        if (locomotive.getGauge()!= getRailGauge()) {
            int difference = Math.abs(locomotive.getGauge() - getRailGauge());
            System.out.printf("The rail gauge of this station does not match the locomotive gauge! Difference: %d mm.%n", difference);
        }
    }

    public boolean removeLocomotive(String name) {
        return locomotives.removeIf(l -> l.getName().equals(name));
    }

    public String getFastestLocomotive() {

        if (locomotives.isEmpty()) {
            return "There are no locomotives.";
        } else {
            Locomotive fastest = locomotives.stream().max(Comparator.comparingInt(Locomotive::getMaxSpeed)).orElse(null);
            return String.format("%s is the fastest locomotive with a maximum speed of %d km/h.",
                    fastest.getName(), fastest.getMaxSpeed());
        }
    }

    public Locomotive getLocomotive(String name) {
        return locomotives.stream().filter(e -> e.getName().equals(name)).findFirst().orElse(null);
    }

    public int getCount() {
        return locomotives.size();
    }

    public String getOldestLocomotive() {

        if (locomotives.isEmpty()) {
            return "There are no locomotives.";
        } else {
            Locomotive theOldest = locomotives.stream().min(Comparator.comparing(Locomotive::getBuildDate)).orElse(null);
            return String.format("%s", theOldest.getName());
        }
    }

    public String getStatistics() {
        int counter = 1;
        StringBuilder report = new StringBuilder();
        report.append(String.format("Locomotives departed from %s:%n", getName()));
        for (Locomotive locomotive : locomotives) {
            report.append(String.format("%d. %s", counter, locomotive.getName())).append(System.lineSeparator());
            counter++;
        }

        if (locomotives.isEmpty()) {
            return String.format("There are no locomotives departing from %s station.", getName());
        } else {
            return report.toString();
        }
    }
}
