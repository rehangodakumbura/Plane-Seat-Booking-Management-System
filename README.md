# Plane Seat Management System

A comprehensive Java console application for managing seat reservations on a private aircraft. This system provides efficient seat booking, cancellation, and management functionality with integrated ticket and passenger information storage.

## Project Overview

This application manages seat reservations for a private aircraft with a unique seating configuration of 4 rows (A, B, C, D) with varying capacities. The system handles passenger information, ticket pricing, and provides comprehensive seat management features including file-based ticket storage.

## Aircraft Configuration

### Seating Layout
- **Row A**: 14 seats (A1-A14) - Price: £200 per seat
- **Row B**: 12 seats (B1-B12) - Price: £150 per seat  
- **Row C**: 12 seats (C1-C12) - Price: £180 per seat
- **Row D**: 14 seats (D1-D14) - Price: £200 per seat

### Seat Plan Visualization
```
A: O O O O O O O   O O O O O O O
 B: O O O O O O   O O O O O O
 C: O O O O O O   O O O O O O  
D: O O O O O O O   O O O O O O O
```
*O = Available, X = Sold*

## Features

### Core Functionality
- **Seat Booking**: Reserve seats with passenger information collection
- **Seat Cancellation**: Cancel existing reservations and free up seats
- **Seat Availability Search**: Find first available seat in priority order
- **Seating Plan Display**: Visual representation of current seat status
- **Ticket Management**: Complete ticket information with pricing
- **Passenger Records**: Store and manage passenger details

### Advanced Features
- **Ticket Information Display**: View all sold tickets with total revenue
- **Seat Search**: Find specific seat reservations and passenger details
- **File Storage**: Automatic ticket saving to individual files
- **Input Validation**: Comprehensive error checking for all user inputs
- **Session Management**: Track all bookings and cancellations in current session

## Technology Stack

- **Language**: Java
- **Development Environment**: IntelliJ IDEA
- **Data Structures**: Standard Java arrays (no dynamic collections)
- **File I/O**: Text-based ticket storage
- **Architecture**: Object-Oriented Programming with multiple classes

## Installation & Setup

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- IntelliJ IDEA or compatible Java IDE
- Basic understanding of Java programming

### Setup Instructions

1. **Clone the Repository**
   ```bash
   git clone https://github.com/rehangodakumbura/Plane-Seat-Booking-Management-System.git
   cd Plane-Seat-Booking-Management-System
   ```

2. **Open in IDE**
   - Launch IntelliJ IDEA
   - Select "Open" and navigate to project directory
   - Wait for project indexing to complete

3. **Run the Application**
   - Navigate to `PlaneManagement.java`
   - Right-click and select "Run PlaneManagement"
   - Or use the Run button in the IDE

## Usage Guide

### Main Menu Options

When you start the application, you'll see:

```
Welcome to the Plane Management application

************************************
*           MENU OPTIONS           *
************************************
    1) Buy a seat
    2) Cancel a seat
    3) Find first available seat
    4) Show seating plan
    5) Print tickets info
    6) Search ticket
    0) Quit
************************************
Please select an option:
```

### Feature Descriptions

#### 1. Buy a Seat
- Enter row letter (A-D) and seat number
- Provide passenger information (name, surname, email)
- System validates seat availability and creates ticket
- Ticket is automatically saved to file (e.g., A1.txt)

#### 2. Cancel a Seat
- Enter row letter and seat number to cancel
- System verifies seat is currently booked
- Removes ticket from system and frees the seat
- Updates seating plan accordingly

#### 3. Find First Available Seat
- Searches for first available seat in order: A→B→C→D
- Returns seat location if found
- Displays message if all seats are booked

#### 4. Show Seating Plan
- Visual display of all seats with current status
- 'O' indicates available seats
- 'X' indicates sold seats
- Maintains proper spacing to match aircraft layout

#### 5. Print Tickets Info
- Lists all tickets sold in current session
- Shows passenger details for each ticket
- Calculates and displays total revenue

#### 6. Search Ticket
- Search for specific seat reservation
- Enter row and seat number to find booking
- Displays complete passenger and ticket information

## Project Structure

```
PlaneManagement/
├── src/
│   ├── PlaneManagement.java    # Main application class with menu system
│   ├── Person.java             # Passenger information class
│   └── Ticket.java             # Ticket management class
├── ticket_files/               # Generated ticket files (A1.txt, B2.txt, etc.)
├── README.md                   # This file
└── documentation/
    └── test_plan.pdf           # Testing documentation
```

## Class Architecture

