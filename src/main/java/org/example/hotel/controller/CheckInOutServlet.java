package org.example.hotel.controller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.hotel.service.ReservationService;

import java.io.IOException;
@WebServlet("/checkinout")
public class CheckInOutServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int reservationId = Integer.parseInt(request.getParameter("reservationId"));
        int roomId = Integer.parseInt(request.getParameter("roomId"));
        String action = request.getParameter("action");

        ReservationService service = new ReservationService();
        boolean success = false;

        if ("checkin".equals(action)) {
            success = service.checkIn(reservationId, roomId);
        } else if ("checkout".equals(action)) {
            success = service.checkOut(reservationId, roomId);
        }

        if (success) {
            response.sendRedirect("jsp/reception/dashboard.jsp?success=1");
        } else {
            request.setAttribute("error", action + " failed!");
            request.getRequestDispatcher("jsp/reception/dashboard.jsp").forward(request, response);
        }
    }
}