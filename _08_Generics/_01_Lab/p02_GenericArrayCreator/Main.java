package Java_Advanced_May_2024._08_Generics._01_Lab.p02_GenericArrayCreator;

public class Main {
    public static void main(String[] args) {
        String[] strings = ArrayCreator.create(10, "none");
        Integer[] integers = ArrayCreator.create(Integer.class,10, 0);
    }
}
