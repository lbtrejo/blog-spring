package com.codeup.blogspring.controllers;

import com.codeup.blogspring.models.User;
import com.codeup.blogspring.repos.Users;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private Users usersDao;
    private PasswordEncoder passwordEncoder;

    public UserController(Users usersDao, PasswordEncoder passwordEncoder){
        this.usersDao = usersDao;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/sign-up")
    public String showSignupForm(Model viewModel){
        viewModel.addAttribute("user", new User());
        return "users/sign-up";
    }

    @PostMapping("/sign-up")
    public String saveUser(@ModelAttribute User user){
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        usersDao.save(user);
        return "redirect:/login";
    }
}
