package org.example.hotel.dao;


import org.example.hotel.model.Reservation;
import org.example.hotel.util.DBConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class ReservationDAO {

    public boolean saveReservation(Reservation r) {

        String sql = "INSERT INTO reservations (guest_id, room_id, check_in, check_out, total_amount) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, r.getGuestId());
            ps.setInt(2, r.getRoomId());
            ps.setDate(3, Date.valueOf(r.getCheckIn()));
            ps.setDate(4, Date.valueOf(r.getCheckOut()));
            ps.setDouble(5, r.getTotalAmount());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}