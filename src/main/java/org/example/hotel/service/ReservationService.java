//package org.example.hotel.service;
//
//
//
//import org.example.hotel.dao.GuestDAO;
//import org.example.hotel.dao.ReservationDAO;
//import org.example.hotel.dao.RoomDAO;
//import org.example.hotel.model.Guest;
//import org.example.hotel.model.Reservation;
//import org.example.hotel.util.DBConnection;
//
//import java.sql.Connection;
//import java.sql.Date;
//import java.time.LocalDate;
//import java.time.temporal.ChronoUnit;
//import java.util.UUID;
//
//public class ReservationService {
//
//    private GuestDAO guestDAO = new GuestDAO();
//    private ReservationDAO reservationDAO = new ReservationDAO();
//    private RoomDAO roomDAO = new RoomDAO();

//    public boolean createReservation(Guest guest,
//                                     String roomType,
//                                     LocalDate checkIn,
//                                     LocalDate checkOut,
//                                     double pricePerNight) {
//
//        try (Connection con = DBConnection.getConnection()) {
//            con.setAutoCommit(false);
//
//            // 1️⃣ Check availability
//            int available = roomDAO.getAvailableRoomsByType(
//                    con,
//                    roomType,
//                    java.sql.Date.valueOf(checkIn),
//                    java.sql.Date.valueOf(checkOut)
//            );
//
//
//            if (available <= 0) {
//                System.out.println("No rooms available for selected type and dates!");
//                return false;
//            }
//
//            // 2️⃣ Save Guest
//            int guestId = guestDAO.saveGuest(con, guest);
//            if (guestId == -1) throw new Exception("Guest Save Failed");
//
//            // 3️⃣ Assign a room_id (pick first available room)
//            int roomId = roomDAO.getFirstAvailableRoomId(con, roomType, checkIn, checkOut);
//
//            // 4️⃣ Calculate Bill
//            long nights = ChronoUnit.DAYS.between(checkIn, checkOut);
//            double total = nights * pricePerNight;
//
//            // 5️⃣ Save Reservation
//            Reservation reservation = new Reservation();
//            reservation.setReservationNumber("RES-" + UUID.randomUUID().toString().substring(0,8));
//            reservation.setGuestId(guestId);
//            reservation.setRoomId(roomId);
//            reservation.setCheckIn(checkIn);
//            reservation.setCheckOut(checkOut);
//            reservation.setTotalAmount(total);
//
//            boolean reservationSaved = reservationDAO.saveReservation(con, reservation);
//            if (!reservationSaved) throw new Exception("Reservation Save Failed");
//
//
//            // 6️⃣ Update Room Status if all rooms are booked
//            int remaining = roomDAO.getAvailableRoomsByType(
//                    con,
//                    roomType,
//                    java.sql.Date.valueOf(checkIn),
//                    java.sql.Date.valueOf(checkOut)
//            );
//            if (remaining == 0) roomDAO.updateRoomStatus(con, roomId, "FULL");
//
//            con.commit();
//            return true;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    public boolean checkIn(int reservationId, int roomId) {
//        try (Connection con = DBConnection.getConnection()) {
//            con.setAutoCommit(false);
//
//            boolean resStatus = reservationDAO.updateReservationStatus(con, reservationId, "CHECKED_IN");
//            boolean roomStatus = roomDAO.checkInRoom(con, roomId);
//
//            if (!resStatus || !roomStatus) throw new Exception("Check-In Failed");
//
//            con.commit();
//            return true;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    public boolean checkOut(int reservationId, int roomId) {
//        try (Connection con = DBConnection.getConnection()) {
//            con.setAutoCommit(false);
//
//            boolean resStatus = reservationDAO.updateReservationStatus(con, reservationId, "CHECKED_OUT");
//            boolean roomStatus = roomDAO.checkOutRoom(con, roomId);
//
//            if (!resStatus || !roomStatus) throw new Exception("Check-Out Failed");
//
//            con.commit();
//            return true;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }

















