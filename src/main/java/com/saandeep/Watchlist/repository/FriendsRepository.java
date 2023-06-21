package com.saandeep.Watchlist.repository;

import com.saandeep.Watchlist.model.Friend;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FriendsRepository extends JpaRepository<Friend, Long> {
    List<Friend> findByOwnerId(Long userId);

    void deleteByOwnerIdAndHasAccessId(Long friendId, Long requestedId);

    List<Friend> findByHasAccessId(Long userId);
}
