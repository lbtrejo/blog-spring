package com.codeup.blogspring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @GetMapping("/posts")
    @ResponseBody
    public String getPosts() {
        return "Listing of all posts";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String getPost(@PathVariable String id) {
        return String.format("Post ID: %s", id);
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String viewCreatePost() {
        return "Create a post!";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost() {
        return "Post created";
    }
}
