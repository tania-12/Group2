import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Create a new FlightReservation object
        FlightReservation reservation = new FlightReservation();

        // Add some flights to the reservation system
        Flight flight1 = new Flight("IA123", "New York", "Los Angeles", "10:00 AM", "1:00 PM" , 160, 220.0);
        Flight flight2 = new Flight("TC456", "Florida", "Maine", "1:00 PM", "5:00 PM", 80, 80.0);
        Flight flight3 = new Flight("MR789", "Paris", "Dubai", "8:00 AM", "1:00 PM" , 175, 320.12);
        Flight flight4 = new Flight("TS101", "Switzerland", "Seoul", "1:00 PM", "10:00 AM", 170, 432.99);
        Flight flight5 = new Flight("KW121", "Tokyo", "Italy", "9:00 AM", "1:00 PM" , 150, 213.43);
      
        Flight mealFlight1 = new MealFlightDecorator(flight1); 
        Flight mealFlight2 = new MealFlightDecorator(flight2); 
        Flight mealFlight3 = new MealFlightDecorator(flight3); 
        Flight mealFlight4 = new MealFlightDecorator(flight4); 
        Flight mealFlight5 = new MealFlightDecorator(flight5); 
        reservation.addFlight(mealFlight1);
        reservation.addFlight(flight2);
        reservation.addFlight(flight3);
        reservation.addFlight(flight4);
        reservation.addFlight(flight5);
      

        // Add some users to the reservation system
        User user1 = new User("Harry", "password1");
        User user2 = new User("Yung", "password2");
        reservation.addUser(user1);
        reservation.addUser(user2);

        // Allow users to book and cancel seats
        Scanner input2 = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to SkyPass Airlines");
            System.out.println();
            mainMenu();
            String input = input2.nextLine();
            if (input.equals("0")) {
                break;
            }
           
            if (input.equals("1")) {
                System.out.println("Available Flights:");
                System.out.println();
            for (Flight flight : reservation.getFlights()) {
                System.out.println(flight.getFlightNumber() + " - " 
                + flight.getDepartureCity() + " to " + flight.getArrivalCity() 
                + " (" + flight.getDepartureTime() + " to " + flight.getArrivalTime() 
                + ") - " + flight.getSeatsAvailable() + " seats remaining");
}               System.out.println("Enter the flight number:");
                String flightNumber = input2.nextLine();
                System.out.println("Enter your username:");
                String username = input2.nextLine();
                System.out.println("Enter your password:");
                String password = input2.nextLine();
            
                reservation.bookFlight(flightNumber, username, password);
            } else if (input.equals("2")) {
                System.out.println("Enter the flight number:");
                String flightNumber = input2.nextLine();
                System.out.println("Enter your username:");
                String username = input2.nextLine();
                System.out.println("Enter your password:");
                String password = input2.nextLine();
            
                reservation.cancelFlight(flightNumber, username, password);
            } else if (input.equals("3")) {
            	 System.out.println("Enter your username:");
                 String username = input2.nextLine();
                 System.out.println("Enter your password:");
                 String password = input2.nextLine();
             
                reservation.viewReservation(username, password);
            } else {
                System.out.println("Invalid input");
            }
        }
    }
    static void mainMenu() {
        System.out.println("Press 0 to Exit.");
        System.out.println("Press 1 to Book a Flight");
        System.out.println("Press 2 to Cancel a Flight");
        System.out.println("Press 3 to View your Flight(s)");
        System.out.println("Enter the menu choice:    ");
    }
}