### PlaneManagement.java (Main Class)
- **Main method**: Application entry point and menu system
- **buy_seat()**: Handles seat reservation process
- **cancel_seat()**: Manages seat cancellation
- **find_first_available()**: Locates next available seat
- **show_seating_plan()**: Displays visual seating layout
- **print_tickets_info()**: Shows all ticket information and revenue
- **search_ticket()**: Finds specific seat reservations

### Person.java
```java
public class Person {
    private String name;
    private String surname;
    private String email;
    
    // Constructor, getters, setters, and print methods
}
```

### Ticket.java
```java
public class Ticket {
    private char row;
    private int seat;
    private double price;
    private Person person;
    
    // Constructor, getters, setters, print, and save methods
}
```

## Data Management

### Seat Tracking
- Uses standard Java arrays to track seat status
- `0` = Available seat
- `1` = Sold seat
- Four separate arrays for each row (A, B, C, D)

### Pricing Structure
- Row A: £200 per seat (Premium)
- Row B: £150 per seat (Economy)
- Row C: £180 per seat (Business)
- Row D: £200 per seat (Premium)

### File Storage
- Each ticket automatically saved as individual text file
- File naming convention: `[ROW][SEAT].txt` (e.g., A1.txt, B12.txt)
- Contains complete passenger and ticket information
- Files created in project directory for easy access

## Input Validation

### Row Validation
- Accepts only A, B, C, or D (case-insensitive)
- Displays error for invalid row letters

### Seat Number Validation
- Row A & D: 1-14 seats
- Row B & C: 1-12 seats
- Validates seat exists for specific row

### Booking Status Validation
- Prevents booking already sold seats
- Prevents cancelling available seats
- Clear error messages for invalid operations

## Testing

The application includes comprehensive testing for:

### Functional Testing
- Seat booking with valid and invalid inputs
- Seat cancellation scenarios
- Search functionality accuracy
- File generation and content verification

### Edge Cases
- Booking non-existent seats
- Cancelling already available seats
- Full aircraft scenarios
- Invalid character inputs

### User Experience Testing
- Menu navigation
- Error message clarity
- Output formatting consistency

## Error Handling

- **Invalid Menu Selection**: Prompts for valid option
- **Invalid Row/Seat**: Clear error messages with valid ranges
- **Seat Already Booked**: Prevents double booking with notification
- **Seat Already Available**: Prevents cancelling free seats
- **File I/O Errors**: Handles file creation/writing issues gracefully

## Example Usage

### Booking a Seat
```
Please select an option: 1
Enter row letter (A-D): A
Enter seat number: 1
Enter passenger name: John
Enter passenger surname: Doe
Enter passenger email: john.doe@email.com

Seat A1 has been successfully booked for John Doe
Ticket saved to file: A1.txt
```

### Viewing Seating Plan
```
A: X O O O O O O   O O O O O O O
 B: O O O O O O   O O O O O O
 C: O O O O O O   O O O O O O  
D: O O O O O O O   O O O O O O O
```

## Development Guidelines

### Code Style Requirements
- Descriptive variable and method names
- Comprehensive code comments
- Consistent indentation and formatting
- Method reusability and modularity
- No use of dynamic arrays (ArrayList, etc.)

### Object-Oriented Principles
- **Encapsulation**: Private attributes with public getters/setters
- **Class Design**: Separate concerns between Person and Ticket
- **Method Organization**: Logical grouping of related functionality

## Future Enhancements

Potential improvements for future versions:
- **GUI Interface**: Graphical user interface for better usability
- **Database Integration**: Persistent storage beyond text files
- **Seat Categories**: Different seat types (window, aisle, middle)
- **Booking History**: Long-term reservation tracking
- **Payment Integration**: Processing and validation
- **Multi-Aircraft Support**: Manage multiple aircraft fleets

## Troubleshooting

### Common Issues

1. **Program Won't Compile**
   - Ensure all .java files are in correct package structure
   - Verify Java version compatibility

2. **File Creation Issues**
   - Check write permissions in project directory
   - Ensure sufficient disk space

3. **Invalid Input Handling**
   - Follow prompted input format exactly
   - Use uppercase letters for row selection

## Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/new-feature`)
3. Commit your changes (`git commit -am 'Add new feature'`)
4. Push to the branch (`git push origin feature/new-feature`)
5. Create a Pull Request

### Development Standards
- Follow existing code style conventions
- Add comprehensive comments for new methods
- Test all functionality before submitting
- Update documentation for new features

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Author

**[Rehan Godakumbura]**
- GitHub: [@rehangodakumbura](https://github.com/rehangodakumbura)
- Email: rehangod2003@gmail.com

---

**Academic Integrity Statement**: This coursework represents original work completed according to university guidelines. All external sources and references have been properly attributed within the code documentation.
