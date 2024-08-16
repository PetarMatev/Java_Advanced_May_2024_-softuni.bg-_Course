package Java_Advanced_May_2024._06_Defining_Classes._02_Exercise._05_Car_Salesman;

public class Engine {

    private String model;
    private int power;
    private int displacement;
    private String efficiency;

    public Engine(String model, int power) {
        this(model, power, -1, "n/a");
    }

    public Engine(String model, int power, int displacement) {
        this(model, power, displacement, "n/a");
    }

    public Engine(String model, int power, String efficiency) {
        this(model, power, -1, efficiency);
    }

    public Engine(String model, int power, int displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public String getModel() {
        return model;
    }

    public int getPower() {
        return power;
    }

    public String getDisplacement() {
        if (displacement == -1) {
            return "n/a";
        }
        String displacementTOString = displacement + "";
        return displacementTOString;
    }


    public String getEfficiency() {
        return efficiency;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "model='" + model + '\'' +
                ", power=" + power +
                ", displacement=" + displacement +
                ", efficiency='" + efficiency + '\'' +
                '}';
    }
}
