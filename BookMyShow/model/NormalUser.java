package BookMyShow.model;

import BookMyShow.service.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NormalUser extends BaseUser{

    Map<Integer,List<Booking>> userVsBooking;

    public BookingService bookingService;

    public PaymentService paymentService;

    public NormalUser(Integer userId, String firstName, String lastName, AccountDetails accountDetails, SearchService searchService) {
        super(userId, firstName, lastName, accountDetails, searchService);
        userVsBooking = new HashMap<>();
        bookingService = new BookingService();
        paymentService = new PaymentService();
    }

    public Booking makeBooking(Double totalBookingAmount, List<Seat> bookedSeats, List<NormalUser> normalUsers, Show show, Audi audi){
        return bookingService.makeBooking(this.getUserId(),totalBookingAmount, bookedSeats, normalUsers, show, audi);
    }

    public Booking makePayment(Integer bookingId, String paymentType){
        Booking booking = bookingService.getBooking(bookingId);
        Booking finalBooking = paymentService.makePayment(paymentType,booking);
        System.out.println(finalBooking.toString());
        return finalBooking;
    }


    public Map<Integer, List<Booking>> getUserVsBooking() {
        return userVsBooking;
    }

    public void setUserVsBooking(Map<Integer, List<Booking>> userVsBooking) {
        this.userVsBooking = userVsBooking;
    }

    public BookingService getBookingService() {
        return bookingService;
    }

    public void setBookingService(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public PaymentService getPaymentService() {
        return paymentService;
    }

    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
}
