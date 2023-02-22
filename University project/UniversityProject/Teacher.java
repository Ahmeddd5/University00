package UniversityProject;

import java.util.*;

class Teacher extends Person {
    private double salary;
    private List<Student> students = new ArrayList<>();

    public Teacher(String firstName, String lastName, String phoneNumber, String email, double salary) {
        super(firstName, lastName, phoneNumber, email);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }
}