package com.saandeep.Watchlist.repository;

import com.saandeep.Watchlist.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByUsernameContaining(String keyword);

    Optional<User> findByUsername(String username);
}
