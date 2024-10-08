package Java_Advanced_May_2024._10_Java_Advanced_Exams._08_Java_Advance_Regular_Exam_18_February_2023.kindergarten;

public class Child {
    private String firstName;
    private String lastName;
    private int age;
    private String parentName;
    private String contactNumber;


    public Child(String firstName, String lastName, int age, String parentName, String contactNumber) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setParentName(parentName);
        setContactNumber(contactNumber);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return String.format("Child: %s %s, Age: %d, Contact info: %s - %s",
                getFirstName(), getLastName(), getAge(), getParentName(), getContactNumber());
    }
}
