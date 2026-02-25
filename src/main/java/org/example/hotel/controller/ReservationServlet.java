package org.example.hotel.controller;



import jakarta.servlet.*;
import jakarta.servlet.http.*;
import org.example.hotel.dao.ReservationDAO;
import org.example.hotel.model.Reservation;
import org.example.hotel.service.BillingService;

import java.io.IOException;
import java.time.LocalDate;

public class ReservationServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        int guestId = Integer.parseInt(request.getParameter("guestId"));
        int roomId = Integer.parseInt(request.getParameter("roomId"));
        LocalDate checkIn = LocalDate.parse(request.getParameter("checkIn"));
        LocalDate checkOut = LocalDate.parse(request.getParameter("checkOut"));
        double price = Double.parseDouble(request.getParameter("price"));

        BillingService billingService = new BillingService();
        double total = billingService.calculateBill(checkIn, checkOut, price);

        Reservation reservation = new Reservation();
        reservation.setGuestId(guestId);
        reservation.setRoomId(roomId);
        reservation.setCheckIn(checkIn);
        reservation.setCheckOut(checkOut);
        reservation.setTotalAmount(total);

        ReservationDAO dao = new ReservationDAO();

        if (dao.saveReservation(reservation)) {
            response.sendRedirect("jsp/reception/dashboard.jsp");
        } else {
            response.getWriter().println("Error Booking");
        }
    }
}