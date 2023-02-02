package com.jmmarao.workshopspringboot3mongodb.config;

import com.jmmarao.workshopspringboot3mongodb.model.entities.User;
import com.jmmarao.workshopspringboot3mongodb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();

        User user1 = new User(null, "Iron man", "iron@email.com");
        User user2 = new User(null, "Thor", "thunder@email.com");
        User user3 = new User(null, "Captain Marvel", "marvel@email.com");

        userRepository.saveAll(Arrays.asList(user1, user2, user3));
    }
}
