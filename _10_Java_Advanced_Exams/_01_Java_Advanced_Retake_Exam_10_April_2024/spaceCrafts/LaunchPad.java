package Java_Advanced_May_2024._10_Java_Advanced_Exams._01_Java_Advanced_Retake_Exam_10_April_2024.spaceCrafts;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LaunchPad {
    private String name;
    private int capacity;
    private List<Spacecraft> spacecrafts;

    public LaunchPad(String name, int capacity) {
        setName(name);
        setCapacity(capacity);
        spacecrafts = new ArrayList<>();
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

    // Method addSpacecraft(Spacecraft spacecraft) – adds an entity to the data if a space for it, otherwise print: "This launchpad is at full capacity!"
    public void addSpacecraft(Spacecraft spacecraft) {
        if (spacecrafts.size() < getCapacity()) {
            spacecrafts.add(spacecraft);
        } else {
            System.out.println("This launchpad is at full capacity!");
        }
    }

    // Method removeSpacecraft(String name) – removes a Spacecraft by given name, if such exists, and returns boolean (true if it is removed, otherwise – false)
    public boolean removeSpacecraft(String name) {
        if (spacecrafts.removeIf(e -> e.getName().equals(name))) {
            return true;
        } else {
            return false;
        }
    }

    // Method getHeaviestSpacecraft()– returns String the heaviest spacecraft by weight in the given launchpad in the following format
    public String getHeaviestSpacecraft() {
        if (spacecrafts.isEmpty()) {
            return "There are no spacecrafts to respond this criteria.";
        }
        Spacecraft heaviestSpaceCraft = spacecrafts.stream()
                .max((a, b) -> Integer.compare(a.getWeight(), b.getWeight()))
                .orElse(null);

        String heaviest = String.format("%s - %dkg.", heaviestSpaceCraft.getName(), heaviestSpaceCraft.getWeight());
        return heaviest;
    }

    // Method getSpacecraft(String name) – returns the spacecraft with the given name, otherwise – returns null
    public Spacecraft getSpacecraft(String name) {
        return spacecrafts.stream()
                .filter(e -> e.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    // Method getCount() – returns the count of spacecrafts in the given launchpad
    public int getCount() {
        return spacecrafts.size();
    }

    // Method getSpacecraftsByMissionType(String missionType) – returns List – a collection of
    // Spacecraft which holds the spacecrafts having the same missionType in the given launchpad.
    public List<Spacecraft> getSpacecraftsByMissionType(String missionType) {
        List<Spacecraft> identicalMissionList = spacecrafts
                .stream()
                .filter(s -> s.getMissionType().equals(missionType)).collect(Collectors.toList());

        return identicalMissionList;
    }

    // Method getStatistics() – returns a String in the following format (print the spacecrafts in order of addition):
    public String getStatistics() {
        StringBuilder thisString = new StringBuilder();
        thisString.append("Spacecrafts launched from " + this.name + ":\n");
        if (spacecrafts.size() > 0) {
            int counter = 1;
            for (Spacecraft spacecraft : spacecrafts) {
                thisString.append(counter + ". " + spacecraft.getName() + "\n");
                counter++;
            }
        } else {
            thisString.append("none");
        }

        return thisString.toString();
    }

}