//    public boolean createReservation(Guest guest, String roomType, LocalDate checkIn, LocalDate checkOut, double pricePerNight) {
//        Reservation reservation = null; // Declare outside to use after commit
//
//        try (Connection con = DBConnection.getConnection()) {
//            con.setAutoCommit(false);
//
//            // 1️⃣ Check availability
//            int available = roomDAO.getAvailableRoomsByType(con, roomType, java.sql.Date.valueOf(checkIn), java.sql.Date.valueOf(checkOut));
//            if (available <= 0) return false;
//
//            // 2️⃣ Save Guest & Get ID
//            int guestId = guestDAO.saveGuest(con, guest);
//            if (guestId == -1) throw new Exception("Guest Save Failed");
//
//            // 3️⃣ Assign room & Calculate total
//            int roomId = roomDAO.getFirstAvailableRoomId(con, roomType, checkIn, checkOut);
//            long nights = ChronoUnit.DAYS.between(checkIn, checkOut);
//            double total = (nights == 0) ? pricePerNight : nights * pricePerNight;
//
//            // 4️⃣ Create Reservation Object
//            reservation = new Reservation();
//            reservation.setReservationNumber("RES-" + UUID.randomUUID().toString().substring(0, 8));
//            reservation.setGuestId(guestId);
//            reservation.setRoomId(roomId);
//            reservation.setCheckIn(checkIn);
//            reservation.setCheckOut(checkOut);
//            reservation.setTotalAmount(total);
//
//            // 5️⃣ Save to DB
//            boolean reservationSaved = reservationDAO.saveReservation(con, reservation);
//            if (!reservationSaved) throw new Exception("Reservation Save Failed");
//
//            con.commit(); // ✅ DATABASE SUCCESSFUL
//
//            // 6️⃣ EXTERNAL ACTIONS (PDF & Email)
//            handleNotification(guest, reservation);
//
//            return true;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    /**
//     * Helper method to handle PDF generation and Email sending
//     */
//    private void handleNotification(Guest guest, Reservation reservation) {
//        try {
//            // Generate PDF
//            String filePath = "invoices/invoice_" + reservation.getReservationNumber() + ".pdf";
//            org.example.hotel.util.PDFGenerator.generateInvoice(filePath, guest, reservation);
//
//            // Prepare Email
//            String subject = "Your Hotel Invoice - " + reservation.getReservationNumber();
//            String message = "Dear " + guest.getFullName() + ",\n\n" +
//                    "Thank you for booking with us. Your reservation is confirmed.\n" +
//                    "Please find attached your invoice.\n\n" +
//                    "Best regards,\nYour Hotel Team";
//
//            // Send Email
//            boolean emailSent = org.example.hotel.util.EmailSender.sendEmailWithAttachment(
//                    guest.getEmail(),
//                    subject,
//                    message,
//                    filePath
//            );
//
//            if (emailSent) {
//                System.out.println("Invoice emailed successfully to: " + guest.getEmail());
//            } else {
//                System.err.println("Failed to send invoice email.");
//            }
//        } catch (Exception e) {
//            System.err.println("Error during notification: " + e.getMessage());
//        }
//    }
//
//
//    public boolean checkIn(int reservationId, int roomId) {
//        try (Connection con = DBConnection.getConnection()) {
//            con.setAutoCommit(false);
//
//            boolean resStatus = reservationDAO.updateReservationStatus(
//                    con, reservationId, "CHECKED_IN");
//
//            boolean roomStatus = roomDAO.checkInRoom(con, roomId);
//
//            if (!resStatus || !roomStatus)
//                throw new Exception("Check-In Failed");
//
//            con.commit();
//            return true;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    public boolean checkOut(int reservationId, int roomId) {
//        try (Connection con = DBConnection.getConnection()) {
//            con.setAutoCommit(false);
//
//            boolean resStatus = reservationDAO.updateReservationStatus(
//                    con, reservationId, "CHECKED_OUT");
//
//            boolean roomStatus = roomDAO.checkOutRoom(con, roomId);
//
//            if (!resStatus || !roomStatus)
//                throw new Exception("Check-Out Failed");
//
//            con.commit();
//            return true;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//}






package org.example.hotel.service;

import org.example.hotel.dao.GuestDAO;
import org.example.hotel.dao.ReservationDAO;
import org.example.hotel.dao.RoomDAO;
import org.example.hotel.model.Guest;
import org.example.hotel.model.Reservation;
import org.example.hotel.model.Room;
import org.example.hotel.util.DBConnection;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

public class ReservationService {

    private GuestDAO guestDAO = new GuestDAO();
    private ReservationDAO reservationDAO = new ReservationDAO();
    private RoomDAO roomDAO = new RoomDAO();

