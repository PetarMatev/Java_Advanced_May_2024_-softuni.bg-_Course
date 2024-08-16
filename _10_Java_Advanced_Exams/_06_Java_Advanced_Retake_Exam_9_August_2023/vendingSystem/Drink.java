package Java_Advanced_May_2024._10_Java_Advanced_Exams._06_Java_Advanced_Retake_Exam_9_August_2023.vendingSystem;

import java.math.BigDecimal;

public class Drink {

    private String name;
    private BigDecimal price;
    private int volume;

    public Drink(String name, BigDecimal price, int volume) {
        setName(name);
        setPrice(price);
        setVolume(volume);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Price: $%s, Volume: %d ml", getName(), getPrice(), getVolume());
    }
}
