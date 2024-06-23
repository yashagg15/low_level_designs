package BookMyShow.service;

import BookMyShow.model.CinemaHall;
import BookMyShow.model.Movie;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SearchService {

    public BmsService bmsService;

    public SearchService() {
        this.bmsService = new BmsService();
    }

    public List<String> getAllCities() {
        return bmsService.getAllCities();
    }

    public Set<Movie> getAllMovieByLanguage(String language, String cityName) {
        return bmsService.getAllMovieByLanguage(language, cityName);
    }

    public Set<Movie> getAllMoviesByCity(String cityName) {

        return bmsService.getAllMoviesByCity(cityName);
    }

    public List<CinemaHall> getAllTheatresByCity(String cityName) {
        return bmsService.getAllTheatresByCity(cityName);
    }

    public Set<Movie> searchMovieByName(String movieName, String cityName) {
        Set<Movie> moviesList = getAllMoviesByCity(cityName);
        Set<Movie> filterByNameMovies = moviesList.stream().
                filter(movie -> movie.getMovieTitle().equals(movieName)).collect(Collectors.toSet());
        return filterByNameMovies;
    }

    public Set<Movie> searchMovieByGenre(String genre, String cityName) {
        Set<Movie> moviesList = getAllMoviesByCity(cityName);
        Set<Movie> filterByGenreMovies = moviesList.stream().
                filter(movie -> movie.getGenre().name().equals(genre)).collect(Collectors.toSet());
        return filterByGenreMovies;
    }

    public Set<Movie> searchMovieByLanguage(String language, String cityName) {
        return getAllMovieByLanguage(language, cityName);
    }

}
