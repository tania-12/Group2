public class MealFlightDecorator extends FlightDecorator {

    public MealFlightDecorator(Flight decoratedFlight) {
        super(decoratedFlight);
    }

    @Override
    public String getDescription() {
        return decoratedFlight.getFlightNumber() + " with in-flight meal";
    }

    @Override
    public double getCost() {
        return decoratedFlight.getCost() + 10.0;
    }
}
