package org.example.springbootresttask1.service;

import org.example.springbootresttask1.exception.InvalidCredentials;
import org.example.springbootresttask1.exception.UnauthorizedUser;
import org.example.springbootresttask1.model.Authorities;
import org.example.springbootresttask1.model.User;
import org.example.springbootresttask1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class AuthorizationService {
    @Autowired
    UserRepository userRepository;

    public List<Authorities> getAuthorities(User user) {
//        if (isEmpty(user.getUser()) || isEmpty(user.getPassword())) {
//            throw new InvalidCredentials("User name or password is empty");
//        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user.getUser());
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
