package org.example.hotel.dao;




import org.example.hotel.model.Guest;
import org.example.hotel.util.DBConnection;

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

    public Guest getGuestById(int guestId) {
        Guest guest = null;
        String sql = "SELECT * FROM guests WHERE guest_id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, guestId);
            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                guest = new Guest();
                guest.setGuestId(rs.getInt("guest_id"));
                guest.setFullName(rs.getString("full_name"));
                guest.setAddress(rs.getString("address"));
                guest.setContactNumber(rs.getString("contact_number"));
                guest.setEmail(rs.getString("email"));
            }

        } catch(Exception e){ e.printStackTrace(); }
        return guest;
    }

    public String getGuestNameById(int guestId) {
        String sql = "SELECT full_name FROM guests WHERE guest_id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, guestId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("full_name");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public boolean updateGuestName(int guestId, String fullName) {
        String sql = "UPDATE guests SET full_name = ? WHERE guest_id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, fullName);
            ps.setInt(2, guestId);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}

