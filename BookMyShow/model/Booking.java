package BookMyShow.model;

import BookMyShow.enums.BookingStatus;
import BookMyShow.service.Payment;

import java.util.Date;
import java.util.List;

public class Booking {
    private Integer bookingId;
    private Date bookingDate;
    private Double totalBookingAmount;
    private List<Seat> bookedSeats;
    private List<NormalUser> normalUsers;
    private Show show;
    private Payment payment;
    private BookingStatus bookingStatus;
    private Audi audi;
    public Booking(Integer bookingId, Date bookingDate, Double totalBookingAmount, List<Seat> bookedSeats, List<NormalUser> normalUsers, Show show, Payment payment, BookingStatus bookingStatus, Audi audi) {
        this.bookingId = bookingId;
        this.bookingDate = bookingDate;
        this.totalBookingAmount = totalBookingAmount;
        this.bookedSeats = bookedSeats;
        this.normalUsers = normalUsers;
        this.show = show;
        this.payment = payment;
        this.bookingStatus = bookingStatus;
        this.audi = audi;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Double getTotalBookingAmount() {
        return totalBookingAmount;
    }

    public void setTotalBookingAmount(Double totalBookingAmount) {
        this.totalBookingAmount = totalBookingAmount;
    }

    public List<Seat> getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(List<Seat> bookedSeats) {
        this.bookedSeats = bookedSeats;
    }

    public List<NormalUser> getNormalUsers() {
        return normalUsers;
    }

    public void setNormalUsers(List<NormalUser> normalUsers) {
        this.normalUsers = normalUsers;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public Audi getAudi() {
        return audi;
    }

    public void setAudi(Audi audi) {
        this.audi = audi;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", bookingDate=" + bookingDate +
                ", totalBookingAmount=" + totalBookingAmount +
                ", bookedSeats=" + bookedSeats +
                ", normalUsers=" + normalUsers +
                ", show=" + show +
                ", payment=" + payment +
                ", bookingStatus=" + bookingStatus +
                ", audi=" + audi +
                '}';
    }
}
