package Java_Advanced_May_2024._06_Defining_Classes._02_Exercise._05_Car_Salesman;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());

        Map<String, Engine>  listOfEngines =  new LinkedHashMap<>();
        LinkedList<Car> listOfCars =  new LinkedList<>();

        for (int i = 0; i < num; i++) {
            String[] info = scan.nextLine().split("\\s+");
            String engineModel = info[0];
            int enginePower = Integer.parseInt(info[1]);
            Engine engine = null;
            if (info.length == 2) {
                engine = new Engine(engineModel, enginePower);
            } else if (info.length == 3) {
                if (Character.isDigit(info[2].charAt(0))) {
                    int engineDisplacement = Integer.parseInt(info[2]);
                    engine = new Engine(engineModel, enginePower, engineDisplacement, "n/a");
                } else {
                    String engineEfficiency = info[2];
                    engine = new Engine(engineModel, enginePower, -1, engineEfficiency);
                }
            } else if (info.length ==4) {
                int engineDisplacement = Integer.parseInt(info[2]);
                String engineEfficiency = info[3];
                engine = new Engine(engineModel, enginePower, engineDisplacement, engineEfficiency);
            }
            listOfEngines.putIfAbsent(engineModel, engine);
        }

        int numCars = Integer.parseInt(scan.nextLine());
        for (int i=0; i< numCars; i++) {
            String[] command = scan.nextLine().split("\\s+");
            int length = command.length;
            String model = command[0];
            String currentEngine = command[1];
            Car car = null;
            if (length == 2) {
                car = new Car(model, listOfEngines.get(currentEngine));
            } else if (length == 3) {
                if (Character.isDigit(command[2].charAt(0))) {
                    int weight = Integer.parseInt(command[2]);
                    car = new Car(model, listOfEngines.get(currentEngine), weight, "n/a");
                } else {
                    String color = command[2];
                    car = new Car(model, listOfEngines.get(currentEngine), -1, color);
                }
            } else if (length ==4) {
                int weight = Integer.parseInt(command[2]);
                String color = command[3];
                car = new Car(model, listOfEngines.get(currentEngine), weight, color);
            }
            listOfCars.add(car);

        }
        listOfCars.forEach(System.out::println);
    }
}
