package shelter;

import java.util.ArrayList;
import java.util.List;

public class Shelter {

    private int capacity;
    private List<Animal> data;

    public Shelter(int capacity) {
        setCapacity(capacity);
        this.data = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    //•	Method add(Animal animal) – adds an entity to the data if there is an empty cell for the animal.
    public void add(Animal animal) {
        if (getCount() < getCapacity()) {
            data.add(animal);
        }
    }

    //•	Method remove(String name) – removes the animal by given name, if such exists, and returns boolean.
    public boolean remove(String name) {
        return data.removeIf(a -> a.getName().equals(name));
    }

    //•	Method getAnimal(String name, String caretaker) – returns the animal with the given name and caretaker or null if no such animal exists.
    public Animal getAnimal(String name, String caretaker) {
        return data.stream().filter(a -> a.getName().equals(name) && a.getCaretaker().equals(caretaker)).findFirst().orElse(null);
    }

    //•	Method getOldestAnimal() – returns the oldest Animal.
    public Animal getOldestAnimal() {
        return data.stream().max((a, b) -> Integer.compare(a.getAge(), b.getAge())).orElse(null);
    }

    //•	Getter getCount – returns the number of animals.
    public int getCount() {
        return data.size();
    }

    //•	getStatistics() – returns a String in the following format:
    public String getStatistics() {
        StringBuilder report = new StringBuilder();
        report.append("The shelter has the following animals:").append(System.lineSeparator());
        for (Animal anim : data) {
            report.append(String.format("%s %s", anim.getName(), anim.getCaretaker())).append(System.lineSeparator());
        }
        return report.toString();
    }

}
