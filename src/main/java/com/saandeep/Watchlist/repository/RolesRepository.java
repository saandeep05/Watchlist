package com.saandeep.Watchlist.repository;

import com.saandeep.Watchlist.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RolesRepository extends JpaRepository<Roles, Long> {
    List<Roles> findByUserId(Long userId);
}
