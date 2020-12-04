package com.codeup.blogspring.controllers;

import com.codeup.blogspring.models.Post;
import com.codeup.blogspring.models.User;
import com.codeup.blogspring.repos.PostRepository;
import com.codeup.blogspring.repos.UserRepository;
import com.codeup.blogspring.utlis.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@Controller
public class PostController {

    private final PostRepository postDao;
    private final UserRepository userDao;
    private final EmailService emailService;

    public PostController(PostRepository postDao, UserRepository userDao, EmailService emailService){
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
    }

    @GetMapping("/posts")
    public String getPosts(Model model) {

        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/search")
    public String searchPosts(
            @PathParam("searchType") String searchType,
            @PathParam("term") String term,
            Model viewModel){
        String wildcard = "%" + term + "%";
        List<Post> results;
        if (searchType.equalsIgnoreCase("title")){
            results = postDao.findAllByTitleIsLike(wildcard);
        } else {
            results = postDao.findAllByBodyIsLike(wildcard);
        }

        viewModel.addAttribute("results", results);
        return "posts/results";

        // TODO: Remove search type and make search work on both fields by default
    }

    @GetMapping("/posts/{id}")
    public String showPost(@PathVariable long id, Model model) {
        Post test;
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
    public String viewCreatePost(Model viewModel) {
        viewModel.addAttribute("post", new Post());
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
    public String createPost(@ModelAttribute Post submittedPost) {
        User dbUser = userDao.getOne(1L);
        submittedPost.setUser(dbUser);
        Post dbPost = postDao.save(submittedPost);
        emailService.prepareAndSend(dbPost, "Post created", "Post created, see post #" + dbPost.getId() + ".");
        // TODO: Need a userPostDao and appropriate code to make sure the 1 -> Many table gets populated
        return "redirect:/posts";
    }

    @PostMapping("/posts/{id}/edit")
    public String editPost(
            @PathVariable long id,
            @ModelAttribute Post editedPost
    ){

        Post dbPost = postDao.getOne(id);
        dbPost.setTitle(editedPost.getTitle());
        dbPost.setBody(editedPost.getBody());
        postDao.save(dbPost);
        return "redirect:/posts";
    }
}
