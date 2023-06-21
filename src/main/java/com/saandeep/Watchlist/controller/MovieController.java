package com.saandeep.Watchlist.controller;

import com.saandeep.Watchlist.model.Movie;
import com.saandeep.Watchlist.service.FriendsService;
import com.saandeep.Watchlist.service.MovieService;
import com.saandeep.Watchlist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
@CrossOrigin
public class MovieController {
    @Autowired
    MovieService movieService;

    @GetMapping("")
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }


    @PutMapping("/{movieId}")
    public void updateMovie(@PathVariable Long movieId, Movie movie) {
        movieService.updateMovie(movieId, movie);
    }

    @DeleteMapping("/{movieId}")
    public void deleteMovie(@PathVariable Long movieId) {
        movieService.deleteMovie(movieId);
    }

    @GetMapping("/{keyword}")
    public List<Movie> searchMovie(@PathVariable String keyword) {
        return movieService.searchMovie(keyword);
    }


    @GetMapping("/user/{userId}")
    public List<Movie> getMoviesOfUser(@PathVariable Long userId) {
        return movieService.getMoviesOfUser(userId);
    }

    @PostMapping("/user/{userId}")
    public void addMovie(@PathVariable Long userId, @RequestBody Movie movie) {
        movieService.addMovie(userId, movie);
    }
}
