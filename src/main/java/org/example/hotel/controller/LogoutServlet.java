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

        // Fetch the session, but don't create a new one if it doesn't exist
        HttpSession session = request.getSession(false);

        if (session != null) {
            // This completely destroys the user's session data (role, user object, etc.)
            session.invalidate();
        }

        // Redirect back to the login page with a success message in the URL
        response.sendRedirect(request.getContextPath() + "/login-page?message=LoggedOut");
    }
}