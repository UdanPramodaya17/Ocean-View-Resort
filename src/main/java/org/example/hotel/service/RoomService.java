//package org.example.hotel.service;
//
//
//
//
//
//import org.example.hotel.dao.RoomDAO;
//import org.example.hotel.model.Room;
//
//import java.util.List;
//
//public class RoomService {
//
//    private RoomDAO roomDAO = new RoomDAO();
//
//    public boolean addRoom(Room room) {
//        return roomDAO.addRoom(room);
//    }
//
//    public List<Room> getAllRooms() {
//        return roomDAO.getAllRooms();
//    }
//
//    public boolean updateRoom(Room room) {
//        return roomDAO.updateRoom(room);
//    }
//
//    public boolean deleteRoom(int id) {
//        return roomDAO.deleteRoom(id);
//    }
//
//    public List<Room> getAvailableRooms() {
//        return roomDAO.getAvailableRooms();
//    }
//}


package org.example.hotel.service;

import org.example.hotel.dao.RoomDAO;
import org.example.hotel.model.Room;

import java.util.List;

public class RoomService {

    private RoomDAO roomDAO = new RoomDAO();

    // ✅ Add Room with duplicate check
    public boolean addRoom(Room room) {

        // Validate required fields
        if (room.getRoomNumber() == null || room.getRoomNumber().isEmpty()) {
            return false;
        }

        // Check if room number already exists
        if (roomDAO.roomNumberExists(room.getRoomNumber())) {
            return false;  // Duplicate
        }

        return roomDAO.addRoom(room);
    }

    // ✅ Get all rooms
    public List<Room> getAllRooms() {
        return roomDAO.getAllRooms();
    }

    // ✅ Update room
    public boolean updateRoom(Room room) {

        if (room.getRoomId() <= 0) {
            return false;
        }

        return roomDAO.updateRoom(room);
    }

    // ✅ Delete room
    public boolean deleteRoom(int id) {

        if (id <= 0) {
            return false;
        }

        return roomDAO.deleteRoom(id);
    }

    // ✅ Get available rooms
    public List<Room> getAvailableRooms() {
        return roomDAO.getAvailableRooms();
    }
}