package Java_Advanced_May_2024._03_Sets_and_Maps_Advanced._01_Lab;

import java.util.Scanner;
import java.util.TreeSet;

public class _02_SoftUni_Party {

    public static TreeSet<String> fillReservationList(Scanner scan) {
        TreeSet<String> reservationList = new TreeSet<>();
        String command = scan.nextLine();
        while (!command.equals("PARTY")) {
            String guest = command;
            reservationList.add(guest);
            command = scan.nextLine();
        }
        return reservationList;
    }

    public static void checkWhichGuestsParticipate(TreeSet<String> reservationList, Scanner scan) {
        String command = scan.nextLine();
        while (!command.equals("END")) {
            String guestName = command;
            reservationList.remove(guestName);
            command = scan.nextLine();
        }
    }

    public static void printFinalResult(TreeSet<String> reservationList) {
        System.out.println(reservationList.size());
        for (String item : reservationList) {
            System.out.println(item);
        }


    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        TreeSet<String> reservationList = fillReservationList(scan);
        checkWhichGuestsParticipate(reservationList, scan);
        printFinalResult(reservationList);
    }
}
