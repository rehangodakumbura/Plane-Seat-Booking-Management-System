import java.util.InputMismatchException;
import java.util.Scanner;

// Class for managing plane seats and tickets
public class w2053994_PlaneManagement {
    private static int[][] seats;// Array to represent plane seating arrangement
    private static Ticket[] tickets;// Array to store purchased tickets
    private static int ticketCount;// Counter to track the number of purchased tickets

    // Main method
    public static void main(String[] args) {
        System.out.println("\n\t**** Welcome to the Plane Management application ****");

        // Initialize the plane's seating arrangement and ticket array
        seats = new int[4][];
        seats[0] = new int[14];
        seats[1] = new int[12];
        seats[2] = new int[12];
        seats[3] = new int[14];

        tickets = new Ticket[52];
        ticketCount = 0;

        Scanner scanner = new Scanner(System.in);
        int option = -1;

        // Main menu loop
        while (option != 0) {
                try {
                    // Display menu options
                    System.out.println("\n\t****************************************************");
                    System.out.println("\t*                                                  *");
                    System.out.println("\t*                   MENU OPTION                    *");
                    System.out.println("\t*                                                  *");
                    System.out.println("\t****************************************************\n");

                    System.out.println("\t\t1) Buy a seat");
                    System.out.println("\t\t2) Cancel a seat");
                    System.out.println("\t\t3) Find first available seat");
                    System.out.println("\t\t4) Show seating plan");
                    System.out.println("\t\t5) Print tickets information and total sales");
                    System.out.println("\t\t6) Search ticket");
                    System.out.println("\t\t0) Quit");
                    System.out.println("\n\t****************************************************");

                    // Prompt user for option input
                    System.out.print("\n\tEnter your option: ");
                    option = scanner.nextInt();

                    // Execute corresponding method based on user's choice
                    switch (option) {
                        case 1:
                            buy_seat();
                            break;
                        case 2:
                            cancel_seat();
                            break;
                        case 3:
                            find_first_available();
                            break;
                        case 4:
                            show_seating_plan();
                            break;
                        case 5:
                            print_tickets_info();
                            break;
                        case 6:
                            search_ticket();
                            break;
                        case 0:
                            System.out.println("\n\t....Exiting the program....");
                            break;
                        default:
                            System.out.println("\n\t....Invalid option. Please try again....");
                            break;
                    }
                }catch(InputMismatchException e){
                    System.out.println("\n\tPlease enter valid input");
                    scanner.nextLine();
                }catch (Exception e){
                    System.out.println("\n\tPlease try again ");
                    scanner.nextLine();
                }

        }
    }

    // Method to purchase a seat
    private static void buy_seat() {
        Scanner scanner = new Scanner(System.in);


        do{
            System.out.println("\n\t-----------------------------------------------------");
            System.out.println("\t|                     BUY SEAT                      |");
            System.out.println("\t-----------------------------------------------------");

            // Asking user for select seat row
            System.out.print("\n\tEnter seat row (A, B, C, D): ");
            String row = scanner.nextLine().toUpperCase();

            // Validate input row
            if (!isValidRow(row)) {
                System.out.println("\n\t....Invalid row. Please enter A, B, C, or D....");
                continue;
            }

            // Input loop for seat number
            do {
                // Asking user for select seat number
                System.out.print("\tEnter seat number: ");
                int seatNumber = scanner.nextInt();

                // Validate input seat number
                if (!isValidSeatNumber(seatNumber)) {
                    System.out.println("\n\t....Invalid seat number. Seat number must be between 1 and 14....");
                    continue;
                }

                // Calculate row number based on input row
                int rowNumber = row.charAt(0) - 'A';


                // Check if the seat is already sold
                if (seats[rowNumber][seatNumber - 1] == 1) {
                    System.out.println("\n\t....Seat is already sold. Please try again....");
                    return ;
                }


                // Mark the seat as sold
                seats[rowNumber][seatNumber - 1] = 1;

                scanner.nextLine();

                // Asking user for input personal information to book a seat
                System.out.print("\n\tEnter the name: ");
                String name = scanner.nextLine();

                System.out.print("\tEnter the surname: ");
                String surname = scanner.nextLine();

                System.out.print("\tEnter the email: ");
                String email = scanner.nextLine();

                Person person = new Person(name, surname, email);  // Create person object
                Ticket ticket = new Ticket(row, seatNumber, person);  // Create ticket object
                tickets[ticketCount++] = ticket;  // Store ticket information

                printTicketsInfo();  // Method to print ticket information

                System.out.println("\n\t....Seat purchased successfully....");
                break;

            }while (true);break;
        }while (true);
    }


