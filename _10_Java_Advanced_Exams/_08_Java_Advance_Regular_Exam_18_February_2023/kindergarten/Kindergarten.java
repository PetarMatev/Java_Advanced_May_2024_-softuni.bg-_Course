package Java_Advanced_May_2024._10_Java_Advanced_Exams._08_Java_Advance_Regular_Exam_18_February_2023.kindergarten;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Kindergarten {

    private String name;
    private int capacity;
    private List<Child> registry;

    public Kindergarten(String name, int capacity) {
        setName(name);
        setCapacity(capacity);
        this.registry = new ArrayList<>();
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

    //•	Method	 addChild(Child child) - Adds a child to the registry if there is room for it and returns true. If there is no room for another child, returns false.
    public boolean addChild(Child child) {

        if (registry.size() < capacity) {
            registry.add(child);
            return true;
        }
        return false;
    }

    //•	Method removeChild(String firstName) - removes a child by a given firstName. If removal is successful, returns true, otherwise, returns false.
    public boolean removeChild(String firstName) {
        return registry.removeIf(c -> c.getFirstName().equals(firstName));
    }

    //•	Getter getChildrenCount - Returns the number of all children registered.
    public int getChildrenCount() {
        return registry.size();
    }

    //•	Method getChild(String firstName) - Returns the child with the given first name.
    public Child getChild(String firstName) {
        return registry.stream().filter(c -> c.getFirstName().equals(firstName)).findFirst().orElse(null);
    }

    //•	Method registryReport() – Orders the children by age ascending,
    // then by first name ascending,
    // then by last name ascending,
    // and returns a String in the following format:
    //o	"Registered children in {kindergartenName}:
    public String registryReport() {
        List<Child> sortedRegistry = this.registry.stream()
                .sorted(Comparator.comparingInt(Child::getAge)
                        .thenComparing(Child::getFirstName)
                        .thenComparing(Child::getLastName))
                .collect(Collectors.toList());

        StringBuilder report = new StringBuilder();
        report.append(String.format("Registered children in %s:%n", getName()));

        for (Child c : sortedRegistry) {
            report.append("--").append(System.lineSeparator());
            report.append(c).append(System.lineSeparator());
        }
        return report.toString().trim();
    }
}
