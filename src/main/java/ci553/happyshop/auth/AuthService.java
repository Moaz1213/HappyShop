package ci553.happyshop.auth;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AuthService {

    private final List<User> users = new ArrayList<>();

    public AuthService() {
        // Users
        users.add(new User("customer", "2006", Role.CUSTOMER));
        users.add(new User("picker", "2006", Role.PICKER));
        users.add(new User("warehouse", "2006", Role.WAREHOUSE));
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
