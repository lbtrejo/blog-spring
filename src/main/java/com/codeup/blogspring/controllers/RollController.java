package com.codeup.blogspring.controllers;

import com.codeup.blogspring.utlis.rollDie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

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
        List<Integer> rollList = rollDie.rollArr();
        List<String[]> resultList = new ArrayList<>();

        if(userGuess == roll) {
            model.addAttribute("correct", true);
        } else {
            model.addAttribute("correct", false);
        }

        for (int rollGuess : rollList) {
            String [] temp = new String[2];
            if (rollGuess == userGuess) {
                temp[0] = String.valueOf(rollGuess) ;
                temp[1] = "Y";
            } else {
                temp[0] = String.valueOf(rollGuess) ;
                temp[1] = "N";
            }
            resultList.add(temp);
        }

        model.addAttribute("resultList", resultList);
        model.addAttribute("guess", userGuess);
        model.addAttribute("roll", roll);
        model.addAttribute("rollList", rollList);

        return "rollresult";
    }
}
