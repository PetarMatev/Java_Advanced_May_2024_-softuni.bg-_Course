package Java_Advanced_May_2024._08_Generics._01_Lab.p04_ListUtilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        Collections.addAll(integers, 1, 2, 3, 4, 5);

        Integer min = ListUtils.getMin(integers);
        Integer max = ListUtils.getMax(integers);
    }
}
