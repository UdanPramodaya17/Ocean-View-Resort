package org.example.hotel.controller;



import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.hotel.model.User;
import org.example.hotel.service.AuthService;

import java.io.IOException;
@WebServlet("/login")
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
                    request.getRequestDispatcher("/WEB-INF/reception/dashboard.jsp")
                            .forward(request, response);
                    break;

                case "ADMIN":
                    request.getRequestDispatcher("/WEB-INF/admin/dashboard.jsp")
                            .forward(request, response);
                    break;

                case "SUPER_ADMIN":
                    request.getRequestDispatcher("/WEB-INF/superadmin/dashboard.jsp")
                            .forward(request, response);
                    break;
            }
        } else {
            request.setAttribute("error", "Invalid Credentials");
            request.getRequestDispatcher("/auth/login.jsp")
                    .forward(request, response);
        }
    }
}