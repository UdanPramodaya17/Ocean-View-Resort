package org.example.hotel.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import org.example.hotel.model.User;
import org.example.hotel.dao.UserDAO;

import java.io.IOException;

@WebServlet("/reception/edit-profile")
public class EditProfileServlet extends HttpServlet {

    private UserDAO userDAO = new UserDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Ensure user is logged in
        HttpSession session = request.getSession(false);
        User user = (session != null) ? (User) session.getAttribute("user") : null;

        if (user != null) {
            request.getRequestDispatcher("/WEB-INF/reception/edit-profile.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/login-page");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        User sessionUser = (session != null) ? (User) session.getAttribute("user") : null;

        if (sessionUser == null) {
            response.sendRedirect(request.getContextPath() + "/login-page");
            return;
        }

        // Get new details from the form
        String fullName = request.getParameter("fullName");
        String username = request.getParameter("username");
        String address = request.getParameter("address");
        String password = request.getParameter("password");

        // If the user leaves the password blank, keep their old password
        if (password == null || password.trim().isEmpty()) {
            password = sessionUser.getPassword();
        }

        // Update the user object in Java
        sessionUser.setFullName(fullName);
        sessionUser.setUsername(username);
        sessionUser.setAddress(address);
        sessionUser.setPassword(password);

        // Save to Database
        boolean success = userDAO.updateUser(sessionUser);

        if (success) {
            // Update the session with the new details so the profile page reflects them immediately
            session.setAttribute("user", sessionUser);
            response.sendRedirect(request.getContextPath() + "/reception/profile?success=1");
        } else {
            request.setAttribute("error", "Failed to update profile. That username might already be taken.");
            request.getRequestDispatcher("/WEB-INF/reception/edit-profile.jsp").forward(request, response);
        }
    }
}