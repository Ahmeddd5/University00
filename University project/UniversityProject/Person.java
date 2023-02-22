package UniversityProject;

public class Person {
    private static int ID_COUNTER = 1;
    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

    public Person(String firstName, String lastName, String phoneNumber, String email) {
        this.id = ID_COUNTER++; // counter for every teacter/student creat it incremnet
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }
}