package com.jmmarao.workshopspringboot3mongodb.repositories;

import com.jmmarao.workshopspringboot3mongodb.model.entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}
