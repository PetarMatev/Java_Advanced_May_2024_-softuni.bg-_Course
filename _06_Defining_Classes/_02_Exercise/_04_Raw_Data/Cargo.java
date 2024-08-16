package Java_Advanced_May_2024._06_Defining_Classes._02_Exercise._04_Raw_Data;

public class Cargo {

    private int cargoWeight;
    private String cargoType;

    public Cargo(int cargoWeight, String cargoType) {
        setCargoWeight(cargoWeight);
        setCargoType(cargoType);
    }

    public int getCargoWeight() {
        return cargoWeight;
    }

    public void setCargoWeight(int cargoWeight) {
        this.cargoWeight = cargoWeight;
    }



    public String getCargoType() {
        return cargoType;
    }

    public void setCargoType(String cargoType) {
        this.cargoType = cargoType;
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "cargoWeight=" + cargoWeight +
                ", cargoType='" + cargoType + '\'' +
                '}';
    }
}
