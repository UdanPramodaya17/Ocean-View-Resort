//package org.example.hotel.dao;
//
//
//
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Date;
//import org.example.hotel.model.Reservation;
//import org.example.hotel.model.Reservation;
//import org.example.hotel.util.DBConnection;
//
//import java.sql.*;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//public class ReservationDAO {
//
//    public boolean saveReservation(Connection con, Reservation r) throws SQLException {
//
//        String sql = "INSERT INTO reservations (reservation_number, guest_id, room_id, check_in, check_out, total_amount) VALUES (?, ?, ?, ?, ?, ?)";
//
//        try (PreparedStatement ps = con.prepareStatement(sql)) {
//
//            ps.setString(1, r.getReservationNumber());
//            ps.setInt(2, r.getGuestId());
//            ps.setInt(3, r.getRoomId());
//            ps.setDate(4, Date.valueOf(r.getCheckIn()));
//            ps.setDate(5, Date.valueOf(r.getCheckOut()));
//            ps.setDouble(6, r.getTotalAmount());
//
//            return ps.executeUpdate() > 0;
//        }
//    }
//
//
//    public boolean isRoomBooked(Connection con,
//                                int roomId,
//                                Date checkIn,
//                                Date checkOut) throws SQLException {
//
//        String sql = "SELECT COUNT(*) FROM reservations " +
//                "WHERE room_id = ? " +
//                "AND (? < check_out AND ? > check_in)";
//
//        try (PreparedStatement ps = con.prepareStatement(sql)) {
//
//            ps.setInt(1, roomId);
//            ps.setDate(2, checkIn);
//            ps.setDate(3, checkOut);
//
//            ResultSet rs = ps.executeQuery();
//            if (rs.next()) {
//                return rs.getInt(1) > 0; // TRUE = Conflict
//            }
//        }
//
//        return false;
//    }
//
//    // Update reservation status
//    /**
//     * Updates the status of a reservation (e.g., 'CONFIRMED', 'CHECKED_IN', 'CHECKED_OUT')
//     * This version takes a Connection to support database transactions.
//     */
//    public boolean updateReservationDetails(int resId, int roomId, LocalDate checkIn, LocalDate checkOut) {
//        String sql = "UPDATE reservations SET room_id = ?, check_in = ?, check_out = ? WHERE reservation_id = ?";
//        try (Connection con = DBConnection.getConnection();
//             PreparedStatement ps = con.prepareStatement(sql)) {
//            ps.setInt(1, roomId);
//            ps.setDate(2, java.sql.Date.valueOf(checkIn));
//            ps.setDate(3, java.sql.Date.valueOf(checkOut));
//            ps.setInt(4, resId);
//            return ps.executeUpdate() > 0;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//    public Reservation getReservationByNumber(String resNumber) {
//        Reservation r = null;
//        // Note: Using lowercase for PostgreSQL compatibility
//        String sql = "SELECT * FROM reservations WHERE reservation_number = ?";
//
//        try (Connection con = org.example.hotel.util.DBConnection.getConnection();
//             PreparedStatement ps = con.prepareStatement(sql)) {
//
//            ps.setString(1, resNumber);
//            ResultSet rs = ps.executeQuery();
//
//            if (rs.next()) {
//                r = new Reservation();
//                r.setReservationId(rs.getInt("reservation_id"));
//                r.setReservationNumber(rs.getString("reservation_number"));
//                r.setGuestId(rs.getInt("guest_id"));
//                r.setRoomId(rs.getInt("room_id"));
//
//                // Convert SQL Date to LocalDate
//                java.sql.Date checkInDate = rs.getDate("check_in");
//                if (checkInDate != null) r.setCheckIn(checkInDate.toLocalDate());
//
//                java.sql.Date checkOutDate = rs.getDate("check_out");
//                if (checkOutDate != null) r.setCheckOut(checkOutDate.toLocalDate());
//
//                r.setTotalAmount(rs.getDouble("total_amount"));
//                r.setStatus(rs.getString("status"));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return r;
//    }
////    public Reservation getReservationById(int reservationId) {
////        Reservation r = null;
////        String sql = "SELECT * FROM reservations WHERE reservation_id=?";
////
////        try (Connection con = DBConnection.getConnection();
////             PreparedStatement ps = con.prepareStatement(sql)) {
////
////            ps.setInt(1, reservationId);
////            ResultSet rs = ps.executeQuery();
////
////            if(rs.next()) {
////                r = new Reservation();
////                r.setReservationId(rs.getInt("reservation_id"));
////                r.setReservationNumber(rs.getString("reservation_number"));
////                r.setGuestId(rs.getInt("guest_id"));
////                r.setRoomId(rs.getInt("room_id"));
////                r.setCheckIn(rs.getDate("check_in").toLocalDate());
////                r.setCheckOut(rs.getDate("check_out").toLocalDate());
////                r.setTotalAmount(rs.getDouble("total_amount"));
////            }
////
////        } catch(Exception e) { e.printStackTrace(); }
////        return r;
////    }
////    public List<Reservation> getAllReservations() {
////        List<Reservation> reservations = new ArrayList<>();
////        String sql = "SELECT * FROM reservations";
////
////        try (Connection con = DBConnection.getConnection();
////             PreparedStatement ps = con.prepareStatement(sql);
////             ResultSet rs = ps.executeQuery()) {
////
////            while (rs.next()) {
////                Reservation r = new Reservation();
////                r.setReservationId(rs.getInt("reservation_id"));
////                r.setReservationNumber(rs.getString("reservation_number"));
////                r.setGuestId(rs.getInt("guest_id"));
////                r.setRoomId(rs.getInt("room_id"));
////                r.setCheckIn(rs.getDate("check_in").toLocalDate());
////                r.setCheckOut(rs.getDate("check_out").toLocalDate());
////                r.setTotalAmount(rs.getDouble("total_amount"));
////                r.setStatus(rs.getString("status")); // Make sure Reservation model has 'status'
////                reservations.add(r);
////            }
////
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////        return reservations;
////    }
//
//
//    public List<Reservation> getAllReservations() {
//        List<Reservation> list = new ArrayList<>();
//        String sql = "SELECT * FROM reservations ORDER BY reservation_id DESC";
//
//        try (Connection con = DBConnection.getConnection();
//             PreparedStatement ps = con.prepareStatement(sql);
//             ResultSet rs = ps.executeQuery()) {
//
//            while (rs.next()) {
//                Reservation r = new Reservation();
//                r.setReservationId(rs.getInt("reservation_id"));
//                r.setReservationNumber(rs.getString("reservation_number"));
//                r.setGuestId(rs.getInt("guest_id"));
//                r.setRoomId(rs.getInt("room_id"));
//                r.setCheckIn(rs.getDate("check_in").toLocalDate());
//                r.setCheckOut(rs.getDate("check_out").toLocalDate());
//                r.setTotalAmount(rs.getDouble("total_amount"));
//                r.setStatus(rs.getString("status"));
//                list.add(r);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
//
//    public boolean updateReservationStatus(Connection con, int reservationId, String status) throws SQLException {
//        // Make sure 'status' matches your MySQL column name exactly!
//        String sql = "UPDATE reservations SET status = ? WHERE reservation_id = ?";
//        try (PreparedStatement ps = con.prepareStatement(sql)) {
//            ps.setString(1, status);
//            ps.setInt(2, reservationId);
//            int rowsAffected = ps.executeUpdate();
//            System.out.println("Reservation update rows: " + rowsAffected); // Debugging
//            return rowsAffected > 0;
//        }
//    }
//}