    /**
     * Creates a reservation, saves guest details, and triggers PDF/Email notifications.
     */
//    public boolean createReservation(Guest guest, String roomType, LocalDate checkIn, LocalDate checkOut, double pricePerNight) {
//        Reservation reservation = null; // Declare outside to use after commit
//
//        try (Connection con = DBConnection.getConnection()) {
//            con.setAutoCommit(false);
//
//            // 1️⃣ Check availability
//            int available = roomDAO.getAvailableRoomsByType(con, roomType, java.sql.Date.valueOf(checkIn), java.sql.Date.valueOf(checkOut));
//            if (available <= 0) return false;
//
//            // 2️⃣ Save Guest & Get ID
//            int guestId = guestDAO.saveGuest(con, guest);
//            if (guestId == -1) throw new Exception("Guest Save Failed");
//
//            // 3️⃣ Assign room & Calculate total
////            int roomId = roomDAO.getFirstAvailableRoomId(con, roomType, checkIn, checkOut);
////            long nights = ChronoUnit.DAYS.between(checkIn, checkOut);
////            double total = (nights == 0) ? pricePerNight : nights * pricePerNight;
//
//            // Assign room & calculate total
//            Room room = roomDAO.getFirstAvailableRoom(roomType, checkIn, checkOut);
//            if (room == null) return false;
//
//            int roomId = room.getRoomId();
//            double total = ChronoUnit.DAYS.between(checkIn, checkOut) * room.getPricePerNight();
//
//            // 4️⃣ Create Reservation Object
//            reservation = new Reservation();
//            reservation.setReservationNumber("RES-" + UUID.randomUUID().toString().substring(0, 8));
//            reservation.setGuestId(guestId);
//            reservation.setRoomId(roomId);
//            reservation.setCheckIn(checkIn);
//            reservation.setCheckOut(checkOut);
//            reservation.setTotalAmount(total);
//
//            // 5️⃣ Save to DB
//            boolean reservationSaved = reservationDAO.saveReservation(con, reservation);
//            if (!reservationSaved) throw new Exception("Reservation Save Failed");
//
//            con.commit(); // ✅ DATABASE SUCCESSFUL
//
//            // 6️⃣ EXTERNAL ACTIONS (PDF & Email)
//            handleNotification(guest, reservation);
//
//            return true;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
public boolean createReservation(Guest guest, String roomType, LocalDate checkIn, LocalDate checkOut, double pricePerNight) {
    try (Connection con = DBConnection.getConnection()) {
        con.setAutoCommit(false);

        // 1. Find the first available room of this type
        Room room = roomDAO.getFirstAvailableRoom(roomType, checkIn, checkOut);
        if (room == null) return false;

        // 2. Save Guest
        int guestId = guestDAO.saveGuest(con, guest);
        if (guestId == -1) throw new Exception("Guest Save Failed");

        // 3. Calculate Total
        long nights = ChronoUnit.DAYS.between(checkIn, checkOut);
        double total = nights * room.getPricePerNight();

        // 4. Create Reservation
        Reservation res = new Reservation();
        res.setReservationNumber("RES-" + UUID.randomUUID().toString().substring(0, 8));
        res.setGuestId(guestId);
        res.setRoomId(room.getRoomId());
        res.setCheckIn(checkIn);
        res.setCheckOut(checkOut);
        res.setTotalAmount(total);
        res.setStatus("CONFIRMED"); // Ensure status is set

        boolean saved = reservationDAO.saveReservation(con, res);
        if (!saved) throw new Exception("Reservation Table Insert Failed");

        con.commit();
        handleNotification(guest, res);
        return true;

    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
}
    /**
     * Helper method to handle PDF generation and Email sending
     */
    private void handleNotification(Guest guest, Reservation reservation) {
        try {
            // Generate PDF
            String filePath = "invoices/invoice_" + reservation.getReservationNumber() + ".pdf";
            org.example.hotel.util.PDFGenerator.generateInvoice(filePath, guest, reservation);

            // Prepare Email
            String subject = "Your Hotel Invoice - " + reservation.getReservationNumber();
            String message = "Dear " + guest.getFullName() + ",\n\n" +
                    "Thank you for booking with us. Your reservation is confirmed.\n" +
                    "Please find attached your invoice.\n\n" +
                    "Best regards,\nYour Hotel Team";

            // Send Email
            boolean emailSent = org.example.hotel.util.EmailSender.sendEmailWithAttachment(
                    guest.getEmail(),
                    subject,
                    message,
                    filePath
            );

            if (emailSent) {
                System.out.println("Invoice emailed successfully to: " + guest.getEmail());
            } else {
                System.err.println("Failed to send invoice email.");
            }
        } catch (Exception e) {
            System.err.println("Error during notification: " + e.getMessage());
        }
    }

//    public boolean checkIn(int reservationId, int roomId) {
//        try (Connection con = DBConnection.getConnection()) {
//            con.setAutoCommit(false);
//
//            boolean resStatus = reservationDAO.updateReservationStatus(
//                    con, reservationId, "CHECKED_IN");
//
//            boolean roomStatus = roomDAO.checkInRoom(con, roomId);
//
//            if (!resStatus || !roomStatus)
//                throw new Exception("Check-In Failed");
//
//            con.commit();
//            return true;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }

    public boolean checkIn(int reservationId, int roomId) {
        try (Connection con = DBConnection.getConnection()) {
            con.setAutoCommit(false);

            boolean resStatus = reservationDAO.updateReservationStatus(con, reservationId, "CHECKED_IN");
            boolean roomStatus = roomDAO.checkInRoom(con, roomId);

            System.out.println("Debug - Res Update: " + resStatus + " | Room Update: " + roomStatus);

            if (!resStatus || !roomStatus) {
                con.rollback(); // Undo everything if one fails
                return false;
            }

            con.commit(); // Only saves if BOTH are successful
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean checkOut(int reservationId, int roomId) {
        try (Connection con = DBConnection.getConnection()) {
            con.setAutoCommit(false);

            boolean resStatus = reservationDAO.updateReservationStatus(
                    con, reservationId, "CHECKED_OUT");

            boolean roomStatus = roomDAO.checkOutRoom(con, roomId);

            if (!resStatus || !roomStatus)
                throw new Exception("Check-Out Failed");

            con.commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}