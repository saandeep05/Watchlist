package com.saandeep.Watchlist.service;

import com.saandeep.Watchlist.model.Movie;

import java.util.List;

public interface MovieService {
    public List<Movie> getAllMovies();
    public void updateMovie(Long id, Movie movie);
    public void deleteMovie(Long id);
    public List<Movie> searchMovie(String keyword);
    public List<Movie> sortByDateAdded(boolean ascending);
    public List<Movie> getUnfinished(Long userId);

    public List<Movie> getMoviesOfUser(Long userId);
    public void addMovie(Long userId, Movie movie);
}
