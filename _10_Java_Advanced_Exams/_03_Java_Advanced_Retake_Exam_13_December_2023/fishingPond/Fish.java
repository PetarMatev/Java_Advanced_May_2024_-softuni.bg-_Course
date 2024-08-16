package Java_Advanced_May_2024._10_Java_Advanced_Exams._03_Java_Advanced_Retake_Exam_13_December_2023.fishingPond;

public class Fish {
    private String species;
    private int age;
    private String matingSeason;

    public Fish(String species, int age, String matingSeason) {
        setSpecies(species);
        setAge(age);
        setMatingSeason(matingSeason);
    }

    public String getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }

    public String getMatingSeason() {
        return matingSeason;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMatingSeason(String matingSeason) {
        this.matingSeason = matingSeason;
    }

    @Override
    public String toString() {
        return String.format("This %s is %d years old and reproduces through %s.",
                getSpecies(), getAge(), getMatingSeason());
    }
}
