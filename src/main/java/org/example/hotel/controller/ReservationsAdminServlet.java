//package org.example.hotel.controller;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet; // <-- import this
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.example.hotel.dao.ReservationDAO;
//import org.example.hotel.model.Reservation;
//
//import java.io.IOException;
//import java.util.List;
//
//@WebServlet("/admin/reservations") // <-- Map the URL here
//public class ReservationsAdminServlet extends HttpServlet {
//
//    private ReservationDAO reservationDAO = new ReservationDAO();
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        List<Reservation> reservations = reservationDAO.getAllReservations();
//        request.setAttribute("reservations", reservations);
//        request.getRequestDispatcher("/WEB-INF/admin/reservations.jsp")
//                .forward(request, response);
//    }
//}

package org.example.hotel.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.hotel.dao.GuestDAO;
import org.example.hotel.dao.ReservationDAO;
import org.example.hotel.dao.RoomDAO;
import org.example.hotel.model.Reservation;

import java.io.IOException;
import java.util.List;

@WebServlet("/admin/reservations")
public class ReservationsAdminServlet extends HttpServlet {

    private ReservationDAO reservationDAO = new ReservationDAO();
    private GuestDAO guestDAO = new GuestDAO(); // <-- Add this
    private RoomDAO roomDAO = new RoomDAO();    // <-- Add this

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Reservation> reservations = reservationDAO.getAllReservations();

        // Enrich each reservation with Guest Name and Room Type
        for (Reservation r : reservations) {
            r.setGuestName(guestDAO.getGuestNameById(r.getGuestId()));
            r.setRoomType(roomDAO.getRoomTypeById(r.getRoomId()));
        }

        request.setAttribute("reservations", reservations);
        request.getRequestDispatcher("/WEB-INF/admin/reservations.jsp")
                .forward(request, response);
    }
}