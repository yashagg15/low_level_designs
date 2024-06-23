package BookMyShow.service;

import BookMyShow.enums.BookingStatus;
import BookMyShow.enums.SeatStatus;
import BookMyShow.model.Booking;
import BookMyShow.model.Seat;

import java.util.List;

public class PaymentService {

    public static PaymentFactory paymentFactory;

    public PaymentService() {
        paymentFactory = new PaymentFactory();
    }

    public Booking makePayment(String paymentType, Booking booking) {

        Payment payment = paymentFactory.getPaymentStrategy(paymentType);
        booking.setPayment(payment);
        String tId = payment.processBookingAmount(booking.getTotalBookingAmount());
        if (!tId.isEmpty()) {
            booking.setBookingStatus(BookingStatus.BOOKED);
            changeSeatStatus(booking.getBookedSeats());
        }
        return booking;
    }

    public void changeSeatStatus(List<Seat> bookedSeats) {
        bookedSeats.stream().forEach(seat -> seat.setSeatStatus(SeatStatus.BOOKED));
    }
}
