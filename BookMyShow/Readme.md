----BOOK MY SHOW----

#Requirements
1. List all the cities where cinemas are located.
2. Cinemas can have multiple audis, and each audi can run one movie show at a time.
3. Each movie will have multiple shows.
4. Users can search by their movie title, language, genre, release date, city name.
5. User can select a movie and the service should display cinemas running that movie and its available shows.
6. User can select the show and book multiple seats and tickets.
7. User can do the payment with Debit, Credit card and UPI also.

# Demonstrating by creating two booking back to back. Code is in working state. Some bugs can be identified.
# Please feel free to commit and improve the code quality and add more functionality.
# We haven't focused on movie and show dates and timings. All have input on today's date.

# Running demonstration of the code

Listing all the cities
[Mumbai, Delhi, Noida, Bengaluru, Pune, Hyderabad]
Please select the city
Noida
City selected: Noida
Listing all the movies
RRR
Interstellar
Listing all the cinemas
OPC
Please enter the movie name
RRR
Movie details Movie{movieId=12, movieTitle='RRR', genre=COMEDY, durationInMins=120, relaseDate=Mon Jun 10 23:46:28 IST 2024, languageSupported=[Hindi, English], cinemaHallPlayedAt=BookMyShow.model.CinemaHall@1e127982}
All shows details
Show{showId=3000, movie=Movie{movieId=12, movieTitle='RRR', genre=COMEDY, durationInMins=120, relaseDate=Mon Jun 10 23:46:28 IST 2024, languageSupported=[Hindi, English], cinemaHallPlayedAt=BookMyShow.model.CinemaHall@1e127982}, startTiming=Mon Jun 10 23:46:28 IST 2024, endTiming=Mon Jun 10 23:46:28 IST 2024, cinemaHallPlayedAt=BookMyShow.model.CinemaHall@1e127982}
Show{showId=4000, movie=Movie{movieId=12, movieTitle='RRR', genre=COMEDY, durationInMins=120, relaseDate=Mon Jun 10 23:46:28 IST 2024, languageSupported=[Hindi, English], cinemaHallPlayedAt=BookMyShow.model.CinemaHall@1e127982}, startTiming=Mon Jun 10 23:46:28 IST 2024, endTiming=Mon Jun 10 23:46:28 IST 2024, cinemaHallPlayedAt=BookMyShow.model.CinemaHall@1e127982}
Please select the show
3000
Please select amongst the available seats
Seat details Seat{seatId='G1', seatType=CLASSIC, seatStatus=UNBOOKED, seatPrice=1000.0}
Seat details Seat{seatId='G2', seatType=GOLD, seatStatus=UNBOOKED, seatPrice=2000.0}
Seat details Seat{seatId='G3', seatType=SILVER, seatStatus=UNBOOKED, seatPrice=1500.0}
Seat details Seat{seatId='G4', seatType=VIP, seatStatus=UNBOOKED, seatPrice=5000.0}
Please fill the seats by separating with semi collons
0:1
Making a booking
Booking added
Booking details final Booking{bookingId=1, bookingDate=Mon Jun 10 23:46:38 IST 2024, totalBookingAmount=3000.0, bookedSeats=[Seat{seatId='G1', seatType=CLASSIC, seatStatus=LOCKED, seatPrice=1000.0}, Seat{seatId='G2', seatType=GOLD, seatStatus=LOCKED, seatPrice=2000.0}], normalUsers=[BookMyShow.model.NormalUser@467aecef], show=Show{showId=3000, movie=Movie{movieId=12, movieTitle='RRR', genre=COMEDY, durationInMins=120, relaseDate=Mon Jun 10 23:46:28 IST 2024, languageSupported=[Hindi, English], cinemaHallPlayedAt=BookMyShow.model.CinemaHall@1e127982}, startTiming=Mon Jun 10 23:46:28 IST 2024, endTiming=Mon Jun 10 23:46:28 IST 2024, cinemaHallPlayedAt=BookMyShow.model.CinemaHall@1e127982}, payment=null, bookingStatus=PROCESSING, audi=BookMyShow.model.Audi@4d50efb8}
UPI of amount 3000.0 is completed
Booking{bookingId=1, bookingDate=Mon Jun 10 23:46:38 IST 2024, totalBookingAmount=3000.0, bookedSeats=[Seat{seatId='G1', seatType=CLASSIC, seatStatus=BOOKED, seatPrice=1000.0}, Seat{seatId='G2', seatType=GOLD, seatStatus=BOOKED, seatPrice=2000.0}], normalUsers=[BookMyShow.model.NormalUser@467aecef], show=Show{showId=3000, movie=Movie{movieId=12, movieTitle='RRR', genre=COMEDY, durationInMins=120, relaseDate=Mon Jun 10 23:46:28 IST 2024, languageSupported=[Hindi, English], cinemaHallPlayedAt=BookMyShow.model.CinemaHall@1e127982}, startTiming=Mon Jun 10 23:46:28 IST 2024, endTiming=Mon Jun 10 23:46:28 IST 2024, cinemaHallPlayedAt=BookMyShow.model.CinemaHall@1e127982}, payment=Payment{transactionId='TUPI1'}, bookingStatus=BOOKED, audi=BookMyShow.model.Audi@4d50efb8}
Booking{bookingId=1, bookingDate=Mon Jun 10 23:46:38 IST 2024, totalBookingAmount=3000.0, bookedSeats=[Seat{seatId='G1', seatType=CLASSIC, seatStatus=BOOKED, seatPrice=1000.0}, Seat{seatId='G2', seatType=GOLD, seatStatus=BOOKED, seatPrice=2000.0}], normalUsers=[BookMyShow.model.NormalUser@467aecef], show=Show{showId=3000, movie=Movie{movieId=12, movieTitle='RRR', genre=COMEDY, durationInMins=120, relaseDate=Mon Jun 10 23:46:28 IST 2024, languageSupported=[Hindi, English], cinemaHallPlayedAt=BookMyShow.model.CinemaHall@1e127982}, startTiming=Mon Jun 10 23:46:28 IST 2024, endTiming=Mon Jun 10 23:46:28 IST 2024, cinemaHallPlayedAt=BookMyShow.model.CinemaHall@1e127982}, payment=Payment{transactionId='TUPI1'}, bookingStatus=BOOKED, audi=BookMyShow.model.Audi@4d50efb8}
Listing all the cities
[Mumbai, Delhi, Noida, Bengaluru, Pune, Hyderabad]
Please select the city
Noida
City selected: Noida
Listing all the movies
RRR
Interstellar
Listing all the cinemas
OPC
Please enter the movie name
RRR
Movie details Movie{movieId=12, movieTitle='RRR', genre=COMEDY, durationInMins=120, relaseDate=Mon Jun 10 23:46:28 IST 2024, languageSupported=[Hindi, English], cinemaHallPlayedAt=BookMyShow.model.CinemaHall@1e127982}
All shows details
Show{showId=3000, movie=Movie{movieId=12, movieTitle='RRR', genre=COMEDY, durationInMins=120, relaseDate=Mon Jun 10 23:46:28 IST 2024, languageSupported=[Hindi, English], cinemaHallPlayedAt=BookMyShow.model.CinemaHall@1e127982}, startTiming=Mon Jun 10 23:46:28 IST 2024, endTiming=Mon Jun 10 23:46:28 IST 2024, cinemaHallPlayedAt=BookMyShow.model.CinemaHall@1e127982}
Show{showId=4000, movie=Movie{movieId=12, movieTitle='RRR', genre=COMEDY, durationInMins=120, relaseDate=Mon Jun 10 23:46:28 IST 2024, languageSupported=[Hindi, English], cinemaHallPlayedAt=BookMyShow.model.CinemaHall@1e127982}, startTiming=Mon Jun 10 23:46:28 IST 2024, endTiming=Mon Jun 10 23:46:28 IST 2024, cinemaHallPlayedAt=BookMyShow.model.CinemaHall@1e127982}
Please select the show
3000
Please select amongst the available seats
Seat details Seat{seatId='G1', seatType=CLASSIC, seatStatus=BOOKED, seatPrice=1000.0}
Seat details Seat{seatId='G2', seatType=GOLD, seatStatus=BOOKED, seatPrice=2000.0}
Seat details Seat{seatId='G3', seatType=SILVER, seatStatus=UNBOOKED, seatPrice=1500.0}
Seat details Seat{seatId='G4', seatType=VIP, seatStatus=UNBOOKED, seatPrice=5000.0}
Please fill the seats by separating with semi collons
2:3
Making a booking
Booking added
Booking details final Booking{bookingId=2, bookingDate=Mon Jun 10 23:46:57 IST 2024, totalBookingAmount=6500.0, bookedSeats=[Seat{seatId='G3', seatType=SILVER, seatStatus=LOCKED, seatPrice=1500.0}, Seat{seatId='G4', seatType=VIP, seatStatus=LOCKED, seatPrice=5000.0}], normalUsers=[BookMyShow.model.NormalUser@467aecef], show=Show{showId=3000, movie=Movie{movieId=12, movieTitle='RRR', genre=COMEDY, durationInMins=120, relaseDate=Mon Jun 10 23:46:28 IST 2024, languageSupported=[Hindi, English], cinemaHallPlayedAt=BookMyShow.model.CinemaHall@1e127982}, startTiming=Mon Jun 10 23:46:28 IST 2024, endTiming=Mon Jun 10 23:46:28 IST 2024, cinemaHallPlayedAt=BookMyShow.model.CinemaHall@1e127982}, payment=null, bookingStatus=PROCESSING, audi=BookMyShow.model.Audi@3234e239}
UPI of amount 6500.0 is completed
Booking{bookingId=2, bookingDate=Mon Jun 10 23:46:57 IST 2024, totalBookingAmount=6500.0, bookedSeats=[Seat{seatId='G3', seatType=SILVER, seatStatus=BOOKED, seatPrice=1500.0}, Seat{seatId='G4', seatType=VIP, seatStatus=BOOKED, seatPrice=5000.0}], normalUsers=[BookMyShow.model.NormalUser@467aecef], show=Show{showId=3000, movie=Movie{movieId=12, movieTitle='RRR', genre=COMEDY, durationInMins=120, relaseDate=Mon Jun 10 23:46:28 IST 2024, languageSupported=[Hindi, English], cinemaHallPlayedAt=BookMyShow.model.CinemaHall@1e127982}, startTiming=Mon Jun 10 23:46:28 IST 2024, endTiming=Mon Jun 10 23:46:28 IST 2024, cinemaHallPlayedAt=BookMyShow.model.CinemaHall@1e127982}, payment=Payment{transactionId='TUPI1'}, bookingStatus=BOOKED, audi=BookMyShow.model.Audi@3234e239}
Booking{bookingId=2, bookingDate=Mon Jun 10 23:46:57 IST 2024, totalBookingAmount=6500.0, bookedSeats=[Seat{seatId='G3', seatType=SILVER, seatStatus=BOOKED, seatPrice=1500.0}, Seat{seatId='G4', seatType=VIP, seatStatus=BOOKED, seatPrice=5000.0}], normalUsers=[BookMyShow.model.NormalUser@467aecef], show=Show{showId=3000, movie=Movie{movieId=12, movieTitle='RRR', genre=COMEDY, durationInMins=120, relaseDate=Mon Jun 10 23:46:28 IST 2024, languageSupported=[Hindi, English], cinemaHallPlayedAt=BookMyShow.model.CinemaHall@1e127982}, startTiming=Mon Jun 10 23:46:28 IST 2024, endTiming=Mon Jun 10 23:46:28 IST 2024, cinemaHallPlayedAt=BookMyShow.model.CinemaHall@1e127982}, payment=Payment{transactionId='TUPI1'}, bookingStatus=BOOKED, audi=BookMyShow.model.Audi@3234e239}

Process finished with exit code 0



#Some good reads on concurrent booking of the seats
1. https://codeminion.hashnode.dev/how-does-bookmyshow-handle-concurrent-bookings
2. Read about the different database transaction isolation level (READ_UNCOMMITTED, READ_COMMITTED,READ_REPETABLE,READ_SERIALIZABLE)
3. Read about the Pessimistic vs Optimistic Locking Mechanism.


