package Java_Advanced_May_2024._09_Iterators_and_Comparators.StrategyPatterns;

import java.util.Comparator;

public class FirstCmp implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        if (o1.getName().length() == o2.getName().length()) {
            return Character.compare(o1.getName().toLowerCase().charAt(0), o2.getName().toLowerCase().charAt(0));
        }
        return Integer.compare(o1.getName().length(), o2.getName().length());
    }
}