package UniversityProject;

import java.util.*;

import javax.imageio.IIOException;

public class University {

    private static List<Teacher> teachers = new ArrayList<>();
    private static List<Student> students = new ArrayList<>();
    public static Scanner Keyboard = new Scanner(System.in); // scanner for inputs
    // menu printer

    public static int PrintMenu(Scanner userChoice) { // menu printer
        System.out.println("\n\n-------------WELCOME TO THE UNIVERSTY-------------");
        System.out.println(" ");
        System.out.println("1. Add a NEW teacher ");
        System.out.println("2. Add a NEW student");
        System.out.println("3. Sign a student to chosen teacher");
        System.out.println("4. Print all teachers");
        System.out.println("5. Print all students");
        System.out.println("6. Display all techers for a spicific student");
        System.out.println("7. Display all students signed in a spicific teacher`s class");
        System.out.println("8. EXIT PROGRAM");
        System.out.print("\nPlease select the number of operation to go next page : ");
        return userChoice.nextInt();
    }

    public static void main(String[] args) throws Exception {
        // the student
        System.out.println("\n--------------------------------------------------------");
        System.out.println("- Ahmed Alsalmi    443009955");
        System.out.println("\nSupervisoring by Doctor : Ahmed Hassan Yahya Lal Hindi");
        System.out.println("--------------------------------------------------------");
        Scanner UserOP = new Scanner(System.in);
        int UserChoice;
        do {
            UserChoice = PrintMenu(UserOP);
            switch (UserChoice) {
                case 1:
                    System.out.println("\nThe menu ------> Add teacher\n\n");
                    teacherCreator();
                    break;
                case 2:
                    System.out.println("\nThe menu ------> Add student\n\n");
                    studentCreator();
                    break;
                case 3:
                    System.out.println("\nThe menu ------> Sign a student for a teacher\n\n");
                    SignStudentForTeacher();
                    break;
                case 4:
                    System.out.println("\nThe menu ------> Print all teachers\n\n");
                    AllTeacthers();
                    break;
                case 5:
                    System.out.println("\nThe menu ------> Print all students\n\n");
                    AllStudents();
                    break;
                case 6:
                    System.out.println("\nThe menu ------> Display all teachers for a specific student\n\n");
                    displayTeacherForStudent();
                    break;
                case 7:
                    System.out.println("\nThe menu --> Display all students for a specific teachers\n");
                    displayStudentForTeacher();
                    break;
                case 8:
                    System.out.println(
                            "\nThank you for choosing us \nPROGRAM ENDED SUCCESSFULLY\n------------------------------------------------------------\n");
                    break;
                default:
                    System.out.print(
                            "\nOppps!! it seem you have put in a number out of boundary, please try again : \n\n");
            }
        } while (UserChoice != 8);
    }

