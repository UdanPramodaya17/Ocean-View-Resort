package org.example.hotel.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet; // MUST BE IMPORTED
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.hotel.dao.PaymentDAO;
import org.example.hotel.model.Payment;

import java.io.IOException;
import java.util.List;

@WebServlet("/admin/allBills") // MUST BE EXACTLY THIS
public class AdminAllBillsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PaymentDAO dao = new PaymentDAO();
        List<Payment> payments = dao.getAllPayments();

        request.setAttribute("payments", payments);

        // This path must match your file structure exactly
        request.getRequestDispatcher("/WEB-INF/admin/allBills.jsp").forward(request, response);
    }
}