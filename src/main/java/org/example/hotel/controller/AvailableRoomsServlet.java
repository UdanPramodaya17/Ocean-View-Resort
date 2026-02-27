package org.example.hotel.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import org.example.hotel.dao.RoomDAO; // Ensure this import is here
import org.example.hotel.model.Room;

import java.io.IOException;
import java.util.List;

@WebServlet("/reception/available-rooms")
public class AvailableRoomsServlet extends HttpServlet {

    // 1. ADD THIS LINE: This creates the object so you can use it below
    private RoomDAO roomDAO = new RoomDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Now 'roomDAO' is resolved and can be used
        List<Room> availableRooms = roomDAO.getAvailableRooms();
        request.setAttribute("rooms", availableRooms);

        request.getRequestDispatcher("/WEB-INF/reception/availableRooms.jsp")
                .forward(request, response);
    }
}