package Java_Advanced_May_2024._09_Iterators_and_Comparators.StrategyPatterns;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%s %d", name, age);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}