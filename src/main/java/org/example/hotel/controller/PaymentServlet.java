//package org.example.hotel.controller;
//
//
//
//
//
//
//import jakarta.servlet.*;
//import jakarta.servlet.http.*;
//import org.example.hotel.service.PaymentService;
//
//import java.io.IOException;
//
//public class PaymentServlet extends HttpServlet {
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        int reservationId = Integer.parseInt(request.getParameter("reservationId"));
//        double amount = Double.parseDouble(request.getParameter("amount"));
//        String method = request.getParameter("method");
//
//        PaymentService service = new PaymentService();
//        boolean success = service.makePayment(reservationId, amount, method);
//
//        if(success){
//            // PDF already generated inside PaymentService
//            request.setAttribute("message", "Payment Successful! Invoice generated.");
//            request.getRequestDispatcher("jsp/reception/dashboard.jsp").forward(request,response);
//        } else {
//            request.setAttribute("error", "Payment Failed");
//            request.getRequestDispatcher("jsp/reception/dashboard.jsp").forward(request,response);
//        }
//    }
//}

package org.example.hotel.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet; // Added
import org.example.hotel.service.PaymentService;
import org.example.hotel.dao.ReservationDAO; // Added
import org.example.hotel.model.Reservation; // Added

import java.io.IOException;

@WebServlet("/reception/payment") // 1️⃣ Map the URL
public class PaymentServlet extends HttpServlet {

    private ReservationDAO reservationDAO = new ReservationDAO();

    // 2️⃣ Handle the loading of the Payment Page
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int resId = Integer.parseInt(request.getParameter("resId"));
            Reservation res = reservationDAO.getReservationById(resId);

            if (res != null) {
                request.setAttribute("reservation", res);
                // Adjust path to match your folder structure
                request.getRequestDispatcher("/WEB-INF/reception/Payment.jsp").forward(request, response);
            } else {
                response.sendRedirect("reservations?error=NotFound");
            }
        } catch (Exception e) {
            response.sendRedirect("reservations?error=InvalidId");
        }
    }

    // 3️⃣ Handle the actual Payment processing
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int reservationId = Integer.parseInt(request.getParameter("reservationId"));
            double amount = Double.parseDouble(request.getParameter("amount"));
            String method = request.getParameter("method");

            PaymentService service = new PaymentService();
            boolean success = service.makePayment(reservationId, amount, method);

            if (success) {
                request.setAttribute("message", "Payment Successful! Invoice generated and emailed.");
            } else {
                request.setAttribute("error", "Payment processing failed. Please check logs.");
            }

            // 4️⃣ Forward to the Dashboard URL (or reservations list)
            request.getRequestDispatcher("/WEB-INF/reception/dashboard.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "System error during payment.");
            request.getRequestDispatcher("/WEB-INF/reception/dashboard.jsp").forward(request, response);
        }
    }
}