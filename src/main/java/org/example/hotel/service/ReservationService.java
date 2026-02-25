package org.example.hotel.service;



import org.example.hotel.dao.GuestDAO;
import org.example.hotel.dao.ReservationDAO;
import org.example.hotel.dao.RoomDAO;
import org.example.hotel.model.Guest;
import org.example.hotel.model.Reservation;
import org.example.hotel.util.DBConnection;

import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

public class ReservationService {

    private GuestDAO guestDAO = new GuestDAO();
    private ReservationDAO reservationDAO = new ReservationDAO();
    private RoomDAO roomDAO = new RoomDAO();

    public boolean createReservation(Guest guest,
                                     int roomId,
                                     LocalDate checkIn,
                                     LocalDate checkOut,
                                     double pricePerNight) {

        try (Connection con = DBConnection.getConnection()) {

            con.setAutoCommit(false); // START TRANSACTION

            // 1️⃣ CHECK DATE CONFLICT
            boolean conflict = reservationDAO.isRoomBooked(
                    con,
                    roomId,
                    Date.valueOf(checkIn),
                    Date.valueOf(checkOut)
            );

            if (conflict) {
                System.out.println("Room already booked for selected dates!");
                return false; // STOP BOOKING
            }

            // 1️⃣ Save Guest
            int guestId = guestDAO.saveGuest(con, guest);
            if (guestId == -1) throw new Exception("Guest Save Failed");

            // 2️⃣ Calculate Bill
            long nights = ChronoUnit.DAYS.between(checkIn, checkOut);
            double total = nights * pricePerNight;

            // 3️⃣ Generate Reservation Number
            String reservationNumber = "RES-" + UUID.randomUUID().toString().substring(0,8);

            // 4️⃣ Save Reservation
            Reservation reservation = new Reservation();
            reservation.setReservationNumber(reservationNumber);
            reservation.setGuestId(guestId);
            reservation.setRoomId(roomId);
            reservation.setCheckIn(checkIn);
            reservation.setCheckOut(checkOut);
            reservation.setTotalAmount(total);

            boolean reservationSaved = reservationDAO.saveReservation(con, reservation);
            if (!reservationSaved) throw new Exception("Reservation Save Failed");

            // 5️⃣ Update Room Status
            boolean roomUpdated = roomDAO.updateRoomStatus(con, roomId, "OCCUPIED");
            if (!roomUpdated) throw new Exception("Room Update Failed");

            con.commit(); // SUCCESS
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}