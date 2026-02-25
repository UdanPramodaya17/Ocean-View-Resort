package org.example.hotel.controller;






import jakarta.servlet.*;
import jakarta.servlet.http.*;
import org.example.hotel.service.PaymentService;

import java.io.IOException;

public class PaymentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int reservationId = Integer.parseInt(request.getParameter("reservationId"));
        double amount = Double.parseDouble(request.getParameter("amount"));
        String method = request.getParameter("method");

        PaymentService service = new PaymentService();
        boolean success = service.makePayment(reservationId, amount, method);

        if(success){
            // PDF already generated inside PaymentService
            request.setAttribute("message", "Payment Successful! Invoice generated.");
            request.getRequestDispatcher("jsp/reception/dashboard.jsp").forward(request,response);
        } else {
            request.setAttribute("error", "Payment Failed");
            request.getRequestDispatcher("jsp/reception/dashboard.jsp").forward(request,response);
        }
    }
}