package Java_Advanced_May_2024._06_Defining_Classes._01_Lab.Car;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Integer num = Integer.parseInt(scan.nextLine());
        ArrayList<Car> listOfCars = new ArrayList<>();
        for (int i=0; i < num; i++) {
            String[] info = scan.nextLine().split("\\s+");
            Car curentCar = new Car();
            curentCar.setBrand(info[0]);
            curentCar.setModel(info[1]);
            curentCar.setHorsepower(Integer.parseInt(info[2]));
            listOfCars.add(curentCar);
        }

        listOfCars.forEach( e -> System.out.println(e.carInfo()));
    }
}
