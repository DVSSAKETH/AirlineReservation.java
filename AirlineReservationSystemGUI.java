import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

class Flight {
    int id;
    String name;
    String from;
    String to;
    String departureTime;
    int seats;
    double price;

    public Flight(int id, String name, String from, String to, String departureTime, int seats, double price) {
        this.id = id;
        this.name = name;
        this.from = from;
        this.to = to;
        this.departureTime = departureTime;
        this.seats = seats;
        this.price = price;
    }
}

class Reservation {
    int flightId;
    int seatsBooked;

    public Reservation(int flightId, int seatsBooked) {
        this.flightId = flightId;
        this.seatsBooked = seatsBooked;
    }
}

public class AirlineReservationSystemGUI extends JFrame {
    private List<Flight> flights;
    private List<Reservation> reservations;
    private JComboBox<String> fromComboBox;
    private JComboBox<String> toComboBox;
    private List<JButton> seatButtons; // Added field to store seat buttons
    private JLabel cancellationStatusLabel; // Added cancellationStatusLabel


   public AirlineReservationSystemGUI() {
    flights = new ArrayList<>();
    reservations = new ArrayList<>();
    seatButtons = new ArrayList<>(); // Initialize seatButtons list
    cancellationStatusLabel = new JLabel(" "); // Initialize cancellationStatusLabel with a non-null value

    initializeFlights();

    setTitle("Airline Reservation System");
    setSize(800, 600);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    createUI();

    setLocationRelativeTo(null); // Center the frame on the screen
    setVisible(true);
}


