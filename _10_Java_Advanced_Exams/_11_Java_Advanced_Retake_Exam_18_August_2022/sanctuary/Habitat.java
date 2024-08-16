package sanctuary;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Habitat {

    private int capacity;
    private List<Elephant> data;

    public Habitat(int capacity) {
        setCapacity(capacity);
        this.data = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void add(Elephant elephant) {
        if (this.data.size() < getCapacity()) {
            data.add(elephant);
        }
    }

    public boolean remove(String name) {
        return data.removeIf(e -> e.getName().equals(name));
    }
    public Elephant getElephant(String retiredFrom) {
        return data.stream().filter(e-> e.getRetiredFrom().equals(retiredFrom)).findFirst().orElse(null);
    }

    public Elephant getOldestElephant() {
        return data.stream().max(Comparator.comparingInt(Elephant::getAge)).orElse(null);
    }

    public int getAllElephants() {
        return data.size();
    }

    public String getReport() {
        StringBuilder report = new StringBuilder();
        report.append("Saved elephants in the park:").append(System.lineSeparator());
        for (Elephant eleph : data) {
            report.append(String.format("%s came from: %s", eleph.getName(), eleph.getRetiredFrom())).append(System.lineSeparator());
        }
        return report.toString();
    }
}
