package BookMyShow.model;

import java.util.List;

public class CinemaHall {
    private Integer cinemaHallId;
    private String cinemaName;
    private String address; //populate city in this address
    private List<Audi> audis;
    public CinemaHall(Integer cinemaHallId, String cinemaName, String address, List<Audi> audis) {
        this.cinemaHallId = cinemaHallId;
        this.cinemaName = cinemaName;
        this.address = address;
        this.audis = audis;
    }
    public Integer getCinemaHallId() {
        return cinemaHallId;
    }

    public void setCinemaHallId(Integer cinemaHallId) {
        this.cinemaHallId = cinemaHallId;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Audi> getAudis() {
        return audis;
    }

    public void setAudis(List<Audi> audis) {
        this.audis = audis;
    }
}
