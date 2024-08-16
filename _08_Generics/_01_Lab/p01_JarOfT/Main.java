package Java_Advanced_May_2024._08_Generics._01_Lab.p01_JarOfT;

public class Main {
    public static void main(String[] args) {

        Jar<String> jar = new Jar<>();

        jar.add("Computer");
        jar.add("AI");
        jar.remove();
    }
}
