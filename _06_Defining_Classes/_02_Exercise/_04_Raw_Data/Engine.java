package Java_Advanced_May_2024._06_Defining_Classes._02_Exercise._04_Raw_Data;

public class Engine {
    private int engineSpeed;
    private int enginePower;

    public Engine(int engineSpeed, int enginePower) {
        setEngineSpeed(engineSpeed);
        setEnginePower(enginePower);
    }

    public int getEngineSpeed() {
        return engineSpeed;
    }

    public void setEngineSpeed(int engineSpeed) {
        this.engineSpeed = engineSpeed;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "engineSpeed=" + engineSpeed +
                ", enginePower=" + enginePower +
                '}';
    }
}