package org.example.hotel.dao;

import org.example.hotel.model.Reservation;
import org.example.hotel.util.DBConnection;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReservationDAO {

    // --- Create/Save ---
    public boolean saveReservation(Connection con, Reservation r) throws SQLException {
        String sql = "INSERT INTO reservations (reservation_number, guest_id, room_id, check_in, check_out, total_amount, status) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, r.getReservationNumber());
            ps.setInt(2, r.getGuestId());
            ps.setInt(3, r.getRoomId());
            ps.setDate(4, Date.valueOf(r.getCheckIn()));
            ps.setDate(5, Date.valueOf(r.getCheckOut()));
            ps.setDouble(6, r.getTotalAmount());
            ps.setString(7, "CONFIRMED");
            return ps.executeUpdate() > 0;
        }
    }

    // --- Search Methods (Crucial for Payment and Bill calculation) ---

    public Reservation getReservationById(int reservationId) {
        String sql = "SELECT * FROM reservations WHERE reservation_id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, reservationId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return mapResultSetToReservation(rs);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }

    public Reservation getReservationByNumber(String resNumber) {
        String sql = "SELECT * FROM reservations WHERE reservation_number = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, resNumber);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return mapResultSetToReservation(rs);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }

    // --- List Methods ---
    public List<Reservation> getAllReservations() {
        List<Reservation> list = new ArrayList<>();
        String sql = "SELECT * FROM reservations ORDER BY reservation_id DESC";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(mapResultSetToReservation(rs));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    // --- Update Methods ---
    public boolean updateReservationStatus(Connection con, int resId, String status) throws SQLException {
        String sql = "UPDATE reservations SET status = ? WHERE reservation_id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, status);
            ps.setInt(2, resId);
            return ps.executeUpdate() > 0;
        }
    }

    public boolean updateReservationDetails(int resId, int roomId, LocalDate checkIn, LocalDate checkOut) {
        String sql = "UPDATE reservations SET room_id = ?, check_in = ?, check_out = ? WHERE reservation_id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, roomId);
            ps.setDate(2, Date.valueOf(checkIn));
            ps.setDate(3, Date.valueOf(checkOut));
            ps.setInt(4, resId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); return false; }
    }

    // --- Helper to reduce code duplication ---
    private Reservation mapResultSetToReservation(ResultSet rs) throws SQLException {
        Reservation r = new Reservation();
        r.setReservationId(rs.getInt("reservation_id"));
        r.setReservationNumber(rs.getString("reservation_number"));
        r.setGuestId(rs.getInt("guest_id"));
        r.setRoomId(rs.getInt("room_id"));
        r.setCheckIn(rs.getDate("check_in").toLocalDate());
        r.setCheckOut(rs.getDate("check_out").toLocalDate());
        r.setTotalAmount(rs.getDouble("total_amount"));
        r.setStatus(rs.getString("status"));
        return r;
    }
}