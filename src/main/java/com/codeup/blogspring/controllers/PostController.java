package com.codeup.blogspring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @GetMapping("/posts")
    public String getPosts() {
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String showPost(@PathVariable String id, Model model) {
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
