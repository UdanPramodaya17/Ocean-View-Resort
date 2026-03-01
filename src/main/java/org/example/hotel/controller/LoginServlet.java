package org.example.hotel.controller;



import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.hotel.model.User;
import org.example.hotel.service.AuthService;

import java.io.IOException;
//@WebServlet("/login")
//public class LoginServlet extends HttpServlet {
//
//    private AuthService authService = new AuthService();
//
//    protected void doPost(HttpServletRequest request,
//                          HttpServletResponse response)
//            throws ServletException, IOException {
//
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//
//        User user = authService.login(username, password);
//
//        if (user != null) {
//            HttpSession session = request.getSession();
//            session.setAttribute("user", user);
//            session.setAttribute("role", user.getRole());
//
//            switch (user.getRole()) {
//                case "RECEPTION":
//                    response.sendRedirect(request.getContextPath() + "/reception/dashboard");
//                    break;
//
//                case "ADMIN":
//                    response.sendRedirect(request.getContextPath() + "/admin/dashboard");
//                    break;
//
//                case "SUPER_ADMIN":
//                    response.sendRedirect(request.getContextPath() + "/superadmin/dashboard");
//                    break;
//            }
//        } else {
//            request.setAttribute("error", "Invalid Credentials");
//            request.getRequestDispatcher("/auth/login.jsp")
//                    .forward(request, response);
//        }
//    }
//}

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
            // Create session
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            session.setAttribute("role", user.getRole()); // important for RoleFilter

            // Redirect based on role
            switch (user.getRole()) {
                case "ADMIN":
                    response.sendRedirect(request.getContextPath() + "/admin/dashboard");
                    break;
                case "RECEPTION":
                    response.sendRedirect(request.getContextPath() + "/reception/dashboard");
                    break;
                case "SUPER_ADMIN":
                    response.sendRedirect(request.getContextPath() + "/superadmin/dashboard");
                    break;
                default:
                    response.sendRedirect(request.getContextPath() + "/login-page");
            }
        } else {
            request.setAttribute("error", "Invalid Credentials");
            request.getRequestDispatcher("/WEB-INF/auth/login.jsp")
                    .forward(request, response);
        }
    }
}