    // method case 1 ( add new techer )
    public static void teacherCreator() { // method for case 1
        // STEP 1.1 FIRST NAME
        System.out.print("Enter first name please: ");
        String firstName = Keyboard.next();
        do {
            if (firstName.matches("^[a-zA-Z\s]*$")) {
            } else {
                System.out.print("Invalid name, please try again : ");
                firstName = Keyboard.next();
            }
        } while (!firstName.matches("^[a-zA-Z\s]*$"));
        // STEP 1.2 LAST NAME
        System.out.print("Enter last name please: ");
        String lastName = Keyboard.next();
        do {
            if (lastName.matches("^[a-zA-Z\s]*$")) {
            } else {
                System.out.print("Invalid name, please try again : ");
                lastName = Keyboard.next();
            }
        } while (!lastName.matches("^[a-zA-Z\s]*$"));
        // STEP 2 MOBILE PHONE
        System.out.print("Enter mobile number please: ");
        String phoneNumber = Keyboard.next();
        do {
            if (phoneNumber.matches("[0-9]{10}")) {
            } else {
                System.out.print("Invalid number, please try again : ");
                phoneNumber = Keyboard.next();
            }
        } while (!phoneNumber.matches("[0-9]{10}"));
        // STEP 3 EMAIL
        System.out.print("Enter email please: ");
        String email = Keyboard.next();
        do {
            if (email.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")) {
            } else {
                System.out.print("Invalid email, please try again : ");
                email = Keyboard.next();
            }
        } while (!email.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$"));
        // STEP 4 SALARY
        System.out.print("Enter the Salary in SAR : ");
        String salaryS = Keyboard.next();
        do {
            if (salaryS.matches("^[\\+\\-]{0,1}[0-9]+[\\.\\,]{1}[0-9]+$")) {
            } else {
                System.out.print("Invalid Salary, please try again : ");
                salaryS = Keyboard.next();
            } // "^\\d+(\\.\\d{1,2})? SAR$"
        } while (!salaryS.matches("^[\\+\\-]{0,1}[0-9]+[\\.\\,]{1}[0-9]+$"));
        double salary = Double.parseDouble(salaryS);
        // after taking all the data now store it
        Teacher teacher = new Teacher(firstName, lastName, phoneNumber, email, salary);
        teachers.add(teacher);
        System.out.println("\n--" + firstName.toUpperCase() + " WAS ADDED SECCESSFULLY--\n");
    }// case 1

    // method case 2 ( add a new student )
    public static void studentCreator() throws Exception { // method for case 2
        // STEP 1.1 FIRST NAME
        System.out.print("Enter first name please: ");
        String firstName = Keyboard.next();
        do {
            if (firstName.matches("^[a-zA-Z\\s]*$")) {
            } else {
                System.out.print("Invalid name, please try again : ");
                firstName = Keyboard.next();
            }
        } while (!firstName.matches("^[a-zA-Z\\s]*$"));
        // STEP 1.2 LAST NAME
        System.out.print("Enter last name please: ");
        String lastName = Keyboard.next();
        do {
            if (lastName.matches("^[a-zA-Z\\s]*$")) {
            } else {
                System.out.print("Invalid name, please try again : ");
                lastName = Keyboard.next();
            }
        } while (!lastName.matches("^[a-zA-Z\\s]*$"));
        // STEP 2 MOBILE PHONE
        System.out.print("Enter mobile number please: ");
        String mobilePhoneNumber = Keyboard.next();
        do {
            if (mobilePhoneNumber.matches("[0-9]{10}")) {
            } else {
                System.out.print("Invalid number, please try again : ");
                mobilePhoneNumber = Keyboard.next();
            }
        } while (!mobilePhoneNumber.matches("[0-9]{10}"));
        // STEP 3 EMAIL
        System.out.print("Enter email please: ");
        String email = Keyboard.next();
        do {
            if (email.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")) {
            } else {
                System.out.print("Invalid email, please try again : ");
                email = Keyboard.next();
            }
        } while (!email.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$"));
        // STEP 4 GPA
        System.out.print("Enter the GPA {0.0 to 4.0} : ");
        String GPAS = Keyboard.next();
        try {
            double GPA = Double.parseDouble(GPAS);
            if (GPA < 0.0 || GPA > 4.0) {
                throw new Exception("Invalid GPA, it must be in the range of 0.0 to 4.0");
            }
            // After taking all the data, now store it
            students.add(new Student(firstName, lastName, mobilePhoneNumber, email, GPA));
            System.out.println("\n--" + firstName.toUpperCase() + " WAS ADDED SUCCESSFULLY--\n");
        } catch (IIOException e) {
        }
        // case 2
    }

    // method case 3 ( assign a student to teacher)
    public static void SignStudentForTeacher() { // method for case 3
        // STEP 1.1 TEACHER ID
        System.out.print("Enter teacher ID : ");
        int teacherId = Keyboard.nextInt();
        Teacher teacher = findTeacherById(teacherId);
        if (teacher != null) {
            System.out.print("Enter student ID : ");
            int studentId = Keyboard.nextInt();
            Student student = findStudentById(studentId);
            if (student != null) {
                teacher.addStudent(student);
                student.addTeacher(teacher);
                System.out.println("\n" + student.getFirstName().toUpperCase() + " IS NOW ASSIGNED TO D. "
                        + teacher.getFirstName().toUpperCase());
                // return;
            } else {
                System.out.print("Invalid student id, BACK TO MENU ");
            }
        } else {
            System.out.print("Invalid teacher id, BACK TO MENU ");
        }
    }

    // method case 4 ( print all teachers )
    public static void AllTeacthers() { // method for case 4
        System.out.printf(
                "-----------------------------------------------------------------------------------------------------%n");
        System.out.printf(
                "|                                   ALL TEACTHERS INFORMERTIONS                                     |%n");
        System.out.printf(
                "-----------------------------------------------------------------------------------------------------%n");
        System.out.printf("| %-11s | %-25s | %-12s | %-30s | %-7s |%n", "ID", "NAME", "PHONE NUMBER", "EMAIL","SALARY");
        System.out.printf(
                "-----------------------------------------------------------------------------------------------------%n");
        // for every tecther
        for (Teacher teachers : teachers) {
            System.out.printf("| %-11s | %-25s | %-12s | %-30s | %-7s |%n", teachers.getId(),
                    teachers.getFirstName() + " " + teachers.getLastName(), teachers.getPhoneNumber(),
                    teachers.getEmail(), teachers.getSalary());
            System.out.printf(
                    "-----------------------------------------------------------------------------------------------------%n");
        }
    }

    // methid case 5 ( print all students )
    public static void AllStudents() { // method for case 5
        System.out.printf("-----------------------------------------------------------------------------------------------------%n");
        System.out.printf("|                                    ALL STUDENTS INFORMERTIONS                                     |%n");
        System.out.printf("-----------------------------------------------------------------------------------------------------%n");
        System.out.printf("| %-11s | %-25s | %-12s | %-30s | %-7s |%n", "ID", "NAME", "PHONE NUMBER", "EMAIL", "GPA");
        System.out.printf("-----------------------------------------------------------------------------------------------------%n");
        // for every student
        for (Student students : students) {
            System.out.printf("| %-11s | %-25s | %-12s | %-30s | %-7s |%n", students.getId(),
                    students.getFirstName() + " " + students.getLastName(), students.getPhoneNumber(),
                    students.getEmail(), students.getGpa());
            System.out.printf("-----------------------------------------------------------------------------------------------------%n");

        }
    }

    // method case 6 ( display all teachers for a student )
    public static void displayTeacherForStudent() { // method for case 6
        // STEP 1 STUDENT ID
        System.out.print("Enter student id please: ");

        int studentId = Keyboard.nextInt();
        boolean found = false;
        for (Student student : students) {
            if (student.getId() == studentId) {
                // print all student data in tabular form
                System.out.printf("-------------------------------------------%n");
                System.out.printf("| %-5s %-11s  %-20s |%n", "", student.getFirstName().toUpperCase(),"`S INFORMERTIONS");
                System.out.printf("-------------------------------------------%n");
                System.out.printf("| %-11s | %-25s |%n", "ID", "NAME");
                System.out.printf("-------------------------------------------%n");
                System.out.printf("| %-11s | %-25s |%n", student.getId(),student.getFirstName() + " " + student.getLastName());
                System.out.printf("-------------------------------------------%n");
                System.out.printf("\n-----------------------------------------------------------------------------------------------------%n");
                System.out.printf("|                                    ALL TEACTHERS INFORMERTIONS                                    |%n");
                System.out.printf("-----------------------------------------------------------------------------------------------------%n");
                System.out.printf("| %-11s | %-25s | %-12s | %-30s | %-7s |%n", "ID", "NAME", "PHONE NUMBER", "EMAIL","SALARY");
                System.out.printf("-----------------------------------------------------------------------------------------------------%n");
                for (Teacher teachers : teachers) { // IT MIGHT BE DELETED
                    System.out.printf("| %-11s | %-25s | %-12s | %-30s | %-7s |%n", teachers.getId(),
                            teachers.getFirstName() + " " + teachers.getLastName(), teachers.getPhoneNumber(),
                            teachers.getEmail(), teachers.getSalary());
                    System.out.printf("-----------------------------------------------------------------------------------------------------%n");
                }
                found = true;
                break;
            }
            if (!found) {
                System.out.println("There is no student by this id, BACK TO MENU");
            }
        }
    }

    // method case 7 ( display all studendts for a teacher )
    public static void displayStudentForTeacher() { // method for case 6
        // STEP 1 STUDENT ID
        System.out.print("Enter teacher id please: ");
        int teacherId = Keyboard.nextInt();
        boolean found = false;
        for (Teacher teacher : teachers) {
            if (teacher.getId() == teacherId) {
                // print all teachers data in tabular form
                System.out.printf("-------------------------------------------%n");
                System.out.printf("| %-5s %-11s  %-20s |%n", "", teacher.getFirstName().toUpperCase(),"`S INFORMERTIONS");
                System.out.printf("-------------------------------------------%n");
                System.out.printf("| %-11s | %-25s |%n", "ID", "NAME");
                System.out.printf("-------------------------------------------%n");
                System.out.printf("| %-11s | %-25s |%n", teacher.getId(),
                        teacher.getFirstName() + " " + teacher.getLastName());
                System.out.printf("-------------------------------------------%n");
                System.out.printf(
                        "\n-----------------------------------------------------------------------------------------------------%n");
                System.out.printf(
                        "|                                    ALL STUDENTS INFORMERTIONS                                     |%n");
                System.out.printf(
                        "-----------------------------------------------------------------------------------------------------%n");
                System.out.printf("| %-11s | %-25s | %-12s | %-30s | %-7s |%n", "ID", "NAME", "PHONE NUMBER", "EMAIL",
                        "GPA");
                System.out.printf(
                        "-----------------------------------------------------------------------------------------------------%n");
                for (Student students : students) { // IT MIGHT BE DELETED
                    System.out.printf("| %-11s | %-25s | %-12s | %-30s | %-7s |%n", students.getId(),
                            students.getFirstName() + " " + students.getLastName(), students.getPhoneNumber(),
                            students.getEmail(), students.getGpa());
                    System.out.printf(
                            "-----------------------------------------------------------------------------------------------------%n");
                }
                found = true;
                break;
            }
            if (!found) {
                System.out.println("There is no teachers by this, BACK TO MENU");
            }
        }
    }

    // method to check of the existing of tecthers`s ID LATER USE AFTER SOLVING ID
    private static Teacher findTeacherById(int id) {
        for (Teacher teacher : teachers) {
            if (teacher.getId() == id) {
                return teacher;
            }
        }
        return null;
    }

    private static Student findStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }
}