package com.jmmarao.workshopspringboot3mongodb.controllers;

import com.jmmarao.workshopspringboot3mongodb.controllers.utils.URL;
import com.jmmarao.workshopspringboot3mongodb.model.entities.Post;
import com.jmmarao.workshopspringboot3mongodb.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findPostsByTitleController(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParam(text);
        List<Post> postsToFind = postService.findPostsByTitle(text);
        return ResponseEntity.ok().body(postsToFind);
    }

    @GetMapping(value = "/fullsearch")
    public ResponseEntity<List<Post>> fullSearchPostsController(
            @RequestParam(value = "text", defaultValue = "") String text,
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate) {
        text = URL.decodeParam(text);
        Date min = URL.convertDate(minDate, new Date(0L));
        Date max = URL.convertDate(maxDate, new Date());
        List<Post> postsToFind = postService.fullSearch(text, min, max);
        return ResponseEntity.ok().body(postsToFind);
    }
}
