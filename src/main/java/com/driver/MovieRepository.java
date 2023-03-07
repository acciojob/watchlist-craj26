package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Repository
public class MovieRepository {

    private HashMap<String, Movie> movieMap;
    private HashMap<String, Director> directorMap;
    private HashMap<String, List<String>> directorMovieMapping;

    public MovieRepository(HashMap<String, Movie> movieMap, HashMap<String, Director> directorMap, HashMap<String, List<String>> directorMovieMapping) {
        this.movieMap = movieMap;
        this.directorMap = directorMap;
        this.directorMovieMapping = directorMovieMapping;
    }


    public  Director findDirector(String name) {
        return directorMap.get(name);
    }

    public void adddMovie(Movie movie) {
        movieMap.put(movie.getName(), movie);
    }

    public void adddDirector(Director director) {
        directorMap.put(director.getName(), director);
    }

    public void saveMovieDirectorPair(String movie, String director) {
        if(movieMap.containsKey(movie) && directorMap.containsKey(director)){
            movieMap.put(movie,movieMap.get(movie));
            directorMap.put(director,directorMap.get(director));

            List<String>currentMovie=new ArrayList<>();
            if(directorMovieMapping.containsKey(director)){
                currentMovie=directorMovieMapping.get(director);

            }
            currentMovie.add(movie);
            directorMovieMapping.put(director,currentMovie);
        }
        //directorMovieMapping.put(director,)
    }

    public Movie findMovie(String name) {
        return movieMap.get(name);
    }

    public List<String> findMoviesFromDirector(String director) {
        List<String> moviesList = new ArrayList<String>();
        if(directorMovieMapping.containsKey(director)){
            moviesList = directorMovieMapping.get(director);
        }
        return moviesList;
    }

    public List<String> findAllMovies() {
        return new ArrayList<>(movieMap.keySet());
        //something new i learn
    }


    public void deleteDirectorMovie(String director) {
        List<String> movies = new ArrayList<String>();
        if(directorMovieMapping.containsKey(director)){
            movies = directorMovieMapping.get(director);
            for(String movie: movies){
                if(movieMap.containsKey(movie)){
                    movieMap.remove(movie);
                }
            }

            directorMovieMapping.remove(director);
        }

        if(directorMap.containsKey(director)){
            directorMap.remove(director);
        }
    }

    public void deleteAll() {
        HashSet<String> moviesSet = new HashSet<String>();

        for(String director: directorMovieMapping.keySet()){
            for(String movie: directorMovieMapping.get(director)){
                moviesSet.add(movie);
            }
        }

        for(String movie: moviesSet){
            if(movieMap.containsKey(movie)){
                movieMap.remove(movie);
            }
        }
    }
}
