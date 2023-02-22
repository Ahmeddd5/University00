package UniversityProject;

import java.util.*;

import javax.imageio.IIOException;

class Student extends Person {
    private double gpa;
    private List<Teacher> teachers = new ArrayList<>();

    public Student(String firstName, String lastName, String phoneNumber, String email, double gpa)
            throws IIOException {
        super(firstName, lastName, phoneNumber, email);
        this.gpa = gpa;
    }

    public double getGpa() {
        return gpa;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }
}