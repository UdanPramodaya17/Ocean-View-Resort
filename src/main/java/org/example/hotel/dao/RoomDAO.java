package org.example.hotel.dao;


import org.example.hotel.model.Room;
import org.example.hotel.util.DBConnection;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RoomDAO {

    // Add Room
    public boolean addRoom(Room room) {
        String sql = "INSERT INTO rooms (room_number, room_type, price_per_night, amenities, image_path, status) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, room.getRoomNumber());
            ps.setString(2, room.getRoomType());
            ps.setDouble(3, room.getPricePerNight());
            ps.setString(4, room.getAmenities());
            ps.setString(5, room.getImagePath());
            ps.setString(6, room.getStatus());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Get All Rooms
    public List<Room> getAllRooms() {
        List<Room> list = new ArrayList<>();
        String sql = "SELECT * FROM rooms";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Room room = new Room();
                room.setRoomId(rs.getInt("room_id"));
                room.setRoomNumber(rs.getString("room_number"));
                room.setRoomType(rs.getString("room_type"));
                room.setPricePerNight(rs.getDouble("price_per_night"));
                room.setAmenities(rs.getString("amenities"));
                room.setImagePath(rs.getString("image_path"));
                room.setStatus(rs.getString("status"));
                list.add(room);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // Update Room
    public boolean updateRoom(Room room) {
        String sql = "UPDATE rooms SET room_type=?, price_per_night=?, amenities=?, status=? WHERE room_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, room.getRoomType());
            ps.setDouble(2, room.getPricePerNight());
            ps.setString(3, room.getAmenities());
            ps.setString(4, room.getStatus());
            ps.setInt(5, room.getRoomId());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Delete Room
    public boolean deleteRoom(int roomId) {
        String sql = "DELETE FROM rooms WHERE room_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, roomId);
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Get Available Rooms
    public List<Room> getAvailableRooms() {
        List<Room> list = new ArrayList<>();
        String sql = "SELECT * FROM rooms WHERE status='AVAILABLE'";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Room room = new Room();
                room.setRoomId(rs.getInt("room_id"));
                room.setRoomNumber(rs.getString("room_number"));
                room.setRoomType(rs.getString("room_type"));
                room.setPricePerNight(rs.getDouble("price_per_night"));
                room.setAmenities(rs.getString("amenities"));
                room.setImagePath(rs.getString("image_path"));
                room.setStatus(rs.getString("status"));
                list.add(room);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public boolean updateRoomStatus(Connection con, int roomId, String status) throws SQLException {

        String sql = "UPDATE rooms SET status=? WHERE room_id=?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, status);
            ps.setInt(2, roomId);
            return ps.executeUpdate() > 0;
        }
    }
    // Update room status
    public boolean checkInRoom(Connection con, int roomId) throws SQLException {
        return updateRoomStatus(con, roomId, "OCCUPIED");
    }

    public boolean checkOutRoom(Connection con, int roomId) throws SQLException {
        return updateRoomStatus(con, roomId, "AVAILABLE");
    }

    public int getAvailableRoomsByType(Connection con, String roomType, Date checkIn, Date checkOut) throws SQLException {
        // Total rooms of this type
        String sqlTotal = "SELECT quantity FROM rooms WHERE room_type=?";
        int total = 0;

        try (PreparedStatement ps = con.prepareStatement(sqlTotal)) {
            ps.setString(1, roomType);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) total = rs.getInt("quantity");
        }

        // Booked rooms count for selected dates
        String sqlBooked = "SELECT COUNT(*) AS booked FROM reservations r "
                + "JOIN rooms ro ON r.room_id = ro.room_id "
                + "WHERE ro.room_type=? AND (? < r.check_out AND ? > r.check_in)";

        int booked = 0;
        try (PreparedStatement ps = con.prepareStatement(sqlBooked)) {
            ps.setString(1, roomType);
            ps.setDate(2, checkIn);
            ps.setDate(3, checkOut);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) booked = rs.getInt("booked");
        }

        return total - booked; // Available rooms
    }

    public int getFirstAvailableRoomId(Connection con, String roomType, LocalDate checkIn, LocalDate checkOut) throws SQLException {
        String sql = "SELECT ro.room_id FROM rooms ro " +
                "WHERE ro.room_type=? AND ro.status!='FULL' " +
                "ORDER BY ro.room_id ASC LIMIT 1";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, roomType);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return rs.getInt("room_id");
        }
        return -1;
    }

    public String getRoomTypeById(int roomId) {
        String type = "";
        String sql = "SELECT room_type FROM rooms WHERE room_id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, roomId);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) type = rs.getString("room_type");
        } catch(Exception e){ e.printStackTrace(); }
        return type;
    }
}