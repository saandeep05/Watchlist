package com.saandeep.Watchlist.service;

import com.saandeep.Watchlist.model.Friend;

import java.util.List;

public interface FriendsService {
    public List<Friend> getAllFriends(Long userId);
    public void addFriend(Long ownerId, Long friendId, Friend friend);
    public void deleteFriend(Long friendId, Long requestedId);
}
