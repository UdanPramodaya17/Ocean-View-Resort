package org.example.hotel.controller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.hotel.dao.GuestDAO;
import org.example.hotel.dao.ReservationDAO;
import org.example.hotel.dao.RoomDAO;
import org.example.hotel.model.Reservation;
import org.example.hotel.service.ReservationService;

import java.io.IOException;
import java.util.List;

//@WebServlet("/reception/reservations")
//public class ReservationsPageServlet extends HttpServlet {
//
//    private ReservationDAO reservationDAO = new ReservationDAO();
//    private GuestDAO guestDAO = new GuestDAO();
//
//    @Override
//    protected void doGet(HttpServletRequest request,
//                         HttpServletResponse response)
//            throws ServletException, IOException {
//
//        try {
//            // Load all reservations
//            List<Reservation> reservations = reservationDAO.getAllReservations();
//
//            // Optional: add guest names
//            for (Reservation r : reservations) {
//                r.setGuestName(guestDAO.getGuestNameById(r.getGuestId()));
//            }
//
//            request.setAttribute("reservations", reservations);
//
//            request.getRequestDispatcher("/WEB-INF/reception/reservations.jsp")
//                    .forward(request, response);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            request.setAttribute("error", "Unable to load reservations.");
//            request.getRequestDispatcher("/WEB-INF/reception/reservations.jsp")
//                    .forward(request, response);
//        }
//    }
//}

//@WebServlet("/reception/reservations")
//public class ReservationsPageServlet extends HttpServlet {
//
//    private ReservationDAO reservationDAO = new ReservationDAO();
//    private GuestDAO guestDAO = new GuestDAO();
//    private RoomDAO roomDAO = new RoomDAO();
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        try {
//            // 1. Get all raw reservations from DB
//            List<Reservation> reservations = reservationDAO.getAllReservations();
//
//            // 2. Enrich the data (Add Guest Names and Room Types)
//            for (Reservation r : reservations) {
//                r.setGuestName(guestDAO.getGuestNameById(r.getGuestId()));
//                r.setRoomType(roomDAO.getRoomTypeById(r.getRoomId()));
//            }
//
//            // 3. Set the attribute for the JSP to find
//            request.setAttribute("reservations", reservations);
//
//            // 4. Forward to the JSP
//            request.getRequestDispatcher("/WEB-INF/reception/reservations.jsp")
//                    .forward(request, response);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//        }
//    }

@WebServlet("/reception/reservations")
public class ReservationsPageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ReservationDAO resDAO = new ReservationDAO();
        GuestDAO guestDAO = new GuestDAO();
        RoomDAO roomDAO = new RoomDAO();

        // 1. Get the raw list of reservations
        List<Reservation> reservations = resDAO.getAllReservations();

        // 2. Loop through and attach the missing names
        if (reservations != null) {
            for (Reservation res : reservations) {
                // Fetch the actual names using the IDs
                String guestName = guestDAO.getGuestNameById(res.getGuestId());
                String roomType = roomDAO.getRoomTypeById(res.getRoomId());

                // Set them in the model so the JSP can read them
                res.setGuestName(guestName != null ? guestName : "Unknown Guest");
                res.setRoomType(roomType != null ? roomType : "Unknown Room");
            }
        }

        // 3. Send the enriched list to the JSP
        request.setAttribute("reservations", reservations);
        request.getRequestDispatcher("/WEB-INF/reception/reservations.jsp").forward(request, response);
    }





}