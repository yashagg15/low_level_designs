package BookMyShow;

import BookMyShow.enums.Genre;
import BookMyShow.enums.SeatStatus;
import BookMyShow.enums.SeatType;
import BookMyShow.model.*;
import BookMyShow.service.BmsService;
import BookMyShow.service.SearchService;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class BmsDriver {

    public static CinemaHall getCinemaHall() {
        List<Audi> audiList = getAudiList();
        CinemaHall cinemaHall = new CinemaHall(100, "OPC", "Noida", audiList);

        cinemaHall.getAudis().stream().forEach(audi -> {
            audi.getShows().stream().forEach(show -> {
                show.setCinemaHallPlayedAt(cinemaHall);
                show.getMovie().setCinemaHallPlayedAt(cinemaHall);
            });
        });
        return cinemaHall;
    }

    public static List<Audi> getAudiList() {
        List<Audi> audiList = new ArrayList<>();
        Audi audi = new Audi(23, "Mex", 4, getShows());
        Audi audi2 = new Audi(53, "SET", 4, getMoreShows());
        audiList.add(audi);
        audiList.add(audi2);
        return audiList;
    }


    public static List<Show> getShows() {
        List<Show> shows = new ArrayList<>();
        List<Seat> seats = getSeats();
        Movie movie = getAMovie();
        Show show1 = new Show(3000, movie, new Date(), new Date(), seats, null);
        Show show2 = new Show(4000, movie, new Date(), new Date(), seats, null);
        shows.add(show2);
        shows.add(show1);
        return shows;
    }

    public static List<Show> getMoreShows() {
        List<Show> shows = new ArrayList<>();
        List<Seat> seats = getMoreSeats();
        Movie movie = getAnotherMovie();
        Show show1 = new Show(5000, movie, new Date(), new Date(), seats, null);
        Show show2 = new Show(9000, movie, new Date(), new Date(), seats, null);
        shows.add(show2);
        shows.add(show1);
        return shows;
    }

    public static Movie getAMovie() {
        List<String> lan = new ArrayList<>();
        lan.add("Hindi");
        lan.add("English");
        Movie movie = new Movie(12, "RRR", Genre.COMEDY, 120, new Date(), lan, null);
        return movie;
    }

    public static Movie getAnotherMovie() {
        List<String> lan = new ArrayList<>();
        lan.add("English");
        Movie movie = new Movie(12, "Interstellar", Genre.SCI_FI, 100, new Date(), lan, null);
        return movie;
    }


    public static List<Seat> getSeats() {

        Seat seat1 = new Seat();
        seat1.setSeatId("G1");
        seat1.setSeatStatus(SeatStatus.UNBOOKED);
        seat1.setSeatPrice(1000.0);
        seat1.setSeatType(SeatType.CLASSIC);

        Seat seat2 = new Seat();
        seat2.setSeatId("G2");
        seat2.setSeatStatus(SeatStatus.UNBOOKED);
        seat2.setSeatPrice(2000.0);
        seat2.setSeatType(SeatType.GOLD);

        Seat seat3 = new Seat();
        seat3.setSeatId("G3");
        seat3.setSeatStatus(SeatStatus.UNBOOKED);
        seat3.setSeatPrice(1500.0);
        seat3.setSeatType(SeatType.SILVER);

        Seat seat4 = new Seat();
        seat4.setSeatId("G4");
        seat4.setSeatStatus(SeatStatus.UNBOOKED);
        seat4.setSeatPrice(5000.0);
        seat4.setSeatType(SeatType.VIP);

        List<Seat> seats = new ArrayList<>();
        seats.addAll(Arrays.asList(seat1, seat2, seat3, seat4));
        return seats;
    }

    public static List<Seat> getMoreSeats() {

        Seat seat1 = new Seat();
        seat1.setSeatId("A1");
        seat1.setSeatStatus(SeatStatus.UNBOOKED);
        seat1.setSeatPrice(1000.0);
        seat1.setSeatType(SeatType.CLASSIC);

        Seat seat2 = new Seat();
        seat2.setSeatId("A2");
        seat2.setSeatStatus(SeatStatus.UNBOOKED);
        seat2.setSeatPrice(2000.0);
        seat2.setSeatType(SeatType.GOLD);

        Seat seat3 = new Seat();
        seat3.setSeatId("A3");
        seat3.setSeatStatus(SeatStatus.UNBOOKED);
        seat3.setSeatPrice(1500.0);
        seat3.setSeatType(SeatType.SILVER);


        List<Seat> seats = new ArrayList<>();
        seats.addAll(Arrays.asList(seat1, seat2, seat3));
        return seats;
    }

    public static void main(String[] args) {

        // Creating the admin user account.
        AccountDetails accountDetails = new AccountDetails("joe", "joe_password");
        AdminUser adminUser = new AdminUser(1, "Joe", "Ada", accountDetails, new SearchService());

        // Creating the cinema hall
        CinemaHall cinemaHall = getCinemaHall();

        // Admin user adding the cinema hall in the city, and also adding movie shows in the Theatre.
        adminUser.addTheatre(cinemaHall, "Noida");
        adminUser.addMovieShowsInTheatre(cinemaHall.getAudis().get(0).getShows(), cinemaHall.getCinemaHallId());
        adminUser.addMovieShowsInTheatre(cinemaHall.getAudis().get(1).getShows(), cinemaHall.getCinemaHallId());

        // Creating a normal user account
        AccountDetails accountDetailsNormalUser = new AccountDetails("yash", "yash_password");
        NormalUser normalUser = new NormalUser(2, "yash", "agarwal", accountDetailsNormalUser,
                new SearchService());

        // Getting a search object
        SearchService searchService = normalUser.getSearchService();

        // Creating an instance of Book myt show Service
        BmsService bmsService = new BmsService();

        // Doing booking twice
        for (int bookingCount = 0; bookingCount<2;bookingCount++) {
            // Initially user gets all the cities to choose from
            System.out.println("Listing all the cities");
            System.out.println(searchService.getAllCities().toString());
            Scanner sc = new Scanner(System.in);
            System.out.println("Please select the city");
            String city = sc.nextLine();
            System.out.println("City selected: " + city);

            // After selecting a city, It lists all movies and Theatres in the city
            System.out.println("Listing all the movies");
            bmsService.getAllMoviesByCity(city).stream().forEach(movie -> System.out.println(movie.getMovieTitle()));
            System.out.println("Listing all the cinemas");
            bmsService.getAllTheatresByCity(city).stream().forEach(cinemaHall1 -> System.out.println(cinemaHall1.getCinemaName()));

            // User selects a particular movie using search object
            System.out.println("Please enter the movie name");
            String movieName = sc.nextLine();

            Set<Movie> movies = searchService.searchMovieByName(movieName, city);
            Movie movie = movies.stream().findFirst().get();
            System.out.println("Movie details " + movie.toString());

            // User fetches all shows for a particular movie in the selected city
            Set<Show> fetchingShows = bmsService.getAllShowsByCityAndMovie(city, movieName);
            System.out.println("All shows details");
            fetchingShows.stream().forEach(show -> System.out.println(show.toString()));

            // here user selects a particular show object
            System.out.println("Please select the show");
            String showId = sc.nextLine();
            Show show = bmsService.getAShow(Integer.parseInt(showId));

            // After selecting a particular show, user gets the whole seating plan.(seats object list)
            List<Seat> seats = show.getSeats();
            System.out.println("Please select amongst the available seats");
            seats.stream().forEach(seat -> {
                System.out.println("Seat details " + seat.toString());
            });

            // User selects multiple seats from the available seats. Input will be like "0:1:2".
            // Input is separated by colon. We are giving index <  seats list size
            System.out.println("Please fill the seats by separating with semi collons");
            String seatsBooking = sc.nextLine();
            String[] seatsArrays = seatsBooking.split(":");
            List<Seat> bookedSeats = new ArrayList<>();
            for (String seatNo : seatsArrays) {
                Integer objNo = Integer.parseInt(seatNo);
                bookedSeats.add(seats.get(objNo));
            }

            // User make a booking after selecting the seats.
            System.out.println("Making a booking");
            AtomicReference<Double> totalAmount = new AtomicReference<>(0.0);
            bookedSeats.stream().forEach(bookedSeat -> totalAmount.set(totalAmount.get() + bookedSeat.getSeatPrice()));
            List<NormalUser> nUsersList = new ArrayList<>();
            nUsersList.add(normalUser);
            Booking booking = normalUser.makeBooking(totalAmount.get(), bookedSeats, nUsersList, show, getAudiList().get(0));

            // User makes the payment and confirm the seats. (BOOKED status)
            System.out.println("Booking details final " + booking.toString());
            Booking booking1 = normalUser.makePayment(booking.getBookingId(), "UPI");
            System.out.println(booking1.toString());
        }

    }
}
