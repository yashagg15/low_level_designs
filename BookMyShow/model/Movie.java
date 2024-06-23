package BookMyShow.model;

import BookMyShow.enums.Genre;

import java.util.Date;
import java.util.List;

public class Movie {

    private Integer movieId;
    private String movieTitle;
    private Genre genre;
    private Integer durationInMins;
    private Date relaseDate;
    private List<String> languageSupported;

    public CinemaHall getCinemaHallPlayedAt() {
        return cinemaHallPlayedAt;
    }

    public void setCinemaHallPlayedAt(CinemaHall cinemaHallPlayedAt) {
        this.cinemaHallPlayedAt = cinemaHallPlayedAt;
    }

    private CinemaHall cinemaHallPlayedAt;

    public Movie(Integer movieId, String movieTitle, Genre genre, Integer durationInMins, Date relaseDate, List<String> languageSupported,
                 CinemaHall cinemaHallPlayedAt) {
        this.movieId = movieId;
        this.movieTitle = movieTitle;
        this.genre = genre;
        this.durationInMins = durationInMins;
        this.relaseDate = relaseDate;
        this.languageSupported = languageSupported;
        this.cinemaHallPlayedAt = cinemaHallPlayedAt;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Integer getDurationInMins() {
        return durationInMins;
    }

    public void setDurationInMins(Integer durationInMins) {
        this.durationInMins = durationInMins;
    }

    public Date getRelaseDate() {
        return relaseDate;
    }

    public void setRelaseDate(Date relaseDate) {
        this.relaseDate = relaseDate;
    }

    public List<String> getLanguageSupported() {
        return languageSupported;
    }

    public void setLanguageSupported(List<String> languageSupported) {
        this.languageSupported = languageSupported;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", movieTitle='" + movieTitle + '\'' +
                ", genre=" + genre +
                ", durationInMins=" + durationInMins +
                ", relaseDate=" + relaseDate +
                ", languageSupported=" + languageSupported +
                ", cinemaHallPlayedAt=" + cinemaHallPlayedAt +
                '}';
    }
}
