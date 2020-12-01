package com.codeup.blogspring.controllers;

import com.codeup.blogspring.models.Post;
import com.codeup.blogspring.repos.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    private final PostRepository postDao;

    public PostController(PostRepository postDao){
        this.postDao = postDao;
    }

    @GetMapping("/posts")
    public String getPosts(Model model) {

        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String showPost(@PathVariable String id, Model model) {
        Post test = new Post("Test Title", "Test Body");

        model.addAttribute("post", test);
        model.addAttribute("id", id);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String viewCreatePost() {
        return "Create a post!";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost(
            @RequestParam(name = "title") String title,
            @RequestParam(name = "body") String body
    ) {
        Post post = new Post(title, body);
        Post dbPost = postDao.save(post);
        return "Post created with ID: " + dbPost.getId();
    }
}
