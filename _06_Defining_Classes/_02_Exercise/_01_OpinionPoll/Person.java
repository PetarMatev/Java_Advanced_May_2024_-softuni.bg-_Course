package Java_Advanced_May_2024._06_Defining_Classes._02_Exercise._01_OpinionPoll;

import java.util.Comparator;

public class Person implements Comparable<Person> {
    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Person(String name, int age) {
        setName(name);
        setAge(age);
    }

    @Override
    public String toString() {
        return String.format("%s - %d", this.name, this.age);
    }

    @Override
    public int compareTo(Person person) {
        return this.getName().compareTo(person.getName());
    }
}
