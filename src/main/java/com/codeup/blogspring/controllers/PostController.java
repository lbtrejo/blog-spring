package com.codeup.blogspring.controllers;

import com.codeup.blogspring.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    @GetMapping("/posts")
    public String getPosts(Model model) {
        List<Post> listings = new ArrayList<>();
        Post test = new Post("Test Title", "Test Body");
        Post test2 = new Post("Test Title 2", "Test Body 2");
        listings.add(test);
        listings.add(test2);

        model.addAttribute("listings", listings);
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
    public String viewCreatePost() {
        return "Create a post!";
    }

    @PostMapping("/posts/create")
    public String createPost() {
        return "Post created";
    }
}
