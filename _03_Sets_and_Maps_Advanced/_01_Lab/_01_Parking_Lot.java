package Java_Advanced_May_2024._03_Sets_and_Maps_Advanced._01_Lab;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class _01_Parking_Lot {

    public static void printResults(LinkedHashSet<String> parkingLot) {
        if (parkingLot.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for(String reg : parkingLot) {
                System.out.println(reg);
            }
        }
    }

    public static void fillParking(String command, LinkedHashSet<String> parkingLot) {
        String[] info = command.split(", ");
        String instruction = info[0];
        String registrationNumber = info[1];

        switch(instruction) {
            case "IN":
                parkingLot.add(registrationNumber);
                break;
            case "OUT":
                if (parkingLot.isEmpty()) {
                    System.out.println("Parking Lot is Empty");
                } else {
                    parkingLot.remove(registrationNumber);
                }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedHashSet<String> parkingLot = new LinkedHashSet<>();
        String command = scan.nextLine();
        while(!command.equals("END")) {
            fillParking(command, parkingLot);
            command = scan.nextLine();
        }
        printResults(parkingLot);
    }
}
