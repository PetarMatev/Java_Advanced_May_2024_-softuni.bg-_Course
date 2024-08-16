package Java_Advanced_May_2024._10_Java_Advanced_Exams._14_Java_Advanced_Retake_Exam_15_December_2021.aquarium;

public class Fish {

    private String name;
    private String color;
    private int fins;

    public Fish(String name, String color, int fins) {
        setName(name);
        setColor(color);
        setFins(fins);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getFins() {
        return fins;
    }

    public void setFins(int fins) {
        this.fins = fins;
    }

    @Override
    public String toString() {
        return String.format("Fish: %s%nColor: %s%nNumber of fins: %d",
                getName(),
                getColor(),
                getFins());
    }
}
