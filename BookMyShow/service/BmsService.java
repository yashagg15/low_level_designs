package BookMyShow.service;

import BookMyShow.model.CinemaHall;
import BookMyShow.model.Movie;
import BookMyShow.model.Show;

import java.util.*;
import java.util.stream.Collectors;

public class BmsService {

    public static Map<String, Set<Movie>> cityVsMovieMap;
    public static Map<String, Set<Movie>> languageVsMovieMap;
    public static List<String> cities;
    public static List<String> allLanguages;
    public static CinemaHallService cinemaHallService;
    public static Map<Integer, Show> fetchShow;

    static {
        cities = new ArrayList<>();
        allLanguages = new ArrayList<>();
        languageVsMovieMap = new HashMap<>();
        cities.addAll(Arrays.asList("Mumbai", "Delhi", "Noida", "Bengaluru", "Pune", "Hyderabad"));
        allLanguages.addAll(Arrays.asList("Hindi", "Marathi", "Telugu", "English"));
        cityVsMovieMap = new HashMap<>();
        cinemaHallService = new CinemaHallService();
        cities.stream().forEach(city -> cityVsMovieMap.put(city, new HashSet<>()));
        cities.stream().forEach(city -> languageVsMovieMap.put(city, new HashSet<>()));
        cinemaHallService.populateCities(cities);
        fetchShow = new HashMap<>();
    }

    public List<String> getAllCities() {
        return cities;
    }

    public Set<Movie> getAllMovieByLanguage(String language, String cityName) {

        Set<Movie> filterMovieListByLanguage = cityVsMovieMap.get(cityName).
                stream().filter(movie -> movie.getLanguageSupported().contains(language)).collect(Collectors.toSet());
        return filterMovieListByLanguage;
    }

    public Set<Movie> getAllMoviesByCity(String cityName) {
        return cityVsMovieMap.get(cityName);
    }

    public List<CinemaHall> getAllTheatresByCity(String cityName) {
        return cinemaHallService.getAllTheatresByCity(cityName);
    }

    public void addCinemaHall(CinemaHall cinemaHall, String city) {
        cinemaHallService.addCinemaHall(cinemaHall, city);
    }

    public void addShowsInCinema(Integer cinemaId, List<Show> shows) {
        cinemaHallService.addShowsInCinema(cinemaId, shows);
        shows.stream().forEach(show -> {
            fetchShow.put(show.getShowId(), show);
            CinemaHall cinemaHall = show.getCinemaHallPlayedAt();
            Movie movie = show.getMovie();
            String city = cinemaHall.getAddress();
            cityVsMovieMap.get(city).add(movie);
            List<String> supportedLang = movie.getLanguageSupported();
            supportedLang.stream().forEach(lan -> {
                if (languageVsMovieMap.get(lan) == null) {
                    languageVsMovieMap.put(lan, new HashSet<>());
                }
                languageVsMovieMap.get(lan).add(movie);
            });
        });

    }

    public Set<Show> getAllShowsByCityAndMovie(String city, String movie) {
        List<CinemaHall> cinemaHalls = cinemaHallService.getAllTheatresByCity(city);
        Set<Show> filterByMovie = new HashSet<>();
        cinemaHalls.stream().forEach(cinemaHall -> {
            Integer cinemaHallId = cinemaHall.getCinemaHallId();
            List<Show> shows = cinemaHallService.getAllShowsByCinema(cinemaHallId);
            filterByMovie.addAll(shows.stream().
                    filter(show -> show.getMovie().getMovieTitle().equals(movie)).collect(Collectors.toSet()));
        });
        return filterByMovie;
    }

    public Show getAShow(Integer showId) {
        return fetchShow.get(showId);
    }

}
