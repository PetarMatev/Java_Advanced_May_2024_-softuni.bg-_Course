package Java_Advanced_May_2024._01_Stacks_and_queues._02_Exercise;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayDeque;
import java.util.Scanner;


public class _10_Robotics {
    public static void addRobots(String line, ArrayDeque<String> stack) {
        int number = line.split(";").length;
        if (number != 1) {
            String[] robots = line.split(";");
            for (int i = 0; i < robots.length; i++) {
                String robot = robots[i] + " available";
                stack.offer(robot);
            }
        } else {
            stack.offer(line + " available");
        }
    }


    public static String provideTime(String currentTime, int timeToAdd) {
        // Create a formatter to parse the time string
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime time = LocalTime.parse(currentTime, formatter);
        LocalTime newTime = time.plusSeconds(timeToAdd);
        return newTime.format(formatter);
    }

    public static String getAvailableTimeRobot(String robotString, String time) {
        String robotName = robotString.split("-")[0];
        String string = robotString.split("-")[1];
        int robotAddedTime = Integer.parseInt(string.split(" ")[0]);
        String realTime = provideTime(time, robotAddedTime);
        String robot = robotName + "-" + robotAddedTime + " " + realTime;
        return robot;
    }

    public static String returnFormattedTime(String time) {
        if (time.length() == 7) {
            time = "0" + time;
        }
        return time;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        ArrayDeque<String> stack = new ArrayDeque<>();
        addRobots(line, stack);
        String time = returnFormattedTime(scan.nextLine());
        ArrayDeque<String> products = new ArrayDeque<>();
        boolean noMoreProducts = false;

        String command = scan.nextLine();
        while (!command.equals("End")) {
            products.offer(command);
            noMoreProducts = false;
            while (!noMoreProducts) {
                String product = products.pop();
                while (true) {
                    time = provideTime(time, 1);
                    String robot = stack.poll();
                    String ifAvailable = robot.split(" ")[1];
                    if (ifAvailable.equals("available")) {
                        String name = robot.split("-")[0];
                        System.out.println(name + " - " + product + " [" + time + "]");
                        String robotNew = getAvailableTimeRobot(robot, time);
                        stack.offer(robotNew);
                        if (products.isEmpty()) {
                            noMoreProducts = true;
                            break;
                        } else {
                            product = products.poll();
                            break;
                        }

                    } else {
                        if (time.equals(ifAvailable)) {
                            String name = robot.split("-")[0];
                            System.out.println(name + " - " + product + " [" + time + "]");
                            String robotNew = getAvailableTimeRobot(robot, time);
                            stack.offer(robotNew);
                            if (products.isEmpty()) {
                                noMoreProducts = true;
                                break;
                            } else {
                                product = products.poll();
                                break;
                            }

                        } else {
                            stack.offer(robot);
                            products.offer(product);
                            product = products.poll();
                            break;
                        }
                    }
                }

            }


            command = scan.nextLine();
        }
    }
}
