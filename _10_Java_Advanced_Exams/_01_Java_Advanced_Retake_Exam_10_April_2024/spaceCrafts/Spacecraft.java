package Java_Advanced_May_2024._10_Java_Advanced_Exams._01_Java_Advanced_Retake_Exam_10_April_2024.spaceCrafts;

public class Spacecraft {
    private String name;
    private String missionType;
    private String target;
    private String objective;
    private int weight;


    public Spacecraft(String name, String missionType, String target, String objective, int weight) {
        setName(name);
        setMissionType(missionType);
        setTarget(target);
        setObjective(objective);
        setWeight(weight);
    }

    public String getName() {
        return name;
    }

    public String getMissionType() {
        return missionType;
    }

    public String getTarget() {
        return target;
    }

    public String getObjective() {
        return objective;
    }

    public int getWeight() {
        return weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMissionType(String missionType) {
        this.missionType = missionType;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return String.format("The mission of %s was to reach %s and to %s", getName(), getTarget(), getObjective());
    }
}
