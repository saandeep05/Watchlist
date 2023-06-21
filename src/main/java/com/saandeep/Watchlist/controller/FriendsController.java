package com.saandeep.Watchlist.controller;

import com.saandeep.Watchlist.model.Friend;
import com.saandeep.Watchlist.service.FriendsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/friends")
@CrossOrigin
public class FriendsController {
    @Autowired
    FriendsService friendsService;
    @GetMapping("/{userId}")
    public List<Friend> getFriendsOfUser(@PathVariable Long userId) {
        return friendsService.getAllFriends(userId);
    }
    @PostMapping("/{ownerId}/{friendId}")
    public void addFriend(@PathVariable Long ownerId, @PathVariable Long friendId) {
        friendsService.addFriend(ownerId, friendId, new Friend());
    }
}
