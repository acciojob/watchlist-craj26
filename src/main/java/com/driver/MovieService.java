package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    
    MovieRepository movieRepository;
    public Movie findMovie(String name) {
        return movieRepository.findMovie(name);

    }

    public void addMovie(Movie movie) {
        movieRepository.adddMovie(movie);
    }

    public void addDirector(Director director) {
        movieRepository.adddDirector(director);
    }

    public void createMovieDirectorPair(String movie, String director) {
        movieRepository.saveMovieDirectorPair(movie, director);
    }

    public Director findDirector(String name) {
        return movieRepository.findDirector(name);
    }

    public List<String> findMoviesFromDirector(String director) {
        return movieRepository.findMoviesFromDirector(director);
    }

    public List<String> findAllMovies() {
        return movieRepository.findAllMovies();
    }

    public void deleteDirectorMovie(String director) {
        movieRepository.deleteDirectorMovie(director);
    }

    public void deleteAll() {
        movieRepository.deleteAll();
    }
}
