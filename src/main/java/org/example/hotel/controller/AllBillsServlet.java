package org.example.hotel.controller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.hotel.dao.ReservationDAO;
import org.example.hotel.model.Reservation;

import java.io.IOException;
import java.util.List;

@WebServlet("/superadmin/allBills")
public class AllBillsServlet extends HttpServlet {

    private ReservationDAO reservationDAO = new ReservationDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Fetch all reservations
        List<Reservation> bills = reservationDAO.getAllReservations();
        request.setAttribute("bills", bills);

        // Forward to JSP
        request.getRequestDispatcher("/WEB-INF/superadmin/allBills.jsp")
                .forward(request, response);
    }
}