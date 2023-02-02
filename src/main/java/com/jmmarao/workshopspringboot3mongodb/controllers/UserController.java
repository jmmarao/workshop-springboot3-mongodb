package com.jmmarao.workshopspringboot3mongodb.controllers;

import com.jmmarao.workshopspringboot3mongodb.entities.User;
import com.jmmarao.workshopspringboot3mongodb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findUsersController() {
        return ResponseEntity.ok().body(userService.findUsers());
    }
}
