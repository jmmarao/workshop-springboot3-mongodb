package com.jmmarao.workshopspringboot3mongodb.services;

import com.jmmarao.workshopspringboot3mongodb.model.dtos.UserDTO;
import com.jmmarao.workshopspringboot3mongodb.model.entities.User;
import com.jmmarao.workshopspringboot3mongodb.repositories.UserRepository;
import com.jmmarao.workshopspringboot3mongodb.services.exceptions.ResourceNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findUsers() {
        return userRepository.findAll();
    }

    public User findUser(String id) {
        User user = userRepository.findById(id);
        if (user == null) {
            throw new ResourceNotFound("[ResourceNotFound] User id " + id + " not found");
        }
        return user;
    }

    public User insertUser(User user) {
        return userRepository.insert(user);
    }

    public void deleteUser(String id) {
        isUser(id);
        userRepository.deleteById(id);
    }

    public User updateUser(User user) {
        User userToUpdate = userRepository.findById(user.getId());
        updateUserData(userToUpdate, user);
        return userRepository.save(userToUpdate);
    }

    public User fromDTO(UserDTO userDTO) {
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }

    private void isUser(String id) {
        userRepository.findById(id);
    }

    private void updateUserData(User userToUpdate, User user) {
        userToUpdate.setName(user.getName());
        userToUpdate.setEmail(user.getEmail());
    }
}
