package Java_Advanced_May_2024._06_Defining_Classes._01_Lab.Constructors;

public class Car {

    private String brand;
    private String model;
    private int horsepower;

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setHorsepower(Integer horsepower) {
        this.horsepower = horsepower;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public Integer getHorsepower() {
        return horsepower;
    }

    public Car(String brand) {
        this.brand = brand;
        this.model = "unknown";
        this.horsepower = -1;
    }

    public Car(String brand, String model, int horsepower) {
        setBrand(brand);
        setModel(model);
        setHorsepower(horsepower);
    }

    public String carInfo() {
        return String.format("The car is: %s %s - %d HP.",
                this.getBrand(), this.getModel(), this.getHorsepower());
    }
}
