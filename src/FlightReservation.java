import java.util.ArrayList;
import java.util.List;

public class FlightReservation {
    private List<Flight> flights;
    private userData users;

    public FlightReservation() {
        flights = new ArrayList<>();
        users = userData.getInstance();
    }
    
    //adds flight to List of flights
    public void addFlight(Flight flight) {
        flights.add(flight);
    }
  //removes flight from List of flights
    public void removeFlight(String flightNumber) {
        for (Flight flight : flights) {
            if (flight.getFlightNumber().equals(flightNumber)) {
                flights.remove(flight);
                break;
            }
        }
    }
    // if flight is booked, and user is registered then flight gets added to users profile and flight seats are decremented
    public void bookFlight(String flightNumber, String username, String password) {
    	boolean isBooked = false;
        User user = users.getUser(username);
        if (user != null && user.getPassword().equals(password)) {
        	for (int i = 0; i < flights.size(); i++) {
                Flight flight = flights.get(i);
                if (flight.getFlightNumber().equals(flightNumber)) {
                    flight.bookSeats();
                    
                    user.bookFlight(flightNumber);
                    System.out.println("Seat booked for " + username + " on flight " + flightNumber);
                    System.out.println();
                    isBooked = true;
                    if (isBooked) {
                        flight = new MealFlightDecorator(flight);
                        MealFlightDecorator decoratedFlight = (MealFlightDecorator) flight;
                        System.out.println("Decorated flight description: " + decoratedFlight.getDescription());
                        System.out.println("Decorated flight cost: " + decoratedFlight.getCost());
                    }
                    System.out.println();
                    return;
                }
            }
            System.out.println("Flight not found");
        } else {
            System.out.println("Invalid username/password");
        }
    }
    
    // if flight is booked, and user is registered then flight gets added to users profile and flight seats are incremented
    public void cancelFlight(String flightNumber, String username, String password) {
        User user = users.getUser(username);
        if (user != null && user.getPassword().equals(password)) {
        	for (int i = 0; i < flights.size(); i++) {
                Flight flight = flights.get(i);
                if (flight.getFlightNumber().equals(flightNumber)) {
                    flight.cancelSeats();
                    user.cancelFlight(flightNumber);
                    System.out.println("Seat cancelled for " + username + " on flight " + flightNumber);
                    System.out.println();
                    return;
                }
            }
            System.out.println("Flight not found");
        } else {
            System.out.println("Invalid username and/or password");
        }
    }

    public void viewReservation(String username, String password) {
        User user = users.getUser(username);
        if (user != null && user.getPassword().equals(password)) {
            List<String> flight = user.getFlightsBooked();
            if (flight.size() == 0) {
                System.out.println("No flights booked for " + username);
            } else {
                System.out.println("Flights booked for " + username + ":");
                for (String flightNumber : flight) {
                    System.out.println("- " + flightNumber);
                }
            }
        } else {
            System.out.println("Invalid username and/or password");
        }
    }
    public List<Flight> getFlights() {
    return flights;
}

    public void addUser(User user) {
    	users.addUser(user);
    }
}