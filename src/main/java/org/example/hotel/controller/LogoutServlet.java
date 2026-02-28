package org.example.hotel.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session != null) {
            // PRODUCTION GRADE: Completely kill the session
            session.invalidate();
        }

        // Redirect back to the login page with a message
        response.sendRedirect(request.getContextPath() + "/login-page?message=LoggedOut");
    }
}