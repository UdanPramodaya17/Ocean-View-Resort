package org.example.hotel.controller;




import jakarta.servlet.*;
import jakarta.servlet.http.*;
import org.example.hotel.model.Guest;
import org.example.hotel.service.ReservationService;

import java.io.IOException;
import java.time.LocalDate;

public class ReservationServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        Guest guest = new Guest();
        guest.setFullName(request.getParameter("fullName"));
        guest.setAddress(request.getParameter("address"));
        guest.setContactNumber(request.getParameter("contact"));
        guest.setEmail(request.getParameter("email"));

        int roomId = Integer.parseInt(request.getParameter("roomId"));
        LocalDate checkIn = LocalDate.parse(request.getParameter("checkIn"));
        LocalDate checkOut = LocalDate.parse(request.getParameter("checkOut"));
        double price = Double.parseDouble(request.getParameter("price"));

        ReservationService service = new ReservationService();

        boolean success = service.createReservation(
                guest, roomId, checkIn, checkOut, price);

        if (success) {
            response.sendRedirect("jsp/reception/dashboard.jsp?success=1");
        } else {
            response.getWriter().println("Reservation Failed");
        }
    }
}