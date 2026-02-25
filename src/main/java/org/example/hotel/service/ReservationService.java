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
                                     String roomType,
                                     LocalDate checkIn,
                                     LocalDate checkOut,
                                     double pricePerNight) {

        try (Connection con = DBConnection.getConnection()) {
            con.setAutoCommit(false);

            // 1️⃣ Check availability
            int available = roomDAO.getAvailableRoomsByType(
                    con,
                    roomType,
                    java.sql.Date.valueOf(checkIn),
                    java.sql.Date.valueOf(checkOut)
            );


            if (available <= 0) {
                System.out.println("No rooms available for selected type and dates!");
                return false;
            }

            // 2️⃣ Save Guest
            int guestId = guestDAO.saveGuest(con, guest);
            if (guestId == -1) throw new Exception("Guest Save Failed");

            // 3️⃣ Assign a room_id (pick first available room)
            int roomId = roomDAO.getFirstAvailableRoomId(con, roomType, checkIn, checkOut);

            // 4️⃣ Calculate Bill
            long nights = ChronoUnit.DAYS.between(checkIn, checkOut);
            double total = nights * pricePerNight;

            // 5️⃣ Save Reservation
            Reservation reservation = new Reservation();
            reservation.setReservationNumber("RES-" + UUID.randomUUID().toString().substring(0,8));
            reservation.setGuestId(guestId);
            reservation.setRoomId(roomId);
            reservation.setCheckIn(checkIn);
            reservation.setCheckOut(checkOut);
            reservation.setTotalAmount(total);

            boolean reservationSaved = reservationDAO.saveReservation(con, reservation);
            if (!reservationSaved) throw new Exception("Reservation Save Failed");


            // 6️⃣ Update Room Status if all rooms are booked
            int remaining = roomDAO.getAvailableRoomsByType(
                    con,
                    roomType,
                    java.sql.Date.valueOf(checkIn),
                    java.sql.Date.valueOf(checkOut)
            );
            if (remaining == 0) roomDAO.updateRoomStatus(con, roomId, "FULL");

            con.commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean checkIn(int reservationId, int roomId) {
        try (Connection con = DBConnection.getConnection()) {
            con.setAutoCommit(false);

            boolean resStatus = reservationDAO.updateReservationStatus(con, reservationId, "CHECKED_IN");
            boolean roomStatus = roomDAO.checkInRoom(con, roomId);

            if (!resStatus || !roomStatus) throw new Exception("Check-In Failed");

            con.commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean checkOut(int reservationId, int roomId) {
        try (Connection con = DBConnection.getConnection()) {
            con.setAutoCommit(false);

            boolean resStatus = reservationDAO.updateReservationStatus(con, reservationId, "CHECKED_OUT");
            boolean roomStatus = roomDAO.checkOutRoom(con, roomId);

            if (!resStatus || !roomStatus) throw new Exception("Check-Out Failed");

            con.commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


}