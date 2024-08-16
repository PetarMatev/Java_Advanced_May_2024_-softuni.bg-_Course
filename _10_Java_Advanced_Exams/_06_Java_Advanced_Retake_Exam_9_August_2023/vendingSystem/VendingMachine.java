package Java_Advanced_May_2024._10_Java_Advanced_Exams._06_Java_Advanced_Retake_Exam_9_August_2023.vendingSystem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class VendingMachine {
    private int buttonCapacity;
    private List<Drink> drinks;

    public VendingMachine(int buttonCapacity) {
        setButtonCapacity(buttonCapacity);
        this.drinks = new ArrayList<>();
    }

    public int getButtonCapacity() {
        return buttonCapacity;
    }

    public void setButtonCapacity(int buttonCapacity) {
        this.buttonCapacity = buttonCapacity;
    }

    //• getCount() - int - returns the number of drinks, available in the Vending machine.
    public int getCount() {
        return drinks.size();
    }

    //•	Method addDrink(Drink drink) – adds an entity to the collection of Drinks, if the Capacity allows it.
    public void addDrink(Drink drink) {
        if (getCount() < getButtonCapacity()) {
            drinks.add(drink);
        }
    }

    //•	Method removeDrink(String name) – removes a drink by given name, if such exists, and returns boolean (true if it is removed, otherwise – false)
    public boolean removeDrink(String name) {
        return drinks.removeIf(d -> d.getName().equals(name));
    }

    //•	Method getLongest() – returns the Drink with the biggest value of volume property.
    public Drink getLongest() {
        //return drinks.stream().max(Comparator.comparingInt(d1 -> d1.getVolume())).orElse(null);
        return drinks.stream().max(Comparator.comparing(Drink::getVolume)).orElse(null);
    }

    //•	Method getCheapest() – returns the Drink with the lowest value of price property.
    public Drink getCheapest() {
        return drinks.stream().min((d1, d2) -> Integer.compare(d1.getPrice().intValue(), d2.getPrice().intValue())).orElse(null);
        //return drinks.stream().min(Comparator.comparing(Drink::getPrice)).orElse(null);
    }

    //•	Method buyDrink(String name) - returns a string in the format of the overridden toString() method.
    public String buyDrink(String name) {
        //return drinks.stream().filter(e-> e.getName().equals(name)).findFirst().orElse(null).toString();
        return drinks.stream().filter(e->e.getName().equals(name)).findFirst().map(Drink::toString).orElse(null);
    }

    //•	Method report() – returns a string in the following format:
    public String report() {
        StringBuilder report = new StringBuilder();
        report.append("Drinks available:\n");
        for (Drink drink : drinks) {
            report.append(drink);
            report.append(System.lineSeparator());
        }
        return report.toString();
    }
}
