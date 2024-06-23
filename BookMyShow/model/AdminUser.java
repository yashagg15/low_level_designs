package BookMyShow.model;

import BookMyShow.service.BmsService;
import BookMyShow.service.SearchService;

import java.util.List;

public class AdminUser extends BaseUser{

    public  BmsService bmsService;

    public AdminUser(Integer userId, String firstName, String lastName, AccountDetails accountDetails,
                     SearchService searchService) {
        super(userId,firstName, lastName, accountDetails, searchService);
        this.bmsService = new BmsService();
    }

    public String addTheatre(CinemaHall cinemaHall, String city){
        bmsService.addCinemaHall(cinemaHall,city);
        return "Cinema Hall added";
    }

    public String addMovieShowsInTheatre(List<Show> show, Integer cinemaHallId){
        bmsService.addShowsInCinema(cinemaHallId, show);
        return "Shows added successfully";
    }




}
