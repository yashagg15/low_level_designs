package BookMyShow.model;

import java.util.Date;
import java.util.List;

public class Show {

    private Integer showId;
    private Movie movie;
    private Date startTiming;
    private Date endTiming;
    private List<Seat> seats;
    private CinemaHall cinemaHallPlayedAt;


    public Show(Integer showId, Movie movie, Date startTiming, Date endTiming, List<Seat> seats, CinemaHall cinemaHallPlayedAt) {
        this.showId = showId;
        this.movie = movie;
        this.startTiming = startTiming;
        this.endTiming = endTiming;
        this.seats = seats;
        this.cinemaHallPlayedAt = cinemaHallPlayedAt;
    }

    public Integer getShowId() {
        return showId;
    }

    public void setShowId(Integer showId) {
        this.showId = showId;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Date getStartTiming() {
        return startTiming;
    }

    public void setStartTiming(Date startTiming) {
        this.startTiming = startTiming;
    }

    public Date getEndTiming() {
        return endTiming;
    }

    public void setEndTiming(Date endTiming) {
        this.endTiming = endTiming;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public CinemaHall getCinemaHallPlayedAt() {
        return cinemaHallPlayedAt;
    }

    public void setCinemaHallPlayedAt(CinemaHall cinemaHallPlayedAt) {
        this.cinemaHallPlayedAt = cinemaHallPlayedAt;
    }

    @Override
    public String toString() {
        return "Show{" +
                "showId=" + showId +
                ", movie=" + movie +
                ", startTiming=" + startTiming +
                ", endTiming=" + endTiming +
                ", cinemaHallPlayedAt=" + cinemaHallPlayedAt +
                '}';
    }
}
