package com.saandeep.Watchlist.service;

import com.saandeep.Watchlist.model.Movie;
import com.saandeep.Watchlist.model.User;
import com.saandeep.Watchlist.repository.MovieRepository;
import com.saandeep.Watchlist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public void updateMovie(Long id, Movie movie) {
        if(movieRepository.existsById(id)) {
            movie.setId(id);
        }
        movieRepository.save(movie);
    }

    @Override
    public void deleteMovie(Long id) {
        if(movieRepository.existsById(id)) {
            movieRepository.deleteById(id);
        }
    }

    @Override
    public List<Movie> searchMovie(String keyword) {
        return movieRepository.findByMovieName(keyword);
    }

    @Override
    public List<Movie> sortByDateAdded(boolean ascending) {
        if(ascending) {
            return movieRepository.findByOrderByDateAddedAsc();
        }
        return movieRepository.findByOrderByDateAddedDesc();
    }

    @Override
    public List<Movie> getUnfinished(Long userId) {
        return movieRepository.findByUserIdAndIsFinishedFalse(userId);
    }

    @Override
    public List<Movie> getMoviesOfUser(Long userId) {
        return movieRepository.findByUserId(userId);
    }

    @Override
    public void addMovie(Long userId, Movie movie) {
        if(userRepository.findById(userId).isPresent()) {
            User user = userRepository.findById(userId).get();
            movie.setUser(user);
            movie.setDateAdded(LocalDate.now());
        }
        movieRepository.save(movie);
    }
}
