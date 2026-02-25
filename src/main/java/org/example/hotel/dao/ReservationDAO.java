package org.example.hotel.dao;





import org.example.hotel.model.Reservation;

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
}