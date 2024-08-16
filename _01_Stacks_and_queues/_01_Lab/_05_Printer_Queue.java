package Java_Advanced_May_2024._01_Stacks_and_queues._01_Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _05_Printer_Queue {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<String> printerQueue = new ArrayDeque<>();
        String command = scan.nextLine();
        while(!command.equals("print")) {

            if (!command.equals("cancel")) {
                printerQueue.offer(command);
            } else {
                if (!printerQueue.isEmpty()) {
                    String item = printerQueue.pollFirst();
                    System.out.printf("Canceled %s\n", item);
                } else {
                    System.out.println("Printer is on standby");
                }
            }
            command = scan.nextLine();
        }

        printerQueue.forEach(System.out::println);
    }
}
