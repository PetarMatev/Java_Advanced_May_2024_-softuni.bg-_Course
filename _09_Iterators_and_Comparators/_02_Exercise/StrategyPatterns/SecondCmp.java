package Java_Advanced_May_2024._09_Iterators_and_Comparators.StrategyPatterns;


import java.util.Comparator;

public class SecondCmp implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}