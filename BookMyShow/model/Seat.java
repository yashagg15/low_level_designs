package BookMyShow.model;

import BookMyShow.enums.SeatStatus;
import BookMyShow.enums.SeatType;

public class Seat {

    private String seatId;
    private SeatType seatType;
    private SeatStatus seatStatus;
    private Double seatPrice;

    public String getSeatId() {
        return seatId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    public SeatStatus getSeatStatus() {
        return seatStatus;
    }

    public void setSeatStatus(SeatStatus seatStatus) {
        this.seatStatus = seatStatus;
    }

    public Double getSeatPrice() {
        return seatPrice;
    }

    public void setSeatPrice(Double seatPrice) {
        this.seatPrice = seatPrice;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "seatId='" + seatId + '\'' +
                ", seatType=" + seatType +
                ", seatStatus=" + seatStatus +
                ", seatPrice=" + seatPrice +
                '}';
    }
}
