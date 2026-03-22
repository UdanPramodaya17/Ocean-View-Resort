package org.example.hotel.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import org.example.hotel.model.User;
import java.io.IOException;

@WebServlet("/reception/profile")
public class ProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");

        if (user != null) {
            // Forward to the physical JSP file in WEB-INF
            request.getRequestDispatcher("/WEB-INF/reception/profile.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/login-page");
        }
    }
}