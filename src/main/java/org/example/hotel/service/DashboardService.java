package org.example.hotel.service;


import org.example.hotel.dao.ReservationDAO;
import org.example.hotel.dao.RoomDAO;

public class DashboardService {

    private RoomDAO roomDAO = new RoomDAO();
    private ReservationDAO reservationDAO = new ReservationDAO();

    public int getTotalRooms() {
        return roomDAO.getAllRooms().size();
    }

    public int getAvailableRooms() {
        return roomDAO.getAvailableRooms().size();
    }

//    public int getTotalReservations() {
//        return reservationDAO.getAllReservations().size();
//    }
}