import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String password;
    private List<String> booked;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.booked = new ArrayList<>();
    }
    //get username for user
    public String getUsername() {
        return username;
    }
    //get password for user 
    public String getPassword() {
        return password;
    }
    //add flights to users profile
    public void bookFlight(String flightNumber) {
    	booked.add(flightNumber);
    }
    //remove flights to users profile
    public void cancelFlight(String flightNumber) {
    	booked.remove(flightNumber);
    }
    
    //get flights to users profile
    public List<String> getFlightsBooked() {
        return booked;
    }
}