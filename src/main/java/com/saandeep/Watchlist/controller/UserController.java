package com.saandeep.Watchlist.controller;

import com.saandeep.Watchlist.model.User;
import com.saandeep.Watchlist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    UserService userService;

//    @GetMapping("")
//    public List<User> getAllUsers() {
//        return userService.getAllUsers();
//    }

//    @PostMapping("")
//    public void createUser(@RequestBody User user) {
//        userService.createUser(user);
//    }

    // Everyone will be permitted to use this
    @PostMapping("/signup")
    public void signup(@RequestBody User user) {
        userService.createUser(user);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody User user) {
        userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @GetMapping("/{keyword}")
    public List<User> searchUser(@PathVariable String keyword) {
        return userService.searchUser(keyword);
    }
}