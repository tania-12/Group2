import java.util.HashMap;
import java.util.Map;

public class userData {
    private static userData instance = null;
    private Map<String, User> userMap;

    private userData() {
        userMap = new HashMap<>();
    }

    public static userData getInstance() {
        if (instance == null) {
            instance = new userData();
        }
        return instance;
    }

    public void addUser(User user) {
        userMap.put(user.getUsername(), user);
    }

    public User getUser(String username) {
        return userMap.get(username);
    
}
}