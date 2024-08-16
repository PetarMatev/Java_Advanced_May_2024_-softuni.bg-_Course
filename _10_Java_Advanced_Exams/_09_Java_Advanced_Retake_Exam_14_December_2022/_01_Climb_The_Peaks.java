package Java_Advanced_May_2024._10_Java_Advanced_Exams._09_Java_Advanced_Retake_Exam_14_December_2022;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class _01_Climb_The_Peaks {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] foodPortionsInput = scan.nextLine().split(", ");
        String[] staminaInput = scan.nextLine().split(", ");

        Stack<Integer> foodPortions = new Stack<>();
        ArrayDeque<Integer> stamina = new ArrayDeque<>();

        // Last in, First out --> therefore we use STACK:
        Stack<Integer> givenPeaks = new Stack<>();
        givenPeaks.push(70);
        givenPeaks.push(60);
        givenPeaks.push(100);
        givenPeaks.push(90);
        givenPeaks.push(80);


        for (String s : foodPortionsInput) {
            foodPortions.push(Integer.parseInt(s));
        }

        for (String x : staminaInput) {
            stamina.offer(Integer.parseInt(x));
        }

        LinkedList<String> peaks = new LinkedList<>();

        boolean allPeaksAchieved = false;

        for (int i = 0; i < 7; i++) {
            while (!foodPortions.isEmpty() && !stamina.isEmpty() && !givenPeaks.isEmpty()) {

                int currentFood = foodPortions.pop();
                int currentStamina = stamina.poll();
                int result = currentFood + currentStamina;

                int currentFozzod = givenPeaks.peek();

                if (result >= givenPeaks.peek()) {
                    int num = givenPeaks.pop();
                    switch (num) {
                        case 80:
                            peaks.add("Vihren");
                            break;
                        case 90:
                            peaks.add("Kutelo");
                            break;
                        case 100:
                            peaks.add("Banski Suhodol");
                            break;
                        case 60:
                            peaks.add("Polezhan");
                            break;
                        case 70:
                            peaks.add("Kamenitza");
                            break;
                    }
                }

                if (peaks.size() == 5) {
                    allPeaksAchieved = true;
                    break;
                }
            }
        }


        if (allPeaksAchieved) {
            System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");
        } else {
            System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");
        }

        if (peaks.size() > 0) {
            System.out.println("Conquered peaks:");
            for (String peak : peaks) {
                System.out.println(peak);
            }
        }
    }
}