    private void initializeFlights() {
        // Your flight initialization code remains the same
        flights.add(new Flight(1, "Flight 1", "Hyderabad", "Mumbai", "08:00 AM", 50, 5000.0));
	flights.add(new Flight(2, "Flight 2", "Hyderabad", "Mumbai", "10:30 AM", 70, 5000.0));
	flights.add(new Flight(3, "Flight 3", "Hyderabad", "Mumbai", "12:00 PM", 60, 5500.0));
	flights.add(new Flight(4, "Flight 4", "Hyderabad", "Chennai", "08:00 AM", 50, 5000.0));
	flights.add(new Flight(5, "Flight 5", "Hyderabad", "Chennai", "10:30 AM", 70, 5000.0));
	flights.add(new Flight(6, "Flight 6", "Hyderabad", "Chennai", "12:00 PM", 60, 5500.0));
	flights.add(new Flight(7, "Flight 7", "Hyderabad", "Banglore", "08:00 AM", 50, 5000.0));
	flights.add(new Flight(8, "Flight 8", "Hyderabad", "Banglore", "10:30 AM", 70, 5000.0));
	flights.add(new Flight(9, "Flight 9", "Hyderabad", "Banglore", "12:00 PM", 60, 5500.0));
	flights.add(new Flight(10, "Flight 10", "Hyderabad", "Delhi", "08:00 AM", 50, 5000.0));
	flights.add(new Flight(11, "Flight 11", "Hyderabad", "Delhi", "10:30 AM", 70, 5000.0));
	flights.add(new Flight(12, "Flight 12", "Hyderabad", "Delhi", "12:00 PM", 60, 5500.0));
	flights.add(new Flight(13, "Flight 13", "Banglore", "Mumbai", "08:00 AM", 50, 5000.0));
	flights.add(new Flight(14, "Flight 14", "Banglore", "Mumbai", "10:30 AM", 70, 5000.0));
	flights.add(new Flight(15, "Flight 15", "Banglore", "Mumbai", "12:00 PM", 60, 5500.0));
	flights.add(new Flight(16, "Flight 16", "Banglore", "Chennai", "08:00 AM", 50, 5000.0));
	flights.add(new Flight(17, "Flight 17", "Banglore", "Chennai", "10:30 AM", 70, 5000.0));
	flights.add(new Flight(18, "Flight 18", "Banglore", "Chennai", "12:00 PM", 60, 5500.0));
	flights.add(new Flight(19, "Flight 19", "Banglore", "Delhi", "08:00 AM", 50, 5000.0));
	flights.add(new Flight(20, "Flight 20", "Banglore", "Delhi", "10:30 AM", 70, 5000.0));
	flights.add(new Flight(21, "Flight 21", "Banglore", "Delhi", "12:00 PM", 60, 5500.0));
	flights.add(new Flight(22, "Flight 22", "Chennai", "Mumbai", "09:30 AM", 40, 4800.0));
	flights.add(new Flight(23, "Flight 23", "Chennai", "Mumbai", "11:00 AM", 60, 5200.0));
	flights.add(new Flight(24, "Flight 24", "Chennai", "Mumbai", "01:30 PM", 80, 5500.0));
	flights.add(new Flight(25, "Flight 25", "Delhi", "Hyderabad", "09:00 AM", 45, 4900.0));
	flights.add(new Flight(26, "Flight 26", "Delhi", "Hyderabad", "11:30 AM", 65, 5300.0));
	flights.add(new Flight(27, "Flight 27", "Delhi", "Hyderabad", "02:00 PM", 75, 5600.0));
	flights.add(new Flight(28, "Flight 28", "Mumbai", "Banglore", "09:30 AM", 40, 4800.0));
	flights.add(new Flight(29, "Flight 29", "Mumbai", "Banglore", "11:00 AM", 60, 5200.0));
	flights.add(new Flight(30, "Flight 30", "Mumbai", "Banglore", "01:30 PM", 80, 5500.0));
	flights.add(new Flight(31, "Flight 31", "Chennai", "Banglore", "09:00 AM", 45, 4900.0));
	flights.add(new Flight(32, "Flight 32", "Chennai", "Banglore", "11:30 AM", 65, 5300.0))	;
	flights.add(new Flight(33, "Flight 33", "Chennai", "Banglore", "02:00 PM", 75, 5600.0));
	flights.add(new Flight(34, "Flight 34", "Hyderabad", "Delhi", "09:30 AM", 40, 4800.0));
	flights.add(new Flight(35, "Flight 35", "Hyderabad", "Delhi", "11:00 AM", 60, 5200.0));
	flights.add(new Flight(36, "Flight 36", "Hyderabad", "Delhi", "01:30 PM", 80, 5500.0));
	flights.add(new Flight(37, "Flight 37", "Banglore", "Chennai", "09:00 AM", 45, 4900.0));
	flights.add(new Flight(38, "Flight 38", "Banglore", "Chennai", "11:30 AM", 65, 5300.0));
	flights.add(new Flight(39, "Flight 39", "Banglore", "Chennai", "02:00 PM", 75, 5600.0));
	flights.add(new Flight(40, "Flight 40", "Delhi", "Mumbai", "09:30 AM", 40, 4800.0));
	flights.add(new Flight(41, "Flight 41", "Delhi", "Mumbai", "11:00 AM", 60, 5200.0));	
	flights.add(new Flight(42, "Flight 42", "Delhi", "Mumbai", "01:30 PM", 80, 5500.0));
	flights.add(new Flight(43, "Flight 43", "Mumbai", "Hyderabad", "10:00 AM", 55, 5100.0));
	flights.add(new Flight(44, "Flight 44", "Mumbai", "Hyderabad", "01:00 PM", 65, 5400.0));
	flights.add(new Flight(45, "Flight 45", "Mumbai", "Hyderabad", "03:30 PM", 75, 5700.0));
	flights.add(new Flight(46, "Flight 46", "Chennai", "Delhi", "10:30 AM", 50, 5000.0));
	flights.add(new Flight(47, "Flight 47", "Chennai", "Delhi", "12:00 PM", 70, 5300.0));
	flights.add(new Flight(48, "Flight 48", "Chennai", "Delhi", "02:30 PM", 80, 5600.0));
	flights.add(new Flight(49, "Flight 49", "Banglore", "Hyderabad", "10:00 AM", 55, 5100.0));
	flights.add(new Flight(50, "Flight 50", "Banglore", "Hyderabad", "01:00 PM", 65, 5400.0));
	flights.add(new Flight(51, "Flight 51", "Banglore", "Hyderabad", "03:30 PM", 75, 5700.0));
	flights.add(new Flight(52, "Flight 52", "Hyderabad", "Mumbai", "10:30 AM", 50, 5000.0));
	flights.add(new Flight(53, "Flight 53", "Hyderabad", "Mumbai", "12:00 PM", 70, 5300.0));
	flights.add(new Flight(54, "Flight 54", "Hyderabad", "Mumbai", "02:30 PM", 80, 5600.0));
	flights.add(new Flight(55, "Flight 55", "Delhi", "Banglore", "10:00 AM", 55, 5100.0));
	flights.add(new Flight(56, "Flight 56", "Delhi", "Banglore", "01:00 PM", 65, 5400.0));
	flights.add(new Flight(57, "Flight 57", "Delhi", "Banglore", "03:30 PM", 75, 5700.0));
	flights.add(new Flight(58, "Flight 58", "Mumbai", "Chennai", "10:30 AM", 50, 5000.0));
	flights.add(new Flight(59, "Flight 59", "Mumbai", "Chennai", "12:00 PM", 70, 5300.0));
	flights.add(new Flight(60, "Flight 60", "Mumbai", "Chennai", "02:30 PM", 80, 5600.0));
        flights.add(new Flight(61, "Flight 61", "chennai", "hyderabad", "10:00 AM", 50, 6000.0));
        flights.add(new Flight(62, "Flight 62", "chennai", "hyderabad", "05:00 PM", 60, 5500.0)); 

    }

