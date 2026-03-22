//package org.example.hotel.controller;
//
//
//
//import jakarta.servlet.*;
//import jakarta.servlet.http.*;
//import org.example.hotel.dao.GuestDAO;
//import org.example.hotel.dao.ReservationDAO;
//import org.example.hotel.dao.RoomDAO;
//import org.example.hotel.model.Reservation;
//import com.google.gson.Gson;
//
//import java.io.IOException;
//import java.util.*;
//
//public class CalendarServlet extends HttpServlet {
//
//    private ReservationDAO reservationDAO = new ReservationDAO();
//    private GuestDAO guestDAO = new GuestDAO();
//    private RoomDAO roomDAO = new RoomDAO();
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        List<Reservation> reservations = reservationDAO.getAllReservations();
//        List<Map<String, Object>> events = new ArrayList<>();
//
//        for (Reservation r : reservations) {
//            Map<String, Object> event = new HashMap<>();
//            event.put("title", r.getReservationNumber() + " - " + roomDAO.getRoomTypeById(r.getRoomId()));
//            event.put("start", r.getCheckIn().toString());
//            event.put("end", r.getCheckOut().toString());
//
//            // Color by status
//            switch(r.getStatus()) {
//                case "BOOKED":
//                    event.put("color", "orange");
//                    break;
//                case "CHECKED_IN":
//                    event.put("color", "green");
//                    break;
//                case "CHECKED_OUT":
//                    event.put("color", "gray");
//                    break;
//            }
//            events.add(event);
//        }
//
//        response.setContentType("application/json");
//        String json = new Gson().toJson(events);
//        response.getWriter().write(json);
//    }
//}
package org.example.hotel.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

import org.example.hotel.dao.ReservationDAO;
import org.example.hotel.dao.RoomDAO;
import org.example.hotel.model.Reservation;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.*;

@WebServlet("/calendar")
public class CalendarServlet extends HttpServlet {

    private final ReservationDAO reservationDAO = new ReservationDAO();
    private final RoomDAO roomDAO = new RoomDAO();
    private final Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        List<Reservation> reservations = reservationDAO.getAllReservations();
        List<Map<String, Object>> events = new ArrayList<>();

        for (Reservation r : reservations) {

            Map<String, Object> event = new HashMap<>();

            String roomType = roomDAO.getRoomTypeById(r.getRoomId());

            event.put("title",
                    r.getReservationNumber() + " - " + roomType);

            event.put("start", r.getCheckIn().toString());
            event.put("end", r.getCheckOut().toString());

            switch (r.getStatus()) {
                case "BOOKED":
                    event.put("color", "orange");
                    break;
                case "CHECKED_IN":
                    event.put("color", "green");
                    break;
                case "CHECKED_OUT":
                    event.put("color", "gray");
                    break;
                default:
                    event.put("color", "blue");
            }

            events.add(event);
        }

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(gson.toJson(events));
    }
}