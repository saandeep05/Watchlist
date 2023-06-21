package com.saandeep.Watchlist.repository;

import com.saandeep.Watchlist.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByMovieName(String keyword);

    List<Movie> findByOrderByDateAddedAsc();

    List<Movie> findByOrderByDateAddedDesc();

    List<Movie> findByUserId(Long userId);

    List<Movie> findByUserIdAndIsFinishedFalse(Long userId);
}
