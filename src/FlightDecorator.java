public abstract class FlightDecorator extends Flight {
    
    protected Flight decoratedFlight;
    
    public FlightDecorator(Flight decoratedFlight) {
        super(decoratedFlight.getFlightNumber(), decoratedFlight.getDepartureCity(), 
              decoratedFlight.getArrivalCity(), decoratedFlight.getDepartureTime(), 
              decoratedFlight.getArrivalTime(), decoratedFlight.getSeats(), decoratedFlight. getCost());
        this.decoratedFlight = decoratedFlight;
    }

    abstract public String getDescription();

    public double getCost() {
        return decoratedFlight.getCost() + 10;
    }
}
