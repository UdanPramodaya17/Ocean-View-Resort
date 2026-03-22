package org.example.hotel.controller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.hotel.dao.AdminDAO; // Import your new DAO
import java.io.IOException;
import java.util.Map;

@WebServlet("/admin/dashboard")
public class AdminDashboardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. Fetch statistics from the DAO
        AdminDAO adminDAO = new AdminDAO();
        Map<String, Integer> stats = adminDAO.getDashboardStats();

        // 2. Pass the stats map to the JSP
        request.setAttribute("stats", stats);

        // 3. Forward to the view
        request.getRequestDispatcher("/WEB-INF/admin/dashboard.jsp")
                .forward(request, response);
    }
}