package Java_Advanced_May_2024._08_Generics._01_Lab.GenericScale;

public class Main {
    public static void main(String[] args) {
        Scale<String> stringScale = new Scale<>("a", "c");
        System.out.println(stringScale.getHeavier());
    }
}