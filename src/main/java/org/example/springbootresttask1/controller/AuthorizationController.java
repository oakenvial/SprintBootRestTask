package org.example.springbootresttask1.controller;

import jakarta.validation.Valid;
import org.example.springbootresttask1.model.Authorities;
import org.example.springbootresttask1.model.User;
import org.example.springbootresttask1.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
public class AuthorizationController {
    @Autowired
    AuthorizationService service;

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Valid User user) {
        return service.getAuthorities(user);
    }
}
