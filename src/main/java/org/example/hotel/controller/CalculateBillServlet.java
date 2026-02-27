package org.example.hotel.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import org.example.hotel.dao.ReservationDAO;
import org.example.hotel.model.Reservation;

import java.io.IOException;

@WebServlet("/reception/calculateBill")
public class CalculateBillServlet extends HttpServlet {

    private ReservationDAO reservationDAO = new ReservationDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String resNumber = request.getParameter("reservationNumber");

        // 1. Fetch reservation from DB
        Reservation res = reservationDAO.getReservationByNumber(resNumber);

        if (res != null) {
            // 2. Pass the reservation object back to the JSP
            request.setAttribute("bill", res);
        } else {
            request.setAttribute("error", "Reservation Number not found!");
        }

        // 3. Forward back to the same JSP to show the result
        request.getRequestDispatcher("/WEB-INF/reception/calculateBill.jsp")
                .forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Just show the empty page on GET request
        request.getRequestDispatcher("/WEB-INF/reception/calculateBill.jsp")
                .forward(request, response);
    }
}