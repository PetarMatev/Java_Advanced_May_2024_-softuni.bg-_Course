package Java_Advanced_May_2024._05_Functional_Programming._01_Lab;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class _04_Add_VAT {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Double> prices = Arrays.stream(scan.nextLine()
                .split(",\\s+"))
                .mapToDouble(x->Double.parseDouble(x))
                .boxed()
                .collect(Collectors.toList());

        UnaryOperator<Double> getVAT = e -> e * 1.20;

        LinkedList<Double> pricesWithVAT = new LinkedList<>();
        prices.forEach(e -> pricesWithVAT.add(getVAT.apply(e)));
        System.out.println("Prices with VAT:");
        pricesWithVAT.forEach(e -> System.out.printf("%.2f%n", e));

    }
}
