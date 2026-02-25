package org.example.hotel.controller;



import jakarta.servlet.*;
import jakarta.servlet.http.*;
import org.example.hotel.dao.GuestDAO;
import org.example.hotel.dao.ReservationDAO;
import org.example.hotel.dao.RoomDAO;
import org.example.hotel.model.Reservation;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.*;

public class CalendarServlet extends HttpServlet {

    private ReservationDAO reservationDAO = new ReservationDAO();
    private GuestDAO guestDAO = new GuestDAO();
    private RoomDAO roomDAO = new RoomDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Reservation> reservations = reservationDAO.getAllReservations();
        List<Map<String, Object>> events = new ArrayList<>();

        for (Reservation r : reservations) {
            Map<String, Object> event = new HashMap<>();
            event.put("title", r.getReservationNumber() + " - " + roomDAO.getRoomTypeById(r.getRoomId()));
            event.put("start", r.getCheckIn().toString());
            event.put("end", r.getCheckOut().toString());

            // Color by status
            switch(r.getStatus()) {
                case "BOOKED":
                    event.put("color", "orange");
                    break;
                case "CHECKED_IN":
                    event.put("color", "green");
                    break;
                case "CHECKED_OUT":
                    event.put("color", "gray");
                    break;
            }
            events.add(event);
        }

        response.setContentType("application/json");
        String json = new Gson().toJson(events);
        response.getWriter().write(json);
    }
}
