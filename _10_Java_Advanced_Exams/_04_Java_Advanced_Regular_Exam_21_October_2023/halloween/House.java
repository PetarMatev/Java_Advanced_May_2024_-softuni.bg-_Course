package halloween;

import java.util.ArrayList;
import java.util.List;

public class House {
    private int capacity;
    private List<Kid> data;

    public House(int capacity) {
        setCapacity(capacity);
        data = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    //• Method addKid(Kid kid) – adds an entity to the data if there is an empty space for the kid.
    public void addKid(Kid kid) {
        if (data.size() < capacity) {
            data.add(kid);
        }
    }

    //•	Method removeKid(String name) – removes the kid by given name, if such exists, and returns boolean.
    public boolean removeKid(String name) {
        return data.removeIf(e -> e.getName().equals(name));
    }

    //•	Method getKid(String street) – returns the kid of a given street or null if no such kid exists.
    public Kid getKid(String street) {
        return data.stream().filter(e -> e.getStreet().equals(street)).findFirst().orElse(null);
    }

    //•	Getter getAllKids() – returns the number of kids.
    public int getAllKids() {
        return data.size();
    }

    //•	getStatistics() – returns a String in the following format:
    public String getStatistics() {
        StringBuilder stats = new StringBuilder();
        stats.append("Children who visited a house for candy:\n");
        data.forEach(e -> stats.append(String.format("%s from %s street\n", e.getName(), e.getStreet())));

        return stats.toString();
    }
}
