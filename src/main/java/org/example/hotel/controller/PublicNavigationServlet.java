package org.example.hotel.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/home", "/about", "/contact", "/help"})
public class PublicNavigationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = request.getServletPath();
        String targetJsp;

        switch (path) {
            case "/about":
                targetJsp = "/WEB-INF/views/about.jsp";
                break;
            case "/contact":
                targetJsp = "/WEB-INF/views/contact.jsp";
                break;
            case "/help":
                targetJsp = "/WEB-INF/views/help.jsp";
                break;
            case "/home":
            default:
                targetJsp = "/index.jsp"; // Your main home page
                break;
        }

        request.getRequestDispatcher(targetJsp).forward(request, response);
    }
}