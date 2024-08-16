package Java_Advanced_May_2024._06_Defining_Classes._01_Lab.Constructors;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Integer num = Integer.parseInt(scan.nextLine());
        ArrayList<Car> listOfCars = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            String[] info = scan.nextLine().split("\\s+");
            if (info.length == 1) {
                Car currentCar = new Car(info[0]);
                listOfCars.add(currentCar);
            } else {
                String brand = info[0];
                String model = info[1];
                int horsepower = Integer.parseInt(info[2]);
                Car currentCar = new Car(brand, model, horsepower);
                listOfCars.add(currentCar);
            }
        }

        listOfCars.forEach(e -> System.out.println(e.carInfo()));
    }
}
