package com.jmmarao.workshopspringboot3mongodb.config;

import com.jmmarao.workshopspringboot3mongodb.model.dtos.AuthorDTO;
import com.jmmarao.workshopspringboot3mongodb.model.entities.Post;
import com.jmmarao.workshopspringboot3mongodb.model.entities.User;
import com.jmmarao.workshopspringboot3mongodb.repositories.PostRepository;
import com.jmmarao.workshopspringboot3mongodb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User user1 = new User(null, "Iron man", "iron@email.com");
        User user2 = new User(null, "Thor", "thunder@email.com");
        User user3 = new User(null, "Captain Marvel", "marvel@email.com");

        userRepository.saveAll(Arrays.asList(user1, user2, user3));

        Post post1 = new Post(null, simpleDateFormat.parse("21/03/2023"), "Planning my next vacation", "I'm going to Brazil", new AuthorDTO(user1));
        Post post2 = new Post(null, simpleDateFormat.parse("25/02/2023"), "Defeat Thanos", "Remember when I defeated Thanos? What happened?", new AuthorDTO(user1));

        postRepository.saveAll(Arrays.asList(post1, post2));
    }
}