    // Method to cancel a seat
    private static void cancel_seat() {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("\n\t-----------------------------------------------------");
            System.out.println("\t|                   CANCEL SEAT                     |");
            System.out.println("\t-----------------------------------------------------");

            // Asking user for select seat row
            System.out.print("\n\tEnter seat row (A, B, C, D): ");
            String row = scanner.nextLine().toUpperCase();

            // Validate input row
            if (!isValidRow(row)) {
                System.out.println("\n\t....Invalid row. Please enter A, B, C, or D....");
                continue;
            }

            // Input loop for seat number
            do {
                System.out.print("\tEnter seat number: ");
                int seatNumber = scanner.nextInt();

                // Validate input seat number
                if (!isValidSeatNumber(seatNumber)) {
                    System.out.println("\n\t....Invalid seat number. Seat number must be between 1 and 14....");
                    continue;
                }

                int rowNumber = row.charAt(0) - 'A';  // Calculate row number based on input row

                // Check if the seat is available
                if (seats[rowNumber][seatNumber - 1] == 0) {
                    System.out.println("\n\t....Seat is already available.It wasn't booked yet....");
                    return;
                }

                // Mark the seat as available
                seats[rowNumber][seatNumber - 1] = 0;

                // Cancel the ticket
                for (int i = 0; i < ticketCount; i++) {
                    if (tickets[i].getRow().equals(row) && tickets[i].getSeat() == seatNumber) {
                        tickets[i] = null;
                        break;
                    }
                }

                System.out.println("\n\t....Seat cancelled successfully....");
                break;

            }while (true);break;
        }while (true);
    }


    // Method to find the first available seat
    private static void find_first_available() {

        System.out.println("\n\t-----------------------------------------------------");
        System.out.println("\t|            FIND FIRST AVAILABLE SEAT              |");
        System.out.println("\t-----------------------------------------------------");

        // Iterate over seats array to find the first available seat
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                if (seats[i][j] == 0) {
                    System.out.println("\n\tThe first available seat is: " + (char) ('A' + i) + (j + 1));
                    return;
                }
            }
        }

        System.out.println("\n\t....No available seats found.All the seats are booked...");
    }


    // Method to show seating plan
    private static void show_seating_plan() {

        System.out.println("\n\t-----------------------------------------------------");
        System.out.println("\t|                  SEATING PLAN                     |");
        System.out.println("\t-----------------------------------------------------");

        System.out.println("\n\t\t01 02 03 04 05 06 07 08 09 10 11 12 13 14 ");  // Print the column headers for seat numbers

        // Iterate over each row of the seats array
        for (int i = 0; i < seats.length; i++) {
            System.out.print("\t"+(char) ('A' + i) + "\t");  // Print the row label (A, B, C, D)

            // Iterate over each seat in the row
            for (int j = 0; j < seats[i].length; j++) {

                // Check if the seat is available (0) or sold (1)
                if (seats[i][j] == 0) {
                    System.out.print(" O ");  // Print O for available seat
                } else {
                    System.out.print(" X ");  // Print X for sold seat
                }
            }

            System.out.println();
        }
    }


    // Method to print tickets information and total sales
    private static void print_tickets_info() {

        System.out.println("\n\t-----------------------------------------------------");
        System.out.println("\t|               TICKETS INFORMATION                 |");
        System.out.println("\t-----------------------------------------------------");

        printTicketsInfo();  // Invoke a helper method to print detailed ticket information


    }


    // Method to search for a ticket
    private static void search_ticket() {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("\n\t-----------------------------------------------------");
            System.out.println("\t|                  SEARCH TICKETS                   |");
            System.out.println("\t-----------------------------------------------------");

            //Asking user to input seat row
            System.out.print("\n\tEnter seat row (A, B, C, D): ");
            String row = scanner.nextLine().toUpperCase();

            // Validate input row
            if (!isValidRow(row)) {
                System.out.println("\n\t....Invalid row. Please enter A, B, C, or D....");
                continue;
            }

            do {
                System.out.print("\tEnter seat number: ");  //Asking user to input seat number
                int seatNumber = scanner.nextInt();

                // Validate input seat number
                if (!isValidSeatNumber(seatNumber)) {
                    System.out.println("\n\t....Invalid seat number. Seat number must be between 1 and 14....");
                    continue;
                }

                // Search for the ticket corresponding to the input seat
                for (int i = 0; i < ticketCount; i++) {
                    Ticket ticket = tickets[i];

                    // If the ticket is found, print its details
                    if (ticket.getRow().equals(row) && ticket.getSeat() == seatNumber) {
                        System.out.println("\n\t\t....Ticket found....");
                        System.out.println("\n\tRow: " + ticket.getRow());
                        System.out.println("\tSeat: " + ticket.getSeat());
                        System.out.println("\tPrice: £" + ticket.getPrice());
                        System.out.println("\n\tPerson Information:");
                        System.out.println("\n\tName: " + ticket.getPerson().getName());
                        System.out.println("\tSurname: " + ticket.getPerson().getSurname());
                        System.out.println("\tEmail: " + ticket.getPerson().getEmail());
                        System.out.println("\n\t....Sorry.This seat already booked....");
                        return;
                    }
                }

                // If no matching ticket is found, indicate that the seat is available
                System.out.println("\n\t....This seat is available....");
                break;

            }while (true);break;
        }while (true);
    }

    private static void printTicketsInfo() {
        int totalAmount = 0;  // Initialize total amount counter

        System.out.println("\n\t\t\t:- TICKETS INFORMATION -:");
        System.out.println("\t\t\t  ---------------------  ");

        // Iterate over all purchased tickets to calculate total amount
        for (int i = 0; i < ticketCount; i++) {
            Ticket ticket = tickets[i];  // Get the ticket object at index i

            // Print ticket details
            System.out.println("\n\t- Ticket " + (i + 1) + " -");
            System.out.println("\n\tRow: " + ticket.getRow());
            System.out.println("\tSeat: " + ticket.getSeat());
            System.out.println("\tPrice: £" + ticket.getPrice());
            System.out.println("\n\t- Person Information -");
            System.out.println("\n\tName: " + ticket.getPerson().getName());
            System.out.println("\tSurname: " + ticket.getPerson().getSurname());
            System.out.println("\tEmail: " + ticket.getPerson().getEmail());
            System.out.println();

            // Add the ticket price to the total amount
            totalAmount += ticket.getPrice();
        }

        // Print the total amount of sales
        System.out.println("\n\tTotal amount: £" + totalAmount);

    }

    // Method to check if the input row is valid
    private static boolean isValidRow(String row) {
        return row.equals("A") || row.equals("B") || row.equals("C") || row.equals("D");
    }

    // Method to check if the input seat number is valid
    private static boolean isValidSeatNumber(int seatNumber) {
        return seatNumber >= 1 && seatNumber <= 14;
    }
}