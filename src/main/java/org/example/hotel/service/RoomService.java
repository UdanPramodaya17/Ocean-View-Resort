package org.example.hotel.service;





import org.example.hotel.dao.RoomDAO;
import org.example.hotel.model.Room;

import java.util.List;

public class RoomService {

    private RoomDAO roomDAO = new RoomDAO();

    public boolean addRoom(Room room) {
        return roomDAO.addRoom(room);
    }

    public List<Room> getAllRooms() {
        return roomDAO.getAllRooms();
    }

    public boolean updateRoom(Room room) {
        return roomDAO.updateRoom(room);
    }

    public boolean deleteRoom(int id) {
        return roomDAO.deleteRoom(id);
    }

    public List<Room> getAvailableRooms() {
        return roomDAO.getAvailableRooms();
    }
}