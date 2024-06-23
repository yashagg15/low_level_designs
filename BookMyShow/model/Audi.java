package BookMyShow.model;

import java.util.List;

public class Audi {
    private Integer audiId;
    private String audiName;
    private int totalSeats;
    private List<Show> shows;

    public Audi(Integer audiId, String audiName, int totalSeats, List<Show> shows) {
        this.audiId = audiId;
        this.audiName = audiName;
        this.totalSeats = totalSeats;
        this.shows = shows;
    }

    public Integer getAudiId() {
        return audiId;
    }

    public void setAudiId(Integer audiId) {
        this.audiId = audiId;
    }

    public String getAudiName() {
        return audiName;
    }

    public void setAudiName(String audiName) {
        this.audiName = audiName;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public List<Show> getShows() {
        return shows;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }
}
