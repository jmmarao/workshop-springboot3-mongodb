package com.jmmarao.workshopspringboot3mongodb.repositories;

import com.jmmarao.workshopspringboot3mongodb.model.entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> {
    List<Post> findByTitleContainingIgnoreCase(String text);
}
