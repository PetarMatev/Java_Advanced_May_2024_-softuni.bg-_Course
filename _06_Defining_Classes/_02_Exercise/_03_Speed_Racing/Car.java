package Java_Advanced_May_2024._06_Defining_Classes._02_Exercise._03_Speed_Racing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCostFor1km;
    private double distanceTravelled;


    public Car(String model, double fuelAmount, double fuelCostFor1km) {
        setModel(model);
        setFuelAmount(fuelAmount);
        setFuelCostFor1km(fuelCostFor1km);
        setDistanceTravelled(0.00);
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public double getFuelCostFor1km() {
        return fuelCostFor1km;
    }

    public void setFuelCostFor1km(double fuelConsumption) {
        this.fuelCostFor1km = fuelConsumption;
    }

    public double getDistanceTravelled() {
        return distanceTravelled;
    }

    public void setDistanceTravelled(double distanceTravelled) {
        this.distanceTravelled = distanceTravelled;
    }


    public void drive(int distanceToTravel) {
        double requiredFuel = distanceToTravel * this.getFuelCostFor1km();
        if (this.getFuelAmount() < requiredFuel) {
            System.out.println("Insufficient fuel for the drive");
        } else {
            setFuelAmount(getFuelAmount() - requiredFuel);
            setDistanceTravelled(getDistanceTravelled() +distanceToTravel);
        }
    }




    @Override
    public String toString() {
        return String.format("%s %.2f %.0f", getModel(), getFuelAmount(), getDistanceTravelled());
    }
}
