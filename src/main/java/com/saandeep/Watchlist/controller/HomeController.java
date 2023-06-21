package com.saandeep.Watchlist.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class HomeController {
    @GetMapping("")
    public String hello() {

        return "hello";
    }

    @GetMapping("/")
    public String hello2() {
        return "hello";
    }
}
