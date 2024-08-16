package Java_Advanced_May_2024._10_Java_Advanced_Exams._07_Java_Advance_Retake_Exam_12_April_2023.magazine;

public class Cloth {
    private String color;
    private int size;
    private String type;

    public Cloth(String color, int size, String type) {
        setColor(color);
        setSize(size);
        setType(type);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("Product: %s with size %d, color %s", getType(), getSize(), getColor());
    }
}
