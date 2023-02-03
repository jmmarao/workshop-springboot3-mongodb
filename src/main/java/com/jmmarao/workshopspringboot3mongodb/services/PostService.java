package com.jmmarao.workshopspringboot3mongodb.services;

import com.jmmarao.workshopspringboot3mongodb.model.entities.Post;
import com.jmmarao.workshopspringboot3mongodb.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public List<Post> findPostsByTitle(String text) {
        return postRepository.findByTitleProcedure(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return postRepository.fullSearch(text, minDate, maxDate);
    }
}
