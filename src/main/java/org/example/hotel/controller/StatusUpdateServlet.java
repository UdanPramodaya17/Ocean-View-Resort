package org.example.hotel.controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.hotel.service.ReservationService;

import java.io.IOException;

@WebServlet("/reception/statusUpdate")
public class StatusUpdateServlet extends HttpServlet {

    private ReservationService reservationService = new ReservationService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            // 1. Get parameters from the URL
            int resId = Integer.parseInt(request.getParameter("resId"));
            int roomId = Integer.parseInt(request.getParameter("roomId"));
            String action = request.getParameter("action");

            boolean success = false;

            // 2. Call the service logic
            if ("checkin".equals(action)) {
                success = reservationService.checkIn(resId, roomId);
            } else if ("checkout".equals(action)) {
                success = reservationService.checkOut(resId, roomId);
            }

            // 3. Redirect back to the list page to see the changes
            response.sendRedirect(request.getContextPath() + "/reception/reservations?success=" + success);

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/reception/reservations?error=true");
        }
    }
}