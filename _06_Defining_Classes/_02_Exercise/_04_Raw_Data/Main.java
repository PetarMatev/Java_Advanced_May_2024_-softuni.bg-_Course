package Java_Advanced_May_2024._06_Defining_Classes._02_Exercise._04_Raw_Data;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());

        LinkedList<Car> listOfCars = new LinkedList<>();

        for (int i = 0; i < num; i++) {
            String[] info = scan.nextLine().split("\\s+");
            String model = info[0];
            int engineSpeed = Integer.parseInt(info[1]);
            int enginePower = Integer.parseInt(info[2]);
            int cargoWeight = Integer.parseInt(info[3]);
            String cargoType = info[4];
            double tyre1Pressure = Double.parseDouble(info[5]);
            int tyre1Age = Integer.parseInt(info[6]);
            double tyre2Pressure = Double.parseDouble(info[7]);
            int tyre2Age = Integer.parseInt(info[8]);
            double tyre3Pressure = Double.parseDouble(info[9]);
            int tyre3Age = Integer.parseInt(info[10]);
            double tyre4Pressure = Double.parseDouble(info[11]);
            int tyre4Age = Integer.parseInt(info[12]);

            Car car = new Car(model, engineSpeed, enginePower, cargoWeight, cargoType,
                    tyre1Pressure, tyre1Age, tyre2Pressure, tyre2Age, tyre3Pressure, tyre3Age, tyre4Pressure, tyre4Age);
            listOfCars.add(car);
        }

        String searchedType = scan.nextLine();

        if (searchedType.equals("fragile")) {
            listOfCars.stream()
                    .filter(car -> car.getCargo().getCargoType().equals(searchedType))
                    .filter(car -> Tire.getAvgTyrePressure() < 1)
                    .forEach(currentCar -> System.out.println(currentCar.getModel()));
        } else {
            listOfCars.stream()
                    .filter(car -> car.getCargo().getCargoType().equals(searchedType))
                    .filter(car -> car.getEngine().getEnginePower() > 250)
                    .forEach(currentCar -> System.out.println(currentCar.getModel()));
        }
    }
}
