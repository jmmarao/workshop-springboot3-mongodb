package com.jmmarao.workshopspringboot3mongodb.services;

import com.jmmarao.workshopspringboot3mongodb.model.entities.Post;
import com.jmmarao.workshopspringboot3mongodb.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public List<Post> findPostsByTitle(String text) {
        return postRepository.findByTitleProcedure(text);
    }
}
