package ci553.happyshop.auth;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AuthService {

    private final List<User> users = new ArrayList<>();

    public AuthService() {
        // Users
        users.add(new User("cust1", "1234", Role.CUSTOMER));
        users.add(new User("picker1", "1234", Role.PICKER));
        users.add(new User("wh1", "1234", Role.WAREHOUSE));
    }

    public Optional<User> login(String username, String password) {
        return users.stream()
                .filter(u ->
                        u.getUsername().equals(username)
                                && u.getPassword().equals(password)
                )
                .findFirst();
    }
}
