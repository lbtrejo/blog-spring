package com.codeup.blogspring.controllers;

import com.codeup.blogspring.models.Post;
import com.codeup.blogspring.models.User;
import com.codeup.blogspring.repos.PostRepository;
import com.codeup.blogspring.repos.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    private final PostRepository postDao;
    private final UserRepository userDao;

    public PostController(PostRepository postDao, UserRepository userDao){
        this.postDao = postDao;
        this.userDao = userDao;
    }

    @GetMapping("/posts")
    public String getPosts(Model model) {

        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String showPost(@PathVariable long id, Model model) {
        Post test = new Post();
        if (postDao.findById(id).isPresent()){
            test = postDao.getOne(id);
        } else {
            return "redirect:/posts";
        }

        model.addAttribute("post", test);
        model.addAttribute("id", id);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String viewCreatePost() {
        return "posts/create";
    }

    @PostMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable long id){
        if (postDao.findById(id).isPresent()){
            postDao.deleteById(id);
        }
        return "redirect:/posts";
    }

    @PostMapping("/posts/create")
    public String createPost(
            @RequestParam(name = "title") String title,
            @RequestParam(name = "body") String body
    ) {
        User user = userDao.getOne(1L);
        Post post = new Post(title, body, user);
        postDao.save(post);
        // Need a 
        return "redirect:/posts";
    }

    @PostMapping("/posts/{id}/edit")
    public String editPost(
            @PathVariable long id,
            @RequestParam(name = "title") String title,
            @RequestParam(name = "body") String body
    ){
        if (postDao.findById(id).isPresent()){
            Post dbPost = postDao.getOne(id);
            dbPost.setTitle(title);
            dbPost.setBody(body);
            postDao.save(dbPost);
        }
        return "redirect:/posts";
    }
}
