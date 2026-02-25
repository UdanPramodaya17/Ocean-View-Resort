package org.example.hotel.dao;




import org.example.hotel.model.Guest;

import java.sql.*;

public class GuestDAO {

    public int saveGuest(Connection con, Guest guest) throws SQLException {

        String sql = "INSERT INTO guests (full_name, address, contact_number, email) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, guest.getFullName());
            ps.setString(2, guest.getAddress());
            ps.setString(3, guest.getContactNumber());
            ps.setString(4, guest.getEmail());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1); // return generated guest_id
            }
        }

        return -1;
    }
}