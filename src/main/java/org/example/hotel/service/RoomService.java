package org.example.hotel.service;

import org.example.hotel.dao.RoomDAO;
import org.example.hotel.model.Room;
import java.io.File;
import java.util.List;

public class RoomService {

    private RoomDAO roomDAO = new RoomDAO();

    // ✅ Add Room with duplicate check
    public boolean addRoom(Room room) {
        if (room.getRoomNumber() == null || room.getRoomNumber().isEmpty()) {
            return false;
        }
        if (roomDAO.roomNumberExists(room.getRoomNumber())) {
            return false; // Duplicate
        }
        return roomDAO.addRoom(room);
    }

    public List<Room> getAllRooms() {
        return roomDAO.getAllRooms();
    }

    public boolean updateRoom(Room room) {
        if (room.getRoomId() <= 0) {
            return false;
        }
        return roomDAO.updateRoom(room);
    }

    // ✅ Enhanced Delete Room (including file cleanup)
    public boolean deleteRoom(int id, String uploadPath) {
        if (id <= 0) {
            return false;
        }

        // 1. Get room details to find the image path
        Room room = roomDAO.getRoomById(id);

        // 2. Delete from Database
        boolean deletedFromDb = roomDAO.deleteRoom(id);

        // 3. If DB delete successful, remove the physical file
        if (deletedFromDb && room != null && room.getImagePath() != null) {
            try {
                // The database stores "uploads/filename.jpg"
                // We need the absolute path to delete it
                File imageFile = new File(uploadPath + File.separator + room.getImagePath().replace("uploads/", ""));
                if (imageFile.exists()) {
                    imageFile.delete();
                }
            } catch (Exception e) {
                System.err.println("Failed to delete image file: " + e.getMessage());
            }
        }

        return deletedFromDb;
    }

    public List<Room> getAvailableRooms() {
        return roomDAO.getAvailableRooms();
    }
}