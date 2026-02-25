package org.example.hotel.dao;





import org.example.hotel.model.Reservation;
import org.example.hotel.util.DBConnection;

import java.sql.*;

public class ReservationDAO {

    public boolean saveReservation(Connection con, Reservation r) throws SQLException {

        String sql = "INSERT INTO reservations (reservation_number, guest_id, room_id, check_in, check_out, total_amount) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, r.getReservationNumber());
            ps.setInt(2, r.getGuestId());
            ps.setInt(3, r.getRoomId());
            ps.setDate(4, Date.valueOf(r.getCheckIn()));
            ps.setDate(5, Date.valueOf(r.getCheckOut()));
            ps.setDouble(6, r.getTotalAmount());

            return ps.executeUpdate() > 0;
        }
    }


    public boolean isRoomBooked(Connection con,
                                int roomId,
                                Date checkIn,
                                Date checkOut) throws SQLException {

        String sql = "SELECT COUNT(*) FROM reservations " +
                "WHERE room_id = ? " +
                "AND (? < check_out AND ? > check_in)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, roomId);
            ps.setDate(2, checkIn);
            ps.setDate(3, checkOut);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0; // TRUE = Conflict
            }
        }

        return false;
    }

    // Update reservation status
    public boolean updateReservationStatus(Connection con, int reservationId, String status) throws SQLException {
        String sql = "UPDATE reservations SET status=? WHERE reservation_id=?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, status);
            ps.setInt(2, reservationId);
            return ps.executeUpdate() > 0;
        }
    }

    public Reservation getReservationById(int reservationId) {
        Reservation r = null;
        String sql = "SELECT * FROM reservations WHERE reservation_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, reservationId);
            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                r = new Reservation();
                r.setReservationId(rs.getInt("reservation_id"));
                r.setReservationNumber(rs.getString("reservation_number"));
                r.setGuestId(rs.getInt("guest_id"));
                r.setRoomId(rs.getInt("room_id"));
                r.setCheckIn(rs.getDate("check_in").toLocalDate());
                r.setCheckOut(rs.getDate("check_out").toLocalDate());
                r.setTotalAmount(rs.getDouble("total_amount"));
            }

        } catch(Exception e) { e.printStackTrace(); }
        return r;
    }

}
