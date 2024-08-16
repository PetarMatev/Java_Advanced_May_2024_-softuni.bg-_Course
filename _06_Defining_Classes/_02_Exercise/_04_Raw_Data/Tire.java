package Java_Advanced_May_2024._06_Defining_Classes._02_Exercise._04_Raw_Data;

public class Tire {
    private double tyrePressure;
    private int tyreAge;
    private static double totalTyrePressure = 0;

    public Tire(double tyrePressure, int tyreAge) {
        this.tyrePressure = tyrePressure;
        this.tyreAge = tyreAge;
        totalTyrePressure += tyrePressure;
    }

    public static double getAvgTyrePressure() {
        double result = totalTyrePressure / 4;
        totalTyrePressure = 0;
        return result;
    }
}
