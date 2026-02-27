//package org.example.hotel.controller;
//
//
//
//
//import jakarta.servlet.*;
//import jakarta.servlet.http.*;
//import org.example.hotel.model.Guest;
//import org.example.hotel.service.ReservationService;
//import org.example.hotel.model.Room;
//import org.example.hotel.dao.RoomDAO;
//
//import java.io.IOException;
//import java.time.LocalDate;
//
//public class ReservationServlet extends HttpServlet {
//
//    protected void doPost(HttpServletRequest request,
//                          HttpServletResponse response)
//            throws ServletException, IOException {
//
//        Guest guest = new Guest();
//        guest.setFullName(request.getParameter("fullName"));
//        guest.setAddress(request.getParameter("address"));
//        guest.setContactNumber(request.getParameter("contact"));
//        guest.setEmail(request.getParameter("email"));
//
//        int roomId = Integer.parseInt(request.getParameter("roomId"));
//
//        // Get room type from room ID
//        RoomDAO roomDAO = new RoomDAO();
//        Room room = roomDAO.getAllRooms().stream()
//                .filter(r -> r.getRoomId() == roomId)
//                .findFirst()
//                .orElse(null);
//
//        if (room == null) {
//            request.setAttribute("error", "Invalid room ID!");
//            request.getRequestDispatcher("jsp/reception/book-reservation.jsp")
//                    .forward(request, response);
//            return;
//        }
//
//        String roomType = room.getRoomType();
//        LocalDate checkIn = LocalDate.parse(request.getParameter("checkIn"));
//        LocalDate checkOut = LocalDate.parse(request.getParameter("checkOut"));
//        double price = Double.parseDouble(request.getParameter("price"));
//
//        ReservationService service = new ReservationService();
//
//        boolean success = service.createReservation(
//                guest, roomType, checkIn, checkOut, price);
//
//        if (success) {
//            response.sendRedirect("jsp/reception/dashboard.jsp?success=1");
//        } else {
//            request.setAttribute("error",
//                    "Room already booked for selected dates!");
//            request.getRequestDispatcher(
//                    "jsp/reception/book-reservation.jsp"
//            ).forward(request, response);
//        }
//    }
//}




//
//package org.example.hotel.controller;
//
//import jakarta.servlet.*;
//import jakarta.servlet.http.*;
//import jakarta.servlet.annotation.WebServlet;
//
//import org.example.hotel.model.Guest;
//import org.example.hotel.model.Room;
//import org.example.hotel.service.ReservationService;
//import org.example.hotel.dao.RoomDAO;
//
//import java.io.IOException;
//import java.time.LocalDate;
//import java.time.temporal.ChronoUnit;
//
//@WebServlet("/reception/book")
//public class ReservationServlet extends HttpServlet {
//
//    @Override
//    protected void doPost(HttpServletRequest request,
//                          HttpServletResponse response)
//            throws ServletException, IOException {
//
//        try {
//
//            // 1️⃣ Collect Guest
//            Guest guest = new Guest();
//            guest.setFullName(request.getParameter("fullName"));
//            guest.setAddress(request.getParameter("address"));
//            guest.setContactNumber(request.getParameter("contact"));
//            guest.setEmail(request.getParameter("email"));
//
//            // 2️⃣ Room ID
//            int roomId = Integer.parseInt(request.getParameter("roomId"));
//
//            RoomDAO roomDAO = new RoomDAO();
//            Room room = roomDAO.getRoomById(roomId);
//
//            if (room == null) {
//                request.setAttribute("error", "Invalid room selected!");
//                request.getRequestDispatcher("/WEB-INF/reception/book-reservation.jsp")
//                        .forward(request, response);
//                return;
//            }
//
//            // 3️⃣ Dates
//            LocalDate checkIn = LocalDate.parse(request.getParameter("checkIn"));
//            LocalDate checkOut = LocalDate.parse(request.getParameter("checkOut"));
//
//            if (checkOut.isBefore(checkIn) || checkOut.isEqual(checkIn)) {
//                request.setAttribute("error", "Invalid date range!");
//                request.getRequestDispatcher("/WEB-INF/reception/book-reservation.jsp")
//                        .forward(request, response);
//                return;
//            }
//
//            // 4️⃣ Price from DB (NOT from form)
//            double pricePerNight = room.getPricePerNight();
//
//            // 5️⃣ Create Reservation
//            ReservationService service = new ReservationService();
//
//            boolean success = service.createReservation(
//                    guest,
//                    room.getRoomType(),
//                    checkIn,
//                    checkOut,
//                    pricePerNight
//            );
//
//            if (success) {
//                response.sendRedirect(request.getContextPath() +
//                        "/WEB-INF/reception/dashboard.jsp?success=1");
//            } else {
//                request.setAttribute("error",
//                        "Room already booked for selected dates!");
//                request.getRequestDispatcher("/WEB-INF/reception/book-reservation.jsp")
//                        .forward(request, response);
//            }
//
//        } catch (Exception e) {
//            request.setAttribute("error", "Something went wrong!");
//            request.getRequestDispatcher("/WEB-INF/reception/book-reservation.jsp")
//                    .forward(request, response);
//        }
//    }
//}

package org.example.hotel.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

import org.example.hotel.model.Guest;
import org.example.hotel.model.Room;
import org.example.hotel.service.ReservationService;
import org.example.hotel.dao.RoomDAO;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/reception/book")
public class ReservationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            // 1️⃣ Collect Guest Data
            Guest guest = new Guest();
            guest.setFullName(request.getParameter("fullName"));
            guest.setAddress(request.getParameter("address"));
            guest.setContactNumber(request.getParameter("contact"));
            guest.setEmail(request.getParameter("email"));

            // 2️⃣ Get Room Type from JSP (Matched to <select name="roomType">)
            String roomType = request.getParameter("roomType");

            if (roomType == null || roomType.isEmpty()) {
                throw new Exception("Room type selection is required.");
            }

// 3️⃣ Skip fetching Room by ID here, let the Service handle it
// 4️⃣ Dates
            LocalDate checkIn = LocalDate.parse(request.getParameter("checkIn"));
            LocalDate checkOut = LocalDate.parse(request.getParameter("checkOut"));

// 5️⃣ Create Reservation
            ReservationService service = new ReservationService();

// Pass 0.0 for price because the Service will fetch the correct price from DB
            boolean success = service.createReservation(
                    guest,
                    roomType,
                    checkIn,
                    checkOut,
                    0.0
            );
            if (success) {
                // ✅ FIXED: Redirect to a URL, not a WEB-INF path.
                // Assumes you have a Servlet mapped to /reception/dashboard
                response.sendRedirect(request.getContextPath() + "/reception/dashboard?success=1");
            } else {
                request.setAttribute("error", "Room is already booked for these dates!");
                request.getRequestDispatcher("/WEB-INF/reception/book-reservation.jsp").forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace(); // Log the error to console for debugging
            request.setAttribute("error", "Error: " + e.getMessage());
            request.getRequestDispatcher("/WEB-INF/reception/book-reservation.jsp").forward(request, response);
        }
    }
}