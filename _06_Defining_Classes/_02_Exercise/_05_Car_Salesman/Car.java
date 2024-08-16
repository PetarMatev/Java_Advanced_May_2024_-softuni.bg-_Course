package Java_Advanced_May_2024._06_Defining_Classes._02_Exercise._05_Car_Salesman;

public class Car {
    private String model;
    private Engine engine;
    private int weight;
    private String color;

    public Car(String model, Engine engine) {
        this(model, engine, -1, "n/a");
    }

    public Car(String model, Engine engine, int weight) {
        this(model, engine, weight, "n/a");
    }

    public Car(String model, Engine engine, String color) {
        this(model, engine, -1, color);
    }

    public Car(String model, Engine engine, int weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public String getWeight() {

        if (weight == -1) {
            return "n/a";
        }
        String stringOfWeight = weight + "";
        return stringOfWeight;
    }


    public String getColor() {
        return color;
    }


    @Override
    public String toString() {
        return String.format("%s:%n" +
                "%s:%n" +
                "Power: %d%n" +
                "Displacement: %s%n" +
                "Efficiency: %s%n" +
                "Weight: %s%n" +
                "Color: %s", getModel(),
                getEngine().getModel(),
                getEngine().getPower(),
                getEngine().getDisplacement(),
                getEngine().getEfficiency(),
                getWeight(),
                getColor());
    }

}
