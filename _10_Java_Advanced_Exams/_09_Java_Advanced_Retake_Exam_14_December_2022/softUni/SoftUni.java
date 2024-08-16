package Java_Advanced_May_2024._10_Java_Advanced_Exams._09_Java_Advanced_Retake_Exam_14_December_2022.softUni;

import java.util.ArrayList;
import java.util.List;

public class SoftUni {

    private int capacity;
    private List<Student> data;

    public SoftUni(int capacity) {
        setCapacity(capacity);
        this.data = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }


    //•	getCount() method – returns the number of students in the course.
    public int getCount() {
        return data.size();
    }

    public String insert(Student student) {
        if (getCount() >= capacity) {
            return "The hall is full.";
        }
        for (Student s : data) {
            if (s.getFirstName().equals(student.getFirstName()) && s.getLastName().equals(student.getLastName())) {
                return "Student is already in the hall.";
            }
        }
        data.add(student);
        return String.format("Added student %s %s.", student.getFirstName(), student.getLastName());
    }

    public String remove(Student student) {
        if (data.removeIf(s -> s.getFirstName().equals(student.getFirstName()) && s.getLastName().equals(student.getLastName()))) {
            return String.format("Removed student %s %s.", student.getFirstName(), student.getLastName());
        }
        return "Student not found.";
    }

    //•	getStudent(String firstName, String lastName) method - returns the student with the given names.
    public Student getStudent(String firstName, String lastName) {
        return data.stream().filter(s -> s.getFirstName().equals(firstName))
                .filter(s -> s.getLastName().equals(lastName)).findFirst().orElse(null);
    }

    public String getStatistics() {
        StringBuilder rep = new StringBuilder();
        rep.append("Hall size: ").append(getCount()).append(System.lineSeparator());
        for (Student s : data) {
            rep.append(s).append(System.lineSeparator());
        }
        return rep.toString().trim();
    }
}
