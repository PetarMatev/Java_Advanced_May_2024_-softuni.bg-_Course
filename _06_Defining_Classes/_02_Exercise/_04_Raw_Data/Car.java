package Java_Advanced_May_2024._06_Defining_Classes._02_Exercise._04_Raw_Data;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tire tire;

    public Car(String model, int engineSpeed, int enginePower, int cargoWeight, String cargoType,
               double tyre1Pressure, int tyre1Age, double tyre2Pressure, int tyre2Age, double tyre3Pressure, int tyre3Age, double tyre4Pressure, int tyre4Age) {
        setModel(model);
        setEngine(engineSpeed, enginePower);
        setCargo(cargoWeight, cargoType);
        setTire(tyre1Pressure, tyre1Age);
        setTire(tyre2Pressure, tyre2Age);
        setTire(tyre3Pressure, tyre3Age);
        setTire(tyre4Pressure, tyre4Age);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(int engineSpeed, int enginePower) {
        this.engine = new Engine(engineSpeed, enginePower);
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(int cargoWeight, String cargoType) {
        this.cargo = new Cargo(cargoWeight, cargoType);
    }

    public Tire getTire() {
        return tire;
    }

    public void setTire(double tyrePressure, int tyreAge) {
        this.tire = new Tire(tyrePressure, tyreAge);
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", engine=" + engine +
                ", cargo=" + cargo +
                ", tire=" + tire +
                '}';
    }
}
