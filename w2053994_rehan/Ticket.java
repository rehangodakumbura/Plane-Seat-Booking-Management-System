import java.io.FileWriter;
import java.io.IOException;

// Class representing a Ticket
public class Ticket {
    private String row;  // Row of the seat
    private int seat;  // Seat number
    private int price;  // Price of the ticket
    private Person person;  // Person associated with the ticket


    // Constructor to initialize ticket with row, seat, and person
    public Ticket(String row, int seat, Person person) {
        this.row = row;
        this.seat = seat;
        this.price = calculatePrice(row, seat);  // Calculate ticket price based on row and seat
        this.person = person;
        save();  // Save ticket information to a file
    }


    // Getter method for retrieving the row of the seat
    public String getRow() {
        return row;
    }


    // Setter method for setting the row of the seat
    public void setRow(String row) {
        this.row = row;
    }


    // Getter method for retrieving the seat number
    public int getSeat() {
        return seat;
    }


    // Setter method for setting the seat number
    public void setSeat(int seat) {
        this.seat = seat;
    }


    // Getter method for retrieving the price of the ticket
    public int getPrice() {
        return price;
    }


    // Setter method for setting the price of the ticket
    public void setPrice(int price) {
        this.price = price;
    }


    // Getter method for retrieving the person associated with the ticket
    public Person getPerson() {
        return person;
    }


    // Setter method for setting the person associated with the ticket
    public void setPerson(Person person) {
        this.person = person;
    }


    // Method to print ticket information
    public void printInfo() {
        System.out.println("Row: " + row);
        System.out.println("Seat: " + seat);
        System.out.println("Price: £" + price);
        System.out.println("Person Information:");
        person.printInfo();
    }


    // Method to calculate the price of the ticket based on row and seat
    private int calculatePrice(String row, int seat) {
        if (row.equals("A") || row.equals("B") || row.equals("C") || row.equals("D")) {
            if (seat >= 1 && seat <= 5) {
                return 200;
            } else if (seat >= 6 && seat <= 10) {
                return 150;
            } else if ((row.equals("A") || row.equals("D")) && seat >= 10 && seat <= 14) {
                return 180;
            } else if ((row.equals("B") || row.equals("C")) && seat >= 10 && seat <= 12) {
                return 180;
            }
        }
        // Default return if invalid row or seat
        return 0;

    }


    // Method to save ticket information to a file
    public void save() {
        String fileName = row + seat + ".txt"; // File name based on row and seat number
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write("Ticket Information:\n");
            writer.write("Row: " + row + "\n");
            writer.write("Seat: " + seat + "\n");
            writer.write("Price: $" + price + "\n");
            writer.write("Person Information:\n");
            writer.write("Name: " + person.getName() + "\n");
            writer.write("Surname: " + person.getSurname() + "\n");
            writer.write("Email: " + person.getEmail() + "\n");
            writer.close();
            System.out.println("\n\tTicket information saved to " + fileName);
        } catch (IOException e) {
            System.out.println("\n\tAn error occurred while saving the ticket information.");
            e.printStackTrace();
        }
    }
}