package com.codeup.blogspring.controllers;

import com.codeup.blogspring.utlis.rollDie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RollController {

    @GetMapping("/roll-dice")
    public String index() {
        return "rolldice";
    }

    @GetMapping("roll-dice/{guess}")
    public String result(@PathVariable int guess, Model model) {
        int userGuess = guess;
        int roll = rollDie.roll6();

        if(userGuess == roll) {
            model.addAttribute("correct", true);
        } else {
            model.addAttribute("correct", false);
        }

        model.addAttribute("guess", userGuess);
        model.addAttribute("roll", roll);

        return "rollresult";
    }
}
