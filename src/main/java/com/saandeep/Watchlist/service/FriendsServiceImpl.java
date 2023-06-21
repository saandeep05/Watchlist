package com.saandeep.Watchlist.service;

import com.saandeep.Watchlist.model.Friend;
import com.saandeep.Watchlist.model.User;
import com.saandeep.Watchlist.repository.FriendsRepository;
import com.saandeep.Watchlist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendsServiceImpl implements FriendsService {
    @Autowired
    FriendsRepository friendsRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public List<Friend> getAllFriends(Long userId) {
        return friendsRepository.findByHasAccessId(userId);
    }

    @Override
    public void addFriend(Long ownerId, Long friendId, Friend friend) {
        if(userRepository.findById(ownerId).isPresent() && userRepository.findById(friendId).isPresent()) {
            User owner = userRepository.findById(ownerId).get();
            User friendUser = userRepository.findById(friendId).get();
            friend.setOwner(owner);
            friend.setHasAccess(friendUser);
            friendsRepository.save(friend);
        }
    }

    @Override
    public void deleteFriend(Long friendId, Long requestedId) {
        friendsRepository.deleteByOwnerIdAndHasAccessId(friendId, requestedId);
    }
}
