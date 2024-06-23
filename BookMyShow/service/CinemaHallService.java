package BookMyShow.service;

import BookMyShow.model.CinemaHall;
import BookMyShow.model.Show;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CinemaHallService {

    public static Map<Integer, List<Show>> cinemaIdVsShows;
    public static Map<String, List<CinemaHall>> cityVsCinemasMap;

    static {
        cinemaIdVsShows = new HashMap<>();
        cityVsCinemasMap = new HashMap<>();
    }


    public void populateCities(List<String> cities) {
        cities.stream().forEach(city -> cityVsCinemasMap.put(city, new ArrayList<>()));
    }

    public List<Show> getAllShowsByCinema(Integer cinemaId) {
        return cinemaIdVsShows.get(cinemaId);
    }

    public List<CinemaHall> getAllTheatresByCity(String cityName) {
        return cityVsCinemasMap.get(cityName);
    }

    public void addCinemaHall(CinemaHall cinemaHall, String city) {
        cityVsCinemasMap.get(city).add(cinemaHall);
    }

    public void addShowsInCinema(Integer cinemaId, List<Show> shows) {
        if (cinemaIdVsShows.get(cinemaId) == null) {
            cinemaIdVsShows.put(cinemaId, new ArrayList<>());
        }
        cinemaIdVsShows.get(cinemaId).addAll(shows);
    }


}
