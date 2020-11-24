package com.codeup.blogspring.controllers;

import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

//    @GetMapping("/hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello from Spring!";
//    }

//    @GetMapping("/hello/{name}")
//    @ResponseBody
//    public String sayHello(@PathVariable String name) {
//        return String.format("Hello from %s!", name);
//    }

    // Long version of above
    @RequestMapping(path = "/hello/{name}", method = RequestMethod.GET)
    @ResponseBody
    public String sayHello(@PathVariable String name) {
        return String.format("Hello from %s!", name);
    }

}


