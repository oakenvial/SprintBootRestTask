package org.example.springbootresttask1.repository;

import org.example.springbootresttask1.model.Authorities;
import org.example.springbootresttask1.model.User;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class UserRepository {

    private final List<User> users;
    private final Map<User, List<Authorities>> userAuthorities;

    public UserRepository() {
        // Some example data
        User user1 = new User("Masha", "qwerty123");
        User user2 = new User("Tolya", "tolya89");
        User user3 = new User("Ivan", "12345");

        users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);

        userAuthorities = new HashMap<>();
        userAuthorities.put(user1, List.of(Authorities.READ));
        userAuthorities.put(user2, List.of(Authorities.READ, Authorities.DELETE, Authorities.WRITE));
        userAuthorities.put(user3, List.of(Authorities.READ, Authorities.DELETE));
    }

    public List<Authorities> getUserAuthorities(User user) {
        if (!users.contains(user)) {
            return new ArrayList<>();
        } else {
            return userAuthorities.get(user);
        }
    }
}
