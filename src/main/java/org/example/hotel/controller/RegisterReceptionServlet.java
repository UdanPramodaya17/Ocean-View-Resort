package org.example.hotel.controller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.hotel.service.UserService;

import java.io.IOException;
@WebServlet("/admin/registerReception")
public class RegisterReceptionServlet extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Forward to JSP
        request.getRequestDispatcher("/WEB-INF/admin/registerReception.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        boolean success = userService.registerReceptionUser(username, password);

        if (success) {
            response.sendRedirect(request.getContextPath() + "/admin/registerReception?success=1");
        } else {
            request.setAttribute("error", "Username already exists!");
            request.getRequestDispatcher("/WEB-INF/admin/registerReception.jsp").forward(request, response);
        }
    }
}