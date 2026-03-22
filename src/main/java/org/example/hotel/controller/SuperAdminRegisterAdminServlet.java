package org.example.hotel.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.hotel.service.UserService;

import java.io.IOException;

@WebServlet("/superadmin/registerAdmin")
public class SuperAdminRegisterAdminServlet extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/superadmin/registerAdmin.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String fullName = request.getParameter("fullName");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String address = request.getParameter("address");

        boolean success = userService.registerAdminUser(fullName, username, password, address);

        if (success) {
            // Fixed redirect URL to match the servlet mapping
            response.sendRedirect(request.getContextPath() + "/superadmin/registerAdmin?success=1");
        } else {
            request.setAttribute("error", "Username already exists or registration failed!");
            request.getRequestDispatcher("/WEB-INF/superadmin/registerAdmin.jsp").forward(request, response);
        }
    }
}