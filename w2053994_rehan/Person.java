
// Class representing a person with name, surname, and email attributes
public class Person {
    private String name;  // Person's name
    private String surname;  // Person's surname
    private String email;  // Person's email address


    // Constructor to initialize person object with name, surname, and email
    public Person(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }


    // Getter method for retrieving the person's name
    public String getName() {
        return name;
    }


    // Setter method for setting the person's name
    public void setName (String name) {
        this.name = name;
    }


    // Getter method for retrieving the person's surname
    public String getSurname() {
        return surname;
    }


    // Setter method for setting the person's surname
    public void setSurname(String surname) {
        this.surname = surname;
    }


    // Getter method for retrieving the person's email
    public String getEmail() {
        return email;
    }


    // Setter method for setting the person's email
    public void setEmail(String email) {
        this.email = email;
    }


    // Method to print person's information
    public void printInfo() {
        System.out.println("Name: " + name);
        System.out.println("Surname: " + surname);
        System.out.println("Email: " + email);
    }
}