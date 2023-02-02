package com.jmmarao.workshopspringboot3mongodb.controllers;

import com.jmmarao.workshopspringboot3mongodb.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @GetMapping
    public ResponseEntity<List<User>> findUsersController() {
        List<User> users = new ArrayList<>();
        User user1 = new User(0L, "Doctor Strange", "strange@email.com");
        User user2 = new User(1L, "Hulk", "smash@email.com");
        users.addAll(Arrays.asList(user1, user2));
        return ResponseEntity.ok().body(users);
    }
}
