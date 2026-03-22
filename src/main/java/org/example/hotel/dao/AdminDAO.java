package org.example.hotel.dao;

import org.example.hotel.model.Facility;
import org.example.hotel.model.RoomCategory;
import org.example.hotel.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class AdminDAO {

    public boolean addFacility(Facility facility) {
        String sql = "INSERT INTO facilities (name, description) VALUES (?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, facility.getName());
            ps.setString(2, facility.getDescription());
            return ps.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); return false; }
    }

    public boolean addRoomCategory(RoomCategory category) {
        String sql = "INSERT INTO room_categories (name, description) VALUES (?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, category.getName());
            ps.setString(2, category.getDescription());
            return ps.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); return false; }
    }

    public Map<String, Integer> getDashboardStats() {
        Map<String, Integer> stats = new HashMap<>();
        String sqlRooms = "SELECT COUNT(*) FROM rooms";
        String sqlAvailable = "SELECT COUNT(*) FROM rooms WHERE status='AVAILABLE'";
        String sqlFacilities = "SELECT COUNT(*) FROM facilities";
        String sqlCategories = "SELECT COUNT(*) FROM room_categories";

        try (Connection con = DBConnection.getConnection()) {
            // Simple helper to run counts
            stats.put("totalRooms", getCount(con, sqlRooms));
            stats.put("availableRooms", getCount(con, sqlAvailable));
            stats.put("totalFacilities", getCount(con, sqlFacilities));
            stats.put("totalCategories", getCount(con, sqlCategories));
        } catch (Exception e) { e.printStackTrace(); }
        return stats;
    }

    private int getCount(Connection con, String sql) throws SQLException {
        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            return rs.next() ? rs.getInt(1) : 0;
        }
    }
}