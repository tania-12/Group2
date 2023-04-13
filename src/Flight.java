public class Flight {
	
    private String flightNumber;
    private String departureAirport;
    private String arrivalAirport;
    private String departureTime;
    private String arrivalTime;
    private int seats;
    private int seatsAvailable;
    private double cost;
    
    //Flight Object
    public Flight(String flightNumber, String departureAirport, String arrivalAirport, String departureTime, String arrivalTime, int seats, double cost) {
        this.flightNumber = flightNumber;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.seats = seats;
        this.seatsAvailable = seats;
        this.cost = cost;
    }

    public String getFlightNumber() {
        return flightNumber;
    }
    public double getCost() {
        return cost;
    }

    public String getDepartureCity() {
        return departureAirport;
    }

    public String getArrivalCity() {
        return arrivalAirport;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public int getSeats() {
        return seats;
    }

    public int getSeatsAvailable() {
        return seatsAvailable;
        
    }
    //if flight is canceled seats available will decrement
    public void bookSeats() {
        if (seatsAvailable > 0) {
            seatsAvailable--;
        } else {
            System.out.println("This flight is full.");
        }
    }
    //if flight is canceled seats available will increment
    public void cancelSeats() {
        if (seatsAvailable < seats) {
            seatsAvailable++;
        } else {
            System.out.println("No seats to cancel.");
        }
    }
}