  private void createUI() {
    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(5, 2));

    JLabel fromLabel = new JLabel("From:");
    fromComboBox = new JComboBox<>(getDistinctDestinations());
    fromComboBox.setEditable(true);

    JLabel toLabel = new JLabel("To:");
    toComboBox = new JComboBox<>(getDistinctDestinations());
    toComboBox.setEditable(true);

    JButton searchButton = new JButton("Search Flights");
    searchButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            searchFlights();
        }
    });

    JButton cancelTicketsButton = new JButton("Cancel Tickets/My Bookings");
    cancelTicketsButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            cancelTicketsDialog();
        }
    });

    panel.add(fromLabel);
    panel.add(fromComboBox);
    panel.add(toLabel);
    panel.add(toComboBox);
    panel.add(searchButton);
    panel.add(cancelTicketsButton);  // Added cancelTicketsButton
    panel.add(new JLabel()); // Empty cell for spacing

    add(panel, BorderLayout.NORTH);
        cancellationStatusLabel.setHorizontalAlignment(JLabel.CENTER);
        add(cancellationStatusLabel, BorderLayout.SOUTH);
}


    private void searchFlights() {
        String from = fromComboBox.getSelectedItem().toString();
        String to = toComboBox.getSelectedItem().toString();

        if (from.isEmpty() || to.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter From and To.");
            return;
        }

        if (!isValidDestination(from) || !isValidDestination(to)) {
            JOptionPane.showMessageDialog(this, "Invalid destination. Please enter valid addresses.");
            return;
        }

        boolean foundFlights = false;

        JPanel flightButtonsPanel = new JPanel(new GridLayout(0, 1));

        for (Flight flight : flights) {
            if (flight.from.equalsIgnoreCase(from) && flight.to.equalsIgnoreCase(to)) {
                JButton flightButton = new JButton(
                        String.format("%s - Departure Time: %s, Seats: %d, Price: rs%.2f",
                                flight.name, flight.departureTime, flight.seats, flight.price));

                flightButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        bookFlightDialog(flight);
                    }
                });

                flightButtonsPanel.add(flightButton);
                foundFlights = true;
            }
        }

        if (!foundFlights) {
            JOptionPane.showMessageDialog(this, "No records found for the given destinations.");
        } else {
            // Display the flight details buttons in a dialog
            JOptionPane.showMessageDialog(this, flightButtonsPanel, "Available Flights", JOptionPane.PLAIN_MESSAGE);
        }
    }

    private boolean isValidDestination(String destination) {
        // Add your validation logic here
        // For simplicity, this example assumes any non-empty string is a valid destination
        return !destination.isEmpty();
    }

