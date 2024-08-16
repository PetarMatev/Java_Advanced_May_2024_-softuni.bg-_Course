package Java_Advanced_May_2024._10_Java_Advanced_Exams._15_Java_Advanced_22_June_2024.Templates;

import java.util.*;

public class _01_Question {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] packageInput = scan.nextLine().split("\\s+");
        String[] couriersInput = scan.nextLine().split("\\s+");
        ArrayDeque<Integer> couriersQueue = new ArrayDeque<>(); // start from the first courier // First-in-First-Out //
        ArrayDeque<Integer> packagesStack = new ArrayDeque<>(); // start from the last package. // Last-in-First-Out
        for (String s : couriersInput) {
            couriersQueue.offer(Integer.parseInt(s));
        }
        for (String s : packageInput) {
            packagesStack.push(Integer.parseInt(s));
        }

        int totalWeight = 0;
        while (!couriersQueue.isEmpty() && !packagesStack.isEmpty()) {
            Integer firstcourierCapacity = couriersQueue.poll();
            Integer packageWeight = packagesStack.pop();
            if (firstcourierCapacity >= packageWeight) {
                totalWeight += packageWeight;
                if (firstcourierCapacity > packageWeight) {
                    int newCourierCapacity = firstcourierCapacity - (2 * packageWeight);
                    if (newCourierCapacity > 0) {
                        couriersQueue.offer(newCourierCapacity);
                    }
                }
            } else {
                int differenceInWeight = packageWeight - firstcourierCapacity;
                packagesStack.push(differenceInWeight);
                totalWeight += firstcourierCapacity;
            }
        }

        System.out.printf("Total weight: %d kg%n", totalWeight);

        if (couriersQueue.isEmpty() && packagesStack.isEmpty()) {
            System.out.println("Congratulations, all packages were delivered successfully by the couriers today.");
        }

        if (!packagesStack.isEmpty() && couriersQueue.isEmpty()) {
            System.out.print("Unfortunately, there are no more available couriers to deliver the following packages: ");
            System.out.print(packagesStack.reversed().toString().replaceAll("[\\[|\\]]", ""));
        }

        if (!couriersQueue.isEmpty() && packagesStack.isEmpty()) {
            System.out.print("Couriers are still on duty: ");
            System.out.println(couriersQueue.toString().replaceAll("[\\[\\]]", "") + " but there are no more packages to deliver.");
        }
    }
}

