package Java_Advanced_May_2024._06_Defining_Classes._02_Exercise._03_Speed_Racing;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayList<Car> listOfCars = new ArrayList<>();

        int num = Integer.parseInt(scan.nextLine());
        for (int i=0; i < num; i++) {

            String[] info = scan.nextLine().split("\\s+");
            String brand = info[0];
            int fuelAmount = Integer.parseInt(info[1]);
            double fuelCostFor1km = Double.parseDouble(info[2]);
            Car car = new Car(brand,fuelAmount, fuelCostFor1km);
            listOfCars.add(car);
        }


        String command = scan.nextLine();
        while(!command.equals("End")) {
            String[] information = command.split("\\s+");
            String currentBrand = information[1];
            int distanceToTravel = Integer.parseInt(information[2]);

            listOfCars.forEach(car -> {
                if (car.getModel().equals(currentBrand)) {
                    car.drive(distanceToTravel);
                }
            }

            );


            command = scan.nextLine();
        }


        listOfCars.forEach(System.out::println);

    }
}