private void bookFlightDialog(Flight selectedFlight) {
    int availableSeats = selectedFlight.seats - getBookedSeats(selectedFlight.id);
    if (availableSeats <= 0) {
        JOptionPane.showMessageDialog(this, "No available seats for the selected flight.");
        return;
    }

    int columns = 5; // Number of columns
    int rows = (int) Math.ceil((double) selectedFlight.seats / columns);

    JPanel seatSelectionPanel = new JPanel(new GridLayout(rows, columns));

    for (int i = 1; i <= selectedFlight.seats; i++) {
        final int seatNumber = i;  // Declare a final variable for i

        JButton seatButton = new JButton(String.valueOf(seatNumber));

        // Check if the seat is already booked
        if (isSeatBooked(selectedFlight.id, seatNumber)) {
            seatButton.setBackground(Color.RED); // Highlight booked seats
            seatButton.setEnabled(false); // Disable booking for already booked seats

            // Add action for canceling a reservation
            seatButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cancelSeat(selectedFlight, seatNumber);
                }
            });

            // Add the cancellation button to the seat button
            seatButton.setText(seatButton.getText() + " (Cancel)");

        } else {
            seatButton.setBackground(Color.GREEN); // Highlight available seats
            seatButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    bookSeat(selectedFlight, seatNumber);
                }
            });
        }

        seatButtons.add(seatButton); // Add seatButton to the list
        seatSelectionPanel.add(seatButton);
    }

    // Display additional information about the selected flight
    JLabel flightInfoLabel = new JLabel(String.format("Flight Details: %s - Departure Time: %s, Price: rs%.2f",
            selectedFlight.name, selectedFlight.departureTime, selectedFlight.price));

    JPanel dialogPanel = new JPanel(new BorderLayout());
    dialogPanel.add(flightInfoLabel, BorderLayout.NORTH);
    dialogPanel.add(seatSelectionPanel, BorderLayout.CENTER);

    JOptionPane.showMessageDialog(this, dialogPanel, "Select a Seat", JOptionPane.PLAIN_MESSAGE);
}
 private void cancelSeat(Flight selectedFlight, int canceledSeatNumber) {
        if (isSeatBooked(selectedFlight.id, canceledSeatNumber)) {
            for (Reservation reservation : reservations) {
                if (reservation.flightId == selectedFlight.id && reservation.seatsBooked == canceledSeatNumber) {
                    reservations.remove(reservation);

                    // Update the color of the canceled seat button immediately
                    for (JButton seatButton : seatButtons) {
                        if (Integer.parseInt(seatButton.getText()) == canceledSeatNumber) {
                            seatButton.setBackground(Color.GREEN);
                            seatButton.setEnabled(true);
                            break;
                        }
                    }

                    // Display the cancellation message in the GUI
                    cancellationStatusLabel.setText("Cancellation successful! Seat Number: " + canceledSeatNumber);
                    return;
                }
            }
        } else {
            // Display the message that the seat is not booked
            cancellationStatusLabel.setText("Seat " + canceledSeatNumber + " is not booked. Cannot cancel.");
        }
    }


private void cancelTicketsDialog() {
    JPanel cancelPanel = new JPanel(new GridLayout(0, 1));

    for (Reservation reservation : reservations) {
        Flight bookedFlight = getFlightById(reservation.flightId);
        JButton cancelTicketButton = new JButton(String.format("Flight %s, Seat %d", bookedFlight.name, reservation.seatsBooked));
        cancelTicketButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelSeat(bookedFlight, reservation.seatsBooked);
            }
        });
        cancelPanel.add(cancelTicketButton);
    }

    if (reservations.isEmpty()) {
        JOptionPane.showMessageDialog(this, "No tickets booked");
    } else {
        JOptionPane.showMessageDialog(this, cancelPanel, "Cancel Tickets", JOptionPane.PLAIN_MESSAGE);
    }
}

// Add this method to your AirlineReservationSystemGUI class
private Flight getFlightById(int flightId) {
    for (Flight flight : flights) {
        if (flight.id == flightId) {
            return flight;
        }
    }
    return null;
}


private void bookSeat(Flight selectedFlight, int selectedSeatNumber) {
        if (!isSeatBooked(selectedFlight.id, selectedSeatNumber)) {
            reservations.add(new Reservation(selectedFlight.id, selectedSeatNumber)); // Booking the selected seat
            JOptionPane.showMessageDialog(this,
                    "Booking successful!\nSeat Number: " + selectedSeatNumber + "\nTotal Price: rs" + selectedFlight.price);

            // Update the color of the booked seat button
            for (JButton seatButton : seatButtons) {
                if (Integer.parseInt(seatButton.getText()) == selectedSeatNumber) {
                    seatButton.setBackground(Color.RED);
                    seatButton.setEnabled(false);
                    break;
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seat " + selectedSeatNumber + " is already booked. Please select another seat.");
        }
    }


private boolean isSeatBooked(int flightId, int seatNumber) {
    for (Reservation reservation : reservations) {
        if (reservation.flightId == flightId && reservation.seatsBooked > 0 && reservation.seatsBooked == seatNumber) {
            // Check if the specific seat number is booked
            return true;
        }
    }
    return false;
}



    private int getBookedSeats(int flightId) {
        int bookedSeats = 0;

        for (Reservation reservation : reservations) {
            if (reservation.flightId == flightId) {
                bookedSeats += reservation.seatsBooked;
            }
        }

        return bookedSeats;
    }

    private String[] getDistinctDestinations() {
        List<String> destinations = new ArrayList<>();
        for (Flight flight : flights) {
            if (!destinations.contains(flight.from)) {
                destinations.add(flight.from);
            }
            if (!destinations.contains(flight.to)) {
                destinations.add(flight.to);
            }
        }
        return destinations.toArray(new String[0]);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AirlineReservationSystemGUI();
            }
        });
    }
}

