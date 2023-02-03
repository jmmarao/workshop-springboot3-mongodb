package com.jmmarao.workshopspringboot3mongodb.controllers;

import com.jmmarao.workshopspringboot3mongodb.model.dtos.UserDTO;
import com.jmmarao.workshopspringboot3mongodb.model.entities.User;
import com.jmmarao.workshopspringboot3mongodb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findUsersController() {
        List<User> usersEntity = userService.findUsers();
        List<UserDTO> usersDTO = usersEntity.stream().map(user -> new UserDTO(user)).collect(Collectors.toList());
        return ResponseEntity.ok().body(usersDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findUserController(@PathVariable String id) {
        User userEntity = userService.findUser(id);
        return ResponseEntity.ok().body(new UserDTO(userEntity));
    }

    @PostMapping
    public ResponseEntity<Void> insertUsersController(@RequestBody UserDTO userDTO) {
        User entity = userService.fromDTO(userDTO);
        entity = userService.insertUser(entity);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(entity.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteUserByIdController(@PathVariable String id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
