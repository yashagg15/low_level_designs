package BookMyShow.service;

import BookMyShow.enums.BookingStatus;
import BookMyShow.enums.SeatStatus;
import BookMyShow.model.*;

import java.util.*;

public class BookingService {

    Map<Integer, List<Booking>> userVsBooking;
    Map<Integer, Booking> bookingIdVsBooking;

    public BookingService() {
        userVsBooking = new HashMap<>();
        bookingIdVsBooking = new HashMap<>();
    }

    static int bookingId = 0;

    public Booking makeBooking(Integer userId, Double totalBookingAmount, List<Seat> bookedSeats, List<NormalUser> normalUsers, Show show, Audi audi) {
        Date todayDate = new Date();
        bookingId += 1;
        Booking booking = new Booking(bookingId,
                todayDate, totalBookingAmount, bookedSeats, normalUsers, show, null, BookingStatus.PROCESSING, audi);

        if (!userVsBooking.containsKey(userId)) {
            userVsBooking.put(userId, new ArrayList<>());
        }
        List<Seat> nonSeatAvailability = checkSeatAvailability(bookedSeats);
        if (nonSeatAvailability.size() == 0) {
            userVsBooking.get(userId).add(booking);
            bookingIdVsBooking.put(bookingId, booking);
            System.out.println("Booking added");
        } else {
            System.out.println("These seats are filled, Please choose different seats");
            nonSeatAvailability.stream().forEach(seat -> System.out.println(seat.getSeatId()));
        }
        return booking;
    }

    public Booking getBooking(Integer bookingId) {
        return bookingIdVsBooking.get(bookingId);
    }

    public synchronized List<Seat> checkSeatAvailability(List<Seat> bookedSeats) {

        List<Seat> notAvailableSeats = new ArrayList<>();


        for (Seat bookedSeat : bookedSeats) {
            SeatStatus currentStatus = bookedSeat.getSeatStatus();
            if (currentStatus == SeatStatus.UNBOOKED) {
                bookedSeat.setSeatStatus(SeatStatus.LOCKED);
            } else {
                notAvailableSeats.add(bookedSeat);
            }
        }
        return notAvailableSeats;
    }
}
