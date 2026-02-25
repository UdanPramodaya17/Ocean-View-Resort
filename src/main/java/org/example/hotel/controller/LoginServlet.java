package org.example.hotel.controller;



import jakarta.servlet.*;
import jakarta.servlet.http.*;
import org.example.hotel.model.User;
import org.example.hotel.service.AuthService;

import java.io.IOException;

public class LoginServlet extends HttpServlet {

    private AuthService authService = new AuthService();

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = authService.login(username, password);

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            session.setAttribute("role", user.getRole());

            switch (user.getRole()) {
                case "RECEPTION":
                    response.sendRedirect("jsp/reception/dashboard.jsp");
                    break;
                case "ADMIN":
                    response.sendRedirect("jsp/admin/dashboard.jsp");
                    break;
                case "SUPER_ADMIN":
                    response.sendRedirect("jsp/superadmin/dashboard.jsp");
                    break;
            }
        } else {
            request.setAttribute("error", "Invalid Credentials");
            request.getRequestDispatcher("jsp/auth/login.jsp")
                    .forward(request, response);
        }
    